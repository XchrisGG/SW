package com.example.appstresswatch.navigation

sealed class Screens(val name: String) {
    object LogoScreen : Screens("logo")
    object LoginScreen : Screens("login")

}