package com.example.appstresswatch.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appstresswatch.models.LoginRequest
import com.example.appstresswatch.repository.UserRepository
import com.example.appstresswatch.session.SessionManager
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val repository = UserRepository()

    var correo by mutableStateOf("")
    var password by mutableStateOf("")

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    var successMessage by mutableStateOf<String?>(null)
        private set

    /**
     * onSuccess recibe:
     *   - userId
     *   - token
     */
    fun loginUser(
        onSuccess: (String, String) -> Unit,   // userId + token
        onError: (String) -> Unit
    ) {

        val loginRequest = LoginRequest(
            usuario = correo,
            password = password
        )

        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            successMessage = null

            try {
                val response = repository.login(loginRequest)

                if (response.ok) {

                    val userId = response.usuario.id ?: ""
                    val token = response.token ?: ""

                    // ✔ Guardar sesión para usarla en WearMessageListenerService
                    SessionManager.userId = userId
                    SessionManager.token = token

                    successMessage = "Inicio de sesión exitoso"

                    // ✔ Mandar valores al composable
                    onSuccess(userId, token)

                } else {
                    val msg = "Credenciales incorrectas"
                    errorMessage = msg
                    onError(msg)
                }

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
