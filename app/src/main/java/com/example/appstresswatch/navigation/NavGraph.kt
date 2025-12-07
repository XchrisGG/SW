package com.example.appstresswatch.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable

fun NavGraph(){
    val navController = rememberNavController()

    NavHost(navController, startDestination = "logo"){
        
    }


}