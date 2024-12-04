package com.example.parcial2.ejercicio2

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Event(
    val id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val address: String? = null,
    val price: String? = null,
    val date: String? = null,
    val capacity: String? = null
)


