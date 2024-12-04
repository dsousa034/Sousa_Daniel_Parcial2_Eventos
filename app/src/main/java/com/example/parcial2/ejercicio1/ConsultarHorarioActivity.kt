package com.example.parcial2.ejercicio1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.parcial2.R
import com.google.firebase.firestore.FirebaseFirestore

class ConsultarHorarioActivity : AppCompatActivity() {
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar_horario)

        // Inicializar Firestore
        db = FirebaseFirestore.getInstance()

        // Acceder a las vistas con findViewById
        val btnConsultar = findViewById<Button>(R.id.btnConsultar)
        val etDiaConsulta = findViewById<EditText>(R.id.etDiaConsulta)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        // Configurar listener para el botón
        btnConsultar.setOnClickListener {
            val dia = etDiaConsulta.text.toString()
            consultarHorario(dia) { asignaturas ->
                tvResultado.text = asignaturas.joinToString("\n") { it.nombre }
            }
        }
    }

    private fun consultarHorario(dia: String, callback: (List<Asignatura>) -> Unit) {
        // Consultar Firestore para las asignaturas del día especificado
        db.collection("Asignaturas")
            .whereEqualTo("dia", dia)
            .get()
            .addOnSuccessListener { result ->
                // Mapear los documentos a objetos Asignatura
                val asignaturas = result.map { it.toObject(Asignatura::class.java) }
                callback(asignaturas)
            }
            .addOnFailureListener { e ->
                Log.w("Firestore", "Error getting documents", e)
            }
    }
}
