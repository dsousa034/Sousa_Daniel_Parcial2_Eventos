package com.example.parcial2.ejercicio3

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.parcial2.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val farmacia = intent.getSerializableExtra("farmacia") as Farmacia

        val title = findViewById<TextView>(R.id.title)
        val phone = findViewById<TextView>(R.id.phone)
        val mapImage = findViewById<ImageView>(R.id.mapImage)

        title.text = farmacia.title
        phone.text = farmacia.phone

        // Cargar un mapa estático de ejemplo
        val imageResource = resources.getIdentifier("map_placeholder", "drawable", packageName)
        mapImage.setImageResource(imageResource)
    }
}
