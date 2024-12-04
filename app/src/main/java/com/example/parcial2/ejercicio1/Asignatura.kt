package com.example.parcial2.ejercicio1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "asignaturas")
data class Asignatura(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String = "",
    val dia: String = "",
    val hora: String = ""
)