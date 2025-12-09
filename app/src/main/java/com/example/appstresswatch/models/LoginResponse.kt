package com.example.appstresswatch.models

data class LoginResponse(
    val ok: Boolean,
    val token: String?,
    val usuario: User
)

