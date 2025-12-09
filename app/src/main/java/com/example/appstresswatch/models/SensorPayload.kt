package com.example.appstresswatch.models


import kotlinx.serialization.Serializable

@Serializable
data class SensorPayload(
    val userId: String? = null,
    val heartRate: Int? = null,
    val light: Float? = null,
    val gyro: Float? = null,
    val timestamp: Long? = null
)