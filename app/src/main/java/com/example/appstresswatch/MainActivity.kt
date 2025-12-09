package com.example.appstresswatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.appstresswatch.navigation.NavGraph

class MainActivity : ComponentActivity() {

    private lateinit var wearReceiver: WearMessageReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 👉 Inicializar listener que escucha datos del reloj
        wearReceiver = WearMessageReceiver(
            context = this,
            onSensorData = { data ->
                // Aquí recibes los datos del reloj en tiempo real
                // Puedes enviarlos al backend o a un ViewModel
                android.util.Log.d(
                    "WearData",
                    "Heart=${data.heartRate}, Light=${data.light}, Gyro=${data.gyro}"
                )
            }
        )

        setContent {
            NavGraph()
        }
    }

    override fun onStart() {
        super.onStart()
        wearReceiver.register()  // 👉 Activa el listener
    }

    override fun onStop() {
        super.onStop()
        wearReceiver.unregister()  // 👉 Evita memoria y consumo extra
    }
}
