package com.example.appstresswatch.repository

import com.example.appstresswatch.conection.RetrofitInstance
import com.example.appstresswatch.models.LoginRequest
import com.example.appstresswatch.models.LoginResponse
import com.example.appstresswatch.models.RegisterResponse

import com.example.appstresswatch.models.UserRegister

class UserRepository {

    // REGISTRO DE USUARIO
    suspend fun register(user: UserRegister): RegisterResponse {
        return RetrofitInstance.api.registerUser(user)
    }

    // LOGIN
    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return RetrofitInstance.api.loginUser(loginRequest)
    }


 /*   // OBTENER UN USUARIO POR ID
    suspend fun getUserById(id: String): User {
        return RetrofitInstance.api.getUserById(id)
    }

    // ACTUALIZAR USUARIO
    suspend fun updateUser(id: String, user: User): User {
        return RetrofitInstance.api.updateUser(id, user)
    }

    // ELIMINAR USUARIO
    suspend fun deleteUser(id: String) {
        RetrofitInstance.api.deleteUser(id)
    }

  */
}
