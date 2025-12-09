package com.example.appstresswatch

import android.util.Log
import com.example.appstresswatch.connection.RetrofitSensores
import com.example.appstresswatch.models.SensorPayload
import com.example.appstresswatch.session.SessionManager
import com.google.android.gms.wearable.WearableListenerService
import com.google.android.gms.wearable.MessageEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

class WearMessageListenerService : WearableListenerService() {

    override fun onCreate() {
        super.onCreate()
        SessionManager.init(applicationContext)
    }

    override fun onMessageReceived(messageEvent: MessageEvent) {

        if (messageEvent.path == "/sensor_data") {

            val jsonString = String(messageEvent.data)
            val jsonObj = JSONObject(jsonString)

            val userId = SessionManager.userId ?: run {
                Log.w("WearMsgListener", "❌ No userId found.")
                return
            }

            val payload = SensorPayload(
                userId = userId,
                heartRate = jsonObj.optInt("heartRate"),
                light = jsonObj.optDouble("light").toFloat(),
                gyro = jsonObj.optDouble("gyro").toFloat(),
                timestamp = jsonObj.optLong("timestamp")
            )

            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val response = RetrofitSensores.api.sendSensorData(payload)
                    Log.d("WearMsgListener", "Sensor sent OK: $response")
                } catch (e: Exception) {
                    Log.e("WearMsgListener", "Error sending sensor data: ${e.message}")
                }
            }
        }
    }
}
