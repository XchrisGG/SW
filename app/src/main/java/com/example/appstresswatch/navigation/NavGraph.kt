package com.example.appstresswatch.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appstresswatch.layouts.LoginScreen
import com.example.appstresswatch.layouts.LogoScreen

@Composable

fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.LogoScreen.name
    ) {

        composable(Screens.LogoScreen.name) {
            LogoScreen(navController) // Esta sí recibe navController, está bien
        }

        composable(Screens.LoginScreen.name) {

            // AQUÍ USAS NAVCONTROLLER (sí se conserva)
            LoginScreen(
                onLoginClick = {
                    navController.navigate(Screens.LogoScreen.name)
                },
                onRegisterClick = {
                    navController.navigate(Screens.LogoScreen.name)
                },


                onRecoverPasswordClick = {
                    navController.navigate(Screens.LogoScreen.name)
                }
            )
        }
    }
}