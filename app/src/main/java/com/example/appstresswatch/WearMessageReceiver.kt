package com.example.appstresswatch

import android.content.Context
import android.util.Log
import com.example.appstresswatch.models.SensorPayload
import com.google.android.gms.wearable.MessageClient
import com.google.android.gms.wearable.MessageEvent
import com.google.android.gms.wearable.Wearable
import kotlinx.serialization.json.Json

class WearMessageReceiver(
    private val context: Context,
    private val onSensorData: (SensorPayload) -> Unit
) : MessageClient.OnMessageReceivedListener {

    private val jsonParser = Json {
        ignoreUnknownKeys = true // ignora campos extra que puedan venir del móvil
    }

    override fun onMessageReceived(event: MessageEvent) {
        if (event.path != "/sensor_data") return

        try {
            val jsonString = String(event.data)
            val payload = jsonParser.decodeFromString<SensorPayload>(jsonString)
            onSensorData(payload)
        } catch (e: Exception) {
            Log.e("WearReceiver", "Error parseando JSON: ${e.message}")
        }
    }

    fun register() {
        Wearable.getMessageClient(context).addListener(this)
    }

    fun unregister() {
        Wearable.getMessageClient(context).removeListener(this)
    }
}
