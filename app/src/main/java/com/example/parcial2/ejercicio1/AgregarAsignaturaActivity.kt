package com.example.parcial2.ejercicio1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.parcial2.R
import com.google.firebase.firestore.FirebaseFirestore

class AgregarAsignaturaActivity : AppCompatActivity() {
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_asignatura)

        // Inicializar Firestore
        db = FirebaseFirestore.getInstance()

        // Acceder a las vistas con findViewById
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val etNombreAsignatura = findViewById<EditText>(R.id.etNombre)
        val etDiaAsignatura = findViewById<EditText>(R.id.etDia)
        val etHoraAsignatura = findViewById<EditText>(R.id.etHora)

        // Configurar listener para el botón
        btnGuardar.setOnClickListener {
            val nombre = etNombreAsignatura.text.toString()
            val dia = etDiaAsignatura.text.toString()
            val hora = etHoraAsignatura.text.toString()

            // Crear un objeto Asignatura
            val asignatura = Asignatura(nombre = nombre, dia = dia, hora = hora)

            // Guardar en Firestore
            db.collection("Asignaturas")
                .add(asignatura)
                .addOnSuccessListener {
                    // Mostrar mensaje de éxito
                    Toast.makeText(this, "Asignatura guardada correctamente", Toast.LENGTH_SHORT).show()

                    // Redirigir a la pantalla deseada
                    val intent = Intent(this, MainActivityejuno::class.java)
                    startActivity(intent)
                    finish()
                }
                .addOnFailureListener { e ->
                    // Mostrar mensaje de error
                    Toast.makeText(this, "Error al guardar la asignatura", Toast.LENGTH_SHORT).show()
                }
        }
    }
}