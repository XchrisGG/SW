package com.example.appstresswatch.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.appstresswatch.R
import com.example.appstresswatch.components.PrimaryButton
import com.example.appstresswatch.ui.theme.StressDarkBlue

@Composable

fun LoginScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onRecoverPasswordClick: () -> Unit,

){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(StressDarkBlue)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(150.dp))



        Image(
            painter = painterResource(id = R.drawable.logo_stress),
            contentDescription = "StressWatch logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(280.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        PrimaryButton(
            text =  "Registrarse",
            onClick = onRegisterClick,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(40.dp))

        PrimaryButton(
            text =  "Iniciar Sesión",
            onClick = onLoginClick,
            modifier = Modifier.fillMaxWidth()
        )



    }

}