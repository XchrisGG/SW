package com.example.appstresswatch.navigation

sealed class Screens(val name: String) {
    object LogoScreen : Screens("logo")
    object LoginScreen : Screens("login")

    object InfoScreen : Screens("info")

    object NameScreen : Screens("name")

    object SexScreen : Screens("sex")

    object UserScreen : Screens("user")

    object ImageScreen : Screens("img")

    object PreViewInfo : Screens("Pre")

}