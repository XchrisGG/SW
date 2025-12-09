package com.example.appstresswatch.models

import kotlinx.serialization.Serializable


@Serializable

data class User(
    val id: String? = null,
    val nombre: String = "",
    val apellido: String = "",
    val sexo: String = "",
    val fechaNacimiento: String = "",
    val pais: String = "",
    val correo: String = "",
    val password: String = "",



)