package com.example.appstresswatch.presentation

import android.app.Application
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.math.sqrt

class SensorViewModel(application: Application) :
    AndroidViewModel(application), SensorEventListener {

    private val sensorManager =
        application.getSystemService(SensorManager::class.java)

    private val _state = MutableStateFlow(SensorState())
    val state = _state.asStateFlow()

    init {
        register()
    }

    private fun register() {
        sensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE)?.also {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
        }
        sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)?.also {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
        }
        sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)?.also {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_GAME)
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        event ?: return

        when (event.sensor.type) {
            Sensor.TYPE_HEART_RATE ->
                _state.update { it.copy(heartRate = event.values[0].toInt()) }

            Sensor.TYPE_LIGHT ->
                _state.update { it.copy(light = event.values[0].toInt()) }

            Sensor.TYPE_GYROSCOPE -> {
                val mag = sqrt(
                    event.values[0] * event.values[0] +
                            event.values[1] * event.values[1] +
                            event.values[2] * event.values[2]
                )
                _state.update { it.copy(gyro = mag) }
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
}

data class SensorState(
    val heartRate: Int? = null,
    val light: Int? = null,
    val gyro: Float? = null
)
