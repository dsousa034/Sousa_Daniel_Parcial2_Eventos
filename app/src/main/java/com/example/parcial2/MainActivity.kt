package com.example.parcial2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.parcial2.ejercicio1.MainActivityejuno as Ejercicio1MainActivity
import com.example.parcial2.ejercicio2.MainActivityejdos as Ejercicio2MainActivity
import com.example.parcial2.ejercicio3.MainActivityejtres as Ejercicio3MainActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEjercicio1 = findViewById<Button>(R.id.btnEjercicio1)
        val btnEjercicio2 = findViewById<Button>(R.id.btnEjercicio2)
        val btnEjercicio3 = findViewById<Button>(R.id.btnEjercicio3)

        btnEjercicio1.setOnClickListener {
            startActivity(Intent(this, Ejercicio1MainActivity::class.java))
        }

        btnEjercicio2.setOnClickListener {
            startActivity(Intent(this, Ejercicio2MainActivity::class.java))
        }

        btnEjercicio3.setOnClickListener {
            startActivity(Intent(this, Ejercicio3MainActivity::class.java))
        }
    }
}