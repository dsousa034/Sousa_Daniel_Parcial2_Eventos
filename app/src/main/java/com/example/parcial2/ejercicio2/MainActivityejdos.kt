package com.example.parcial2.ejercicio2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import java.util.Locale
import com.example.parcial2.R

class MainActivityejdos : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var eventsList: MutableList<Event>
    private lateinit var database: DatabaseReference
    private lateinit var btnChangeLanguage: Button
    private lateinit var adapter: EventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_ejercicio2)

        // Botón para regresar
        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

        recyclerView = findViewById(R.id.recyclerView)
        btnChangeLanguage = findViewById(R.id.btnChangeLanguage)

        recyclerView.layoutManager = LinearLayoutManager(this)
        eventsList = mutableListOf()
        adapter = EventAdapter(eventsList)
        recyclerView.adapter = adapter

        database = FirebaseDatabase.getInstance().getReference("Eventos")

        // Botón para cambiar el idioma
        btnChangeLanguage.setOnClickListener {
            val currentLanguage = Locale.getDefault().language
            if (currentLanguage == "es") {
                changeLanguage("en")
            } else {
                changeLanguage("es")
            }
        }

        // Floating action button para agregar un evento
        val fabAddEvent = findViewById<View>(R.id.fabAddEvent)
        fabAddEvent.setOnClickListener {
            startActivity(Intent(this, AddEventActivity::class.java))
        }

        // Obtener los eventos desde Firebase
        getEventsFromFirebase()
    }

    private fun getEventsFromFirebase() {
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                eventsList.clear()
                for (eventSnapshot in snapshot.children) {
                    val event = eventSnapshot.getValue(Event::class.java)
                    event?.let { eventsList.add(it) }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivityejdos, "Error al cargar los eventos: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun changeLanguage(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)

        // Reiniciar la actividad para aplicar el idioma
        recreate()
    }
}
