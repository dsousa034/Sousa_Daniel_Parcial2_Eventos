package com.example.parcial2.ejercicio3

import java.io.Serializable

data class Farmacia(
    val title: String,
    val phone: String,
    val latitude: Double,
    val longitude: Double
) : Serializable
