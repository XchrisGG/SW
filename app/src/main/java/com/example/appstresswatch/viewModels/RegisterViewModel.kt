package com.example.appstresswatch.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appstresswatch.models.UserRegister
import com.example.appstresswatch.repository.UserRepository
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    private val repository = UserRepository()

    // DATOS DEL USUARIO (estas variables van llenándose entre pantallas)

    var nombre by mutableStateOf("")
    var apellido by mutableStateOf("")

    var edad by mutableStateOf("")
    var sexo by mutableStateOf("")
    var fechaNacimiento by mutableStateOf("")
    var pais by mutableStateOf("")
    var correo by mutableStateOf("")
    var password by mutableStateOf("")

    var avatarIndex by mutableStateOf(0)


    // ESTADO PARA MOSTRAR RESULTADOS EN LA UI
    var isLoading by mutableStateOf(false)
        private set

    var successMessage by mutableStateOf<String?>(null)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    // FUNCIÓN FINAL PARA REGISTRAR AL USUARIO
    fun registerUser(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        val user = UserRegister(
            nombre = nombre,
            apellido = apellido,
            edad = edad,
            sexo = sexo,
            fechaNacimiento = fechaNacimiento,
            pais = pais,
            usuario = correo,
            password = password,
            avatarIndex = avatarIndex
        )

        viewModelScope.launch {
            isLoading = true
            successMessage = null
            errorMessage = null

            try {
                repository.register(user)
                successMessage = "Usuario registrado correctamente"
                onSuccess()
            } catch (e: Exception) {
                val msg = e.message ?: "Error desconocido"
                errorMessage = msg
                onError(msg)
            } finally {
                isLoading = false
            }
        }
    }


}
