

package com.example.appstresswatch.presentation

import android.Manifest
import android.app.Application
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TimeText
import androidx.wear.tooling.preview.devices.WearDevices
import com.example.appstresswatch.presentation.theme.AppStressWatchTheme

@Composable
fun MainScreen(viewModel: SensorViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {

    val state = viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "Sensores en tiempo real")

        Spacer(modifier = Modifier.height(16.dp))

        Text("Heart: ${state.value.heartRate ?: "--"}")
        Text("Light: ${state.value.light ?: "--"}")
        Text("Gyro: ${state.value.gyro ?: "--"}")

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            val intent = Intent(
                viewModel.getApplication(),
                com.example.appstresswatch.services.SensorForegroundService::class.java
            )
            intent.action = "START"
            viewModel.getApplication<Application>().startForegroundService(intent)
        }) {
            Text("Start Service")
        }

        Button(onClick = {
            val intent = Intent(
                viewModel.getApplication(),
                com.example.appstresswatch.services.SensorForegroundService::class.java
            )
            viewModel.getApplication<Application>().stopService(intent)
        }) {
            Text("Stop Service")
        }
    }
}

// -----------------------------
// PREVIEW + EXTRA UI
// -----------------------------

@Composable
fun WearApp(greetingName: String) {
    AppStressWatchTheme {     // ← CORREGIDO
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            TimeText()
            Greeting(greetingName)
        }
    }
}

@Composable
fun Greeting(greetingName: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.primary,
        text = "Hola, $greetingName"
    )
}

@Preview(device = WearDevices.SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    WearApp("Preview")
}
