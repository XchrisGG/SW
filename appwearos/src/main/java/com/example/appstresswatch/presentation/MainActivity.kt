package com.example.appstresswatch.presentation

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*

import androidx.wear.compose.material.*
import com.example.appstresswatch.presentation.theme.AppStressWatchTheme
import com.example.appstresswatch.services.SensorForegroundService

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestSensorPermission()

        setContent {
            AppStressWatchTheme {
                MainScreen(
                    startService = ::startSensorService,
                    stopService = ::stopSensorService
                )
            }
        }
    }

    private fun requestSensorPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.BODY_SENSORS)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.BODY_SENSORS),
                1001
            )
        }
    }

    private fun startSensorService() {
        val intent = Intent(this, SensorForegroundService::class.java)
        startForegroundService(intent)
    }

    private fun stopSensorService() {
        stopService(Intent(this, SensorForegroundService::class.java))
    }
}
