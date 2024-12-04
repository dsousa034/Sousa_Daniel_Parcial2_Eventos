package com.example.parcial2.ejercicio1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.parcial2.R
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*

class AsignaturaActualActivity : AppCompatActivity() {
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asignatura_actual)

        // Inicializar Firestore
        db = FirebaseFirestore.getInstance()

        // Acceder a las vistas con findViewById
        val btnConsultarActual = findViewById<Button>(R.id.btnConsultarActual)
        val tvAsignaturaActual = findViewById<TextView>(R.id.tvAsignaturaActual)

        // Configurar listener para el botón
        btnConsultarActual.setOnClickListener {
            consultarAsignaturaActual { asignatura ->
                tvAsignaturaActual.text = asignatura?.nombre ?: "No hay asignatura en este momento"
            }
        }
    }

    private fun consultarAsignaturaActual(callback: (Asignatura?) -> Unit) {
        // Obtener la hora y el día actuales
        val currentTime = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())
        val currentDay = SimpleDateFormat("EEEE", Locale.getDefault()).format(Date())

        // Consultar Firestore
        db.collection("asignaturas")
            .whereEqualTo("dia", currentDay)
            .whereEqualTo("hora", currentTime)
            .get()
            .addOnSuccessListener { result ->
                // Mapear el resultado a un objeto Asignatura
                val asignatura = result.documents.firstOrNull()?.toObject(Asignatura::class.java)
                callback(asignatura)
            }
            .addOnFailureListener { e ->
                Log.w("Firestore", "Error getting documents", e)
            }
    }
}
