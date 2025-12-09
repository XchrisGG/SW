package com.example.appstresswatch.models

import kotlinx.serialization.Serializable


@Serializable
data class UserLogin(
    val correo: String,
    val password: String
)