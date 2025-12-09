package com.example.appstresswatch.endPoints

import com.example.appstresswatch.models.SensorPayload
import com.example.appstresswatch.models.SensorResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface SensorApi {
    @POST("sensores")
    suspend fun sendSensorData(@Body payload: SensorPayload): SensorResponse
}
