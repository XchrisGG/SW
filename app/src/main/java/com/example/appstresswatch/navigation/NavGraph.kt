package com.example.appstresswatch.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appstresswatch.layouts.LoginScreen
import com.example.appstresswatch.layouts.LogoScreen

@Composable

fun NavGraph(){
    val navController = rememberNavController()

    NavHost(navController, startDestination = Screens.LogoScreen.name){
        composable(route = Screens.LogoScreen.name){ LogoScreen(navController) }
        composable(route = Screens.LoginScreen.name){ LoginScreen(navController) }

    }


}