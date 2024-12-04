package com.example.parcial2.ejercicio2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.example.parcial2.R

class AddEventActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_event)

        database = FirebaseDatabase.getInstance().getReference("Eventos")

        val etEventName = findViewById<EditText>(R.id.edtEventName)
        val etEventDescription = findViewById<EditText>(R.id.edtEventDescription)
        val etEventAddress = findViewById<EditText>(R.id.edtEventAddress)
        val etEventPrice = findViewById<EditText>(R.id.edtEventPrice)
        val etEventDate = findViewById<EditText>(R.id.edtEventDate)
        val etEventCapacity = findViewById<EditText>(R.id.edtEventCapacity)
        val btnAddEvent = findViewById<Button>(R.id.btnAddEvent)
        val btnCancel = findViewById<Button>(R.id.btnCancel)

        btnAddEvent.setOnClickListener {
            val name = etEventName.text.toString()
            val description = etEventDescription.text.toString()
            val address = etEventAddress.text.toString()
            val price = etEventPrice.text.toString()
            val date = etEventDate.text.toString()
            val capacity = etEventCapacity.text.toString()

            if (name.isNotEmpty() && description.isNotEmpty() && address.isNotEmpty() && price.isNotEmpty() && date.isNotEmpty() && capacity.isNotEmpty()) {
                val eventId = database.push().key
                val event = Event(eventId, name, description, address, price, date, capacity)

                eventId?.let {
                    database.child(it).setValue(event).addOnCompleteListener {
                        Toast.makeText(this, "Evento añadido", Toast.LENGTH_SHORT).show()
                        finish()
                    }.addOnFailureListener {
                        Toast.makeText(this, "Error al añadir el evento", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        btnCancel.setOnClickListener {
            finish()
        }
    }
}