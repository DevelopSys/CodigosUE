package com.develop.proyectorecycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.develop.proyectorecycler.R
import com.develop.proyectorecycler.model.Usuario

class AdaptadorUsuarios(var contexto: Context, var listaDatos: ArrayList<Usuario>) :
    RecyclerView.Adapter<AdaptadorUsuarios.MyHolder>() {

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // crear cada uno de los elementos del holder
        var nombreText: TextView
        var correoText: TextView
        var imagenImageView: ImageView

        init {
            nombreText = itemView.findViewById(R.id.nombre_item_recycler)
            correoText = itemView.findViewById(R.id.correo_item_recycler)
            imagenImageView = itemView.findViewById(R.id.imagen_item_recycler)
        }


    }

    // crear y devolver un holder (template con la clase anidada) y se lo paso el metodo onBind
    // TODO primer método a escribir
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // creo una vista --> es aspecto de cada una de las filas
        val vista: View =
            LayoutInflater.from(contexto).inflate(R.layout.item_recycler, parent, false)
        return MyHolder(vista)
    }

    // rellenar cada holder con el dato que me toda
    // TODO segundo método a rellenar -> junta el holder con los datos
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        // el objeto de la posicion i --> holder de la posicion i
        val usuarioTemporal = listaDatos[position]
        holder.nombreText.text = usuarioTemporal.nombre
        holder.correoText.text = usuarioTemporal.correo
        holder.imagenImageView.setImageResource(usuarioTemporal.imagen)
    }

    // el numero de elementos que tendrá el adaptador --> numero de filas que tienes que pintar
    override fun getItemCount(): Int {
        return listaDatos.size
    }

}