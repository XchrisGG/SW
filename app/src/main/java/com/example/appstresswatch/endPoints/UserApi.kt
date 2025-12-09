package com.example.appstresswatch.endPoints

import com.example.appstresswatch.models.RegisterResponse
import com.example.appstresswatch.models.User
import com.example.appstresswatch.models.UserLogin
import com.example.appstresswatch.models.UserRegister
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("register")
    suspend fun registerUser(@Body user: UserRegister): RegisterResponse
   /* @POST("login")
    suspend fun loginUser(@Body user: UserLogin): LoginResponse
*/
}