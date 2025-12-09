package com.example.appstresswatch.connection

import com.example.appstresswatch.endPoints.SensorApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.getValue

object RetrofitSensores {

    private const val SENSOR_BASE_URL = "https://backendstresswatch.onrender.com/api/"

    val api: SensorApi by lazy {
        Retrofit.Builder()
            .baseUrl(SENSOR_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SensorApi::class.java)
    }
}
