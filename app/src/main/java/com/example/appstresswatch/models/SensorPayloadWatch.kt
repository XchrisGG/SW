package com.example.appstresswatch.models

data class SensorPayloadWatch(
    val heartRate: Int,
    val light: Float,
    val gyro: Float,
    val timestamp: Long
)