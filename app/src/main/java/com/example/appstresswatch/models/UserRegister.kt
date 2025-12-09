package com.example.appstresswatch.models




data class UserRegister(
    val nombre: String = "",
    val apellido: String = "",
    val edad: String = "",
    val sexo: String = "",
    val fechaNacimiento: String = "",
    val pais: String = "",
    val usuario: String = "",
    val password: String = "",
    val avatarIndex: Int = 0
)