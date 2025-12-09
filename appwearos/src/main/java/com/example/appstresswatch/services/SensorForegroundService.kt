package com.example.appstresswatch.services

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import com.example.appstresswatch.R
import com.example.appstresswatch.WearMessageSender
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.math.sqrt

class SensorForegroundService : Service(), SensorEventListener {
    private val TAG = "SensorFGService"
    private lateinit var sensorManager: SensorManager
    private var heartSensor: Sensor? = null
    private var lightSensor: Sensor? = null
    private var gyroSensor: Sensor? = null

    private var heartRate: Int? = null
    private var lightLevel: Int? = null
    private var gyroMagnitude: Float? = null

    private var sendJob: Job? = null
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    // configurable: intervalo de envío (ms)
    private val sendIntervalMs = 3000L
    private val messagePath = "/sensor_data" // path común

    override fun onCreate() {
        super.onCreate()
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        heartSensor = sensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE)
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        gyroSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (!permissionsGranted()) {
            // stop if required permissions are missing
            Log.w(TAG, "BODY_SENSORS permission not granted - stopping service")
            stopSelf()
            return START_NOT_STICKY
        }

        startForegroundWithNotification()
        registerSensors()
        startSendingLoop()
        return START_STICKY
    }

    private fun permissionsGranted(): Boolean {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.BODY_SENSORS) == PackageManager.PERMISSION_GRANTED
    }

    private fun startForegroundWithNotification() {
        val channelId = createNotificationChannel()
        val notification: Notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle("Sensor service")
            .setContentText("Enviando datos al teléfono")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setOngoing(true)
            .build()
        startForeground(1, notification)
    }

    private fun createNotificationChannel(): String {
        val channelId = "sensor_service_channel"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val nm = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val channel = NotificationChannel(channelId, "Sensor Service", NotificationManager.IMPORTANCE_LOW)
            nm.createNotificationChannel(channel)
        }
        return channelId
    }

    private fun registerSensors() {
        heartSensor?.let { sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL) }
        lightSensor?.let { sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL) }
        gyroSensor?.let { sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_GAME) }
    }

    private fun unregisterSensors() {
        sensorManager.unregisterListener(this)
    }

    private fun startSendingLoop() {
        sendJob?.cancel()
        sendJob = scope.launch {
            while (isActive) {
                try {
                    val payload = buildPayload()
                    val json = Json.encodeToString(payload)
                    Log.d(TAG, "Payload: $json")
                    WearMessageSender.sendToPhone(applicationContext, messagePath, json.toByteArray())
                } catch (t: Throwable) {
                    Log.e(TAG, "Error in send loop: ${t.message}", t)
                }
                delay(sendIntervalMs)
            }
        }
    }

    private fun buildPayload(): SensorPayload {
        return SensorPayload(
            heartRate = heartRate,
            light = lightLevel,
            gyro = gyroMagnitude,
            timestamp = System.currentTimeMillis()
        )
    }

    override fun onDestroy() {
        sendJob?.cancel()
        unregisterSensors()
        scope.cancel()
        super.onDestroy()
    }

    // --- SensorEventListener ---
    override fun onSensorChanged(event: SensorEvent?) {
        event ?: return
        when (event.sensor.type) {
            Sensor.TYPE_HEART_RATE -> {
                val value = event.values[0].toInt()
                if (value > 0) heartRate = value
            }
            Sensor.TYPE_LIGHT -> {
                lightLevel = event.values[0].toInt()
            }
            Sensor.TYPE_GYROSCOPE -> {
                val x = event.values[0]
                val y = event.values[1]
                val z = event.values[2]
                val mag = sqrt(x * x + y * y + z * z)
                gyroMagnitude = mag
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

    override fun onBind(intent: Intent?): IBinder? = null
}

@Serializable
data class SensorPayload(
    val heartRate: Int? = null,
    val light: Int? = null,
    val gyro: Float? = null,
    val timestamp: Long
)