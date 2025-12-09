package com.example.appstresswatch.models

data class RegisterResponse(
    val ok: Boolean,
    val msg: String,
    val user: User?
)


