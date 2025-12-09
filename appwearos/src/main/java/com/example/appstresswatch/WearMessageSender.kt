package com.example.appstresswatch

import android.content.Context
import android.util.Log
import com.google.android.gms.tasks.Tasks
import com.google.android.gms.wearable.Wearable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object WearMessageSender {
    private const val TAG = "WearMessageSender"

    /**
     * Busca el primer nodo conectado y envía el mensaje (payload bytes).
     * Retorna true si el envío fue éxitoso.
     */
    suspend fun sendToPhone(context: Context, path: String, payload: ByteArray): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val nodes = Tasks.await(Wearable.getNodeClient(context).connectedNodes)
                if (nodes.isEmpty()) {
                    Log.w(TAG, "No nodes connected")
                    return@withContext false
                }
                val node = nodes.first()
                Log.d(TAG, "Sending to node ${node.displayName} (${node.id})")
                val sendTask = Wearable.getMessageClient(context)
                    .sendMessage(node.id, path, payload)
                Tasks.await(sendTask)
                Log.d(TAG, "Message sent successfully")
                true
            } catch (t: Throwable) {
                Log.e(TAG, "Failed to send message: ${t.message}", t)
                false
            }
        }
    }
}