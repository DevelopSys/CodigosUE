package com.example.ligas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ligas.R
import com.example.ligas.model.Equipo

class AdaptadorEquipo(val lista: ArrayList<Equipo>,
                      val context: Context)
    : RecyclerView.Adapter<AdaptadorEquipo.MyHolder>() {

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagen: ImageView = itemView.findViewById(R.id.imagenEquipo)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista = LayoutInflater.from(context).inflate(R.layout.item_equipo,
            parent,false)
        return MyHolder(vista)
    }
    override fun getItemCount(): Int {
       return lista.size
    }
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        // TODO pintar las filas
        val equipo = lista[position]
    Glide.with(context).load(equipo.strBadge).into(holder.imagen)
    // holder.imagen.setImageResource(equipo.strBadge)

    }
    fun addEquipo(x: Equipo) {
        lista.add(x)
        notifyItemInserted(lista.size-1)
    }
}