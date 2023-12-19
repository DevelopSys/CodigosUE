package com.example.listados.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.listados.R
import com.example.listados.model.Contacto
import com.example.listados.model.Usuario

class UsersAdapter(
    val lista: ArrayList<Contacto>,
    var context: Context
) : RecyclerView.Adapter<UsersAdapter.MyHolder>() {

    class MyHolder(item: View) : ViewHolder(item) {
        /*representa la template de cada fila*/
        var imagen: ImageView;
        var nombre: TextView

        init {
            imagen = item.findViewById(R.id.imagen_fila)
            nombre = item.findViewById(R.id.nombre_fila)
        }
    }

    /*definen como se pinta cada una de las filas del recycler*/

    // cuantas filas tienes que pintar
    override fun getItemCount(): Int {
        return lista.size
    }

    // crea un template para "cada fila" -> lo deja cacheado
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // el fichero xml con el aspecto de la fila
        val vista: View = LayoutInflater.from(context)
            .inflate(R.layout.item_recycler, parent, false)
        return MyHolder(vista)
    }

    // cada dato en una posicion (de una lista) en su fila correspondiente
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        /*ejecutado una vez por cada fila*/
        // elemento - dato a representar -> en una posicion
        val usuario = lista[position]
        holder.nombre.text = usuario.nombre
        holder.imagen.setImageResource(usuario.imagen)
    }
}