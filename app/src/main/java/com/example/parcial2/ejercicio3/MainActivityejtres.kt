package com.example.parcial2.ejercicio3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial2.R
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivityejtres : AppCompatActivity() {

    private lateinit var farmaciaList: MutableList<Farmacia>
    private lateinit var farmaciaAdapter: FarmaciaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_ejercicio3)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Leer y procesar el JSON
        farmaciaList = readJsonFile()
        farmaciaAdapter = FarmaciaAdapter(farmaciaList) { farmacia ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("farmacia", farmacia)
            startActivity(intent)
        }

        recyclerView.adapter = farmaciaAdapter
    }

    private fun readJsonFile(): MutableList<Farmacia> {
        val farmaciaList = mutableListOf<Farmacia>()
        try {
            val inputStream = assets.open("dbfarmacia.json")
            val reader = BufferedReader(InputStreamReader(inputStream))
            val jsonString = reader.readText()
            val jsonArray = JSONArray(jsonString)

            for (i in 0 until jsonArray.length()) {
                val feature = jsonArray.getJSONObject(i).getJSONObject("properties")
                val geometry = jsonArray.getJSONObject(i).getJSONObject("geometry")
                val title = feature.getString("title")
                val phone = feature.getString("description").split("Teléfono:")[1].trim().split(" ")[0]
                val coordinates = geometry.getJSONArray("coordinates")

                farmaciaList.add(
                    Farmacia(
                        title = title,
                        phone = phone,
                        latitude = coordinates.getDouble(1),
                        longitude = coordinates.getDouble(0)
                    )
                )
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return farmaciaList
    }
}