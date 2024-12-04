package com.example.parcial2.ejercicio2

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class Event(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val description: String,
    val address: String,
    val price: String,
    val date: String,
    val capacity: String
)


