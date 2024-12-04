package com.example.parcial2.ejercicio2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EventDao {
    @Insert
    suspend fun insert(event: Event)

    @Query("SELECT * FROM events")
    suspend fun getAll(): List<Event>
}