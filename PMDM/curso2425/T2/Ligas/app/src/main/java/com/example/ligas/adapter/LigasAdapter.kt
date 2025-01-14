package com.example.ligas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ligas.R
import com.example.ligas.model.Liga
import com.google.android.material.snackbar.Snackbar

class LigasAdapter(var lista: ArrayList<Liga>, var context: Context) :
    RecyclerView.Adapter<LigasAdapter.MyHolder>() {

    // itemView -> el XML pasado a vista con todos los elementos comunes a la fila
    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // sacar cada uno de los elementos de la vista
        val imagen: ImageView = itemView.findViewById(R.id.imagenLiga)
        val nombre: TextView = itemView.findViewById(R.id.nombreLiga)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // asociar el XML al holder
        val vista: View = LayoutInflater.from(context).inflate(R.layout.item_liga, parent, false)
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        // cuantas filas tengo que pintar
        return lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        // pintará individialmente cada fila con su dato correspondiente
        val liga: Liga = lista[position]
        holder.imagen.setImageResource(liga.imagen)
        holder.nombre.text = liga.nombre
        holder.imagen.setOnClickListener {
            Snackbar.make(
                holder.imagen,
                "La cantidad de interes que suscita la lista ${liga.nombre} es ${liga.calificacion}",
                Snackbar.LENGTH_SHORT
            ).show()
        }
        holder.imagen.setOnLongClickListener {
            lista.removeAt(position);
            notifyItemRemoved(position)
            return@setOnLongClickListener true
        }
    }

}


