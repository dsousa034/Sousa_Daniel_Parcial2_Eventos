package com.example.parcial2.ejercicio2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.parcial2.R
import com.google.firebase.firestore.FirebaseFirestore

class AddEventActivity : AppCompatActivity() {

    private lateinit var edtEventName: EditText
    private lateinit var edtEventDescription: EditText
    private lateinit var edtEventAddress: EditText
    private lateinit var edtEventPrice: EditText
    private lateinit var edtEventDate: EditText
    private lateinit var edtEventCapacity: EditText
    private lateinit var btnSaveEvent: Button
    private lateinit var btnCancel: Button
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_event)

        edtEventName = findViewById(R.id.edtEventName)
        edtEventDescription = findViewById(R.id.edtEventDescription)
        edtEventAddress = findViewById(R.id.edtEventAddress)
        edtEventPrice = findViewById(R.id.edtEventPrice)
        edtEventDate = findViewById(R.id.edtEventDate)
        edtEventCapacity = findViewById(R.id.edtEventCapacity)
        btnSaveEvent = findViewById(R.id.btnSaveEvent)
        btnCancel = findViewById(R.id.btnCancel)

        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

        db = FirebaseFirestore.getInstance()

        btnSaveEvent.setOnClickListener {
            saveEvent()
        }

        btnCancel.setOnClickListener {
            finish()
        }
    }

    private fun saveEvent() {
        val eventName = edtEventName.text.toString()
        val eventDescription = edtEventDescription.text.toString()
        val eventAddress = edtEventAddress.text.toString()
        val eventPrice = edtEventPrice.text.toString()
        val eventDate = edtEventDate.text.toString()
        val eventCapacity = edtEventCapacity.text.toString()

        if (eventName.isNotEmpty() && eventDescription.isNotEmpty() && eventPrice.isNotEmpty() &&
            eventDate.isNotEmpty() && eventCapacity.isNotEmpty()) {

            val event = Event(name = eventName, description = eventDescription, address = eventAddress, price = eventPrice, date = eventDate, capacity = eventCapacity)

            db.collection("Eventos")
                .add(event)
                .addOnSuccessListener {
                    Toast.makeText(this, "Evento guardado correctamente", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivityejdos::class.java)
                    startActivity(intent)
                    finish()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Error al guardar el evento", Toast.LENGTH_SHORT).show()
                }
        } else {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
        }
    }
}