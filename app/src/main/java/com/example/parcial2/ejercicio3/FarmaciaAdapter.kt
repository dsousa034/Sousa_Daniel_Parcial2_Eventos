package com.example.parcial2.ejercicio3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial2.R

class FarmaciaAdapter(
    private val farmaciaList: List<Farmacia>,
    private val onItemClick: (Farmacia) -> Unit
) : RecyclerView.Adapter<FarmaciaAdapter.FarmaciaViewHolder>() {

    //funcion que crea la vista de cada item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FarmaciaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_farmacia, parent, false)
        return FarmaciaViewHolder(view)
    }

    //funcion que se encarga de asignar los valores a cada item
    override fun onBindViewHolder(holder: FarmaciaViewHolder, position: Int) {
        val farmacia = farmaciaList[position]
        holder.bind(farmacia)
        holder.itemView.setOnClickListener { onItemClick(farmacia) }
    }

    //funcion que retorna la cantidad de items
    override fun getItemCount(): Int = farmaciaList.size

    class FarmaciaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.title)
        private val phone: TextView = itemView.findViewById(R.id.phone)

        fun bind(farmacia: Farmacia) {
            title.text = farmacia.title
            phone.text = farmacia.phone
        }
    }
}
