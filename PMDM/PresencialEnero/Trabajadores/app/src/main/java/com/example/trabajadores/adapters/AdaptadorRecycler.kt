package com.example.trabajadores.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.trabajadores.R
import com.example.trabajadores.model.Trabajador

class AdaptadorRecycler(var contexto: Context) :
    RecyclerView.Adapter<AdaptadorRecycler.MyHolder>() {

    lateinit var lista: ArrayList<Trabajador>

    init {
        lista = ArrayList();
    }

    class MyHolder(itemView: View) : ViewHolder(itemView) {
        lateinit var nombre: TextView
        lateinit var apellido: TextView
        lateinit var imagen: ImageView
        lateinit var fila: LinearLayout

        init{
            nombre = itemView.findViewById(R.id.nombre_fila)
            apellido = itemView.findViewById(R.id.apellido_fila)
            imagen = itemView.findViewById(R.id.imagen_fila)
            fila = itemView.findViewById(R.id.contenedor_fila)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(contexto).inflate(R.layout.item_recycler, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item = lista[position]
        holder.nombre.text = item.nombre
        holder.apellido.text = item.apellido
        if (item.perfil.equals("masculino")) {
            Glide.with(contexto)
                .load("https://cdn.pixabay.com/photo/2012/04/13/21/07/user-33638_1280.png")
                .placeholder(R.drawable.defecto)
                .into(holder.imagen)
            // holder.imagen.setImageResource(R.drawable.ic_launcher_background)
        } else {
            // holder.imagen.setImageResource(com.google.android.material.R.drawable.ic_keyboard_black_24dp)
            Glide.with(contexto)
                .load("https://w7.pngwing.com/pngs/308/71/png-transparent-female-avatar-girl-face-woman-user-flat-classy-users-icon.png")
                .placeholder(R.drawable.defecto)
                .into(holder.imagen)
        }
        holder.fila.setOnClickListener {
            //val intent = Intent(contexto, DetailActivity::java.class);
            //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            //contexto.startActivity(intent)
        }
    }

    fun agregarUsuario(x: Trabajador): Unit {
        lista.add(x)
        notifyItemInserted(lista.size - 1)
    }
}