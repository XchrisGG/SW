package com.example.appstresswatch.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appstresswatch.components.CustomPasswordTextField
import com.example.appstresswatch.components.CustomTextField
import com.example.appstresswatch.components.NavigationBar
import com.example.appstresswatch.ui.theme.StressDarkBlue
import com.example.appstresswatch.ui.theme.StressGray
import com.example.appstresswatch.viewModel.LoginViewModel

@Composable
fun LoginScreen2(
    viewModel: LoginViewModel,
    onBack: () -> Unit,
    onLoginSuccess: (String, String) -> Unit) {

    val correo = viewModel.correo
    val password = viewModel.password
    val errorMessage = viewModel.errorMessage

    Scaffold(
        bottomBar = {
            NavigationBar(
                onBack = onBack,
                onNext = {
                    viewModel.loginUser(
                        onSuccess = { user, token ->
                            onLoginSuccess(user, token)
                        },
                        onError = { /* ya se muestra error en pantalla */ }
                    )
                }
            )

        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(StressDarkBlue)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "Iniciar sesión",
                color = StressGray,
                fontSize = 26.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Correo
            CustomTextField(
                value = correo,
                onValueChange = { viewModel.correo = it },
                placeholder = "Password123"
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Contraseña
            CustomPasswordTextField(
                value = password,
                onValueChange = { viewModel.password = it },
                placeholder = "Password123"
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Error
            if (errorMessage != null) {
                Text(
                    text = errorMessage,
                    color = StressGray,
                    fontSize = 16.sp
                )
            }
        }
    }
}
