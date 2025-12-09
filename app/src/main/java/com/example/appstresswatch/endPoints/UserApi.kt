package com.example.appstresswatch.endPoints

import com.example.appstresswatch.models.LoginRequest
import com.example.appstresswatch.models.LoginResponse
import com.example.appstresswatch.models.RegisterResponse

import com.example.appstresswatch.models.UserRegister
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("register")
    suspend fun registerUser(@Body user: UserRegister): RegisterResponse
    @POST("login")
    suspend fun loginUser(@Body loginRequest: LoginRequest): LoginResponse


}