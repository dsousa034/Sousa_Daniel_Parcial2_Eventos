package com.example.parcial2.ejercicio1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.parcial2.R

class MainActivityejuno : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_ejercicio1)

        val btnAgregarAsignatura = findViewById<Button>(R.id.btnAgregarAsignatura)
        val btnConsultarHorario = findViewById<Button>(R.id.btnConsultarHorario)
        val btnAsignaturaActual = findViewById<Button>(R.id.btnAsignaturaActual)

        btnAgregarAsignatura.setOnClickListener {
            startActivity(Intent(this, AgregarAsignaturaActivity::class.java))
        }

        btnConsultarHorario.setOnClickListener {
            startActivity(Intent(this, ConsultarHorarioActivity::class.java))
        }

        btnAsignaturaActual.setOnClickListener {
            startActivity(Intent(this, AsignaturaActualActivity::class.java))
        }
    }
}