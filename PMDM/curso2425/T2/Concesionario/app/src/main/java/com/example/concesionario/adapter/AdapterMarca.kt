package com.example.concesionario.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.concesionario.R
import com.example.concesionario.model.Marca

class AdapterMarca(var lista: ArrayList<Marca>, var contexto: Context) : BaseAdapter() {

    // puedo hacer la consulta contra la BD
    override fun getCount(): Int {
        // retorna el numero de filas!! que se representan en el spinner
        return lista.size;
    }

    override fun getItem(position: Int): Marca {
        // retorna el elemento de la posicion  -> el seleccionado
        return lista[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun agregarMarca(marca: Marca){
        lista.add(marca)
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // retorna como se mapea la vista -> cada una de las filas
        // se ejecuta una vez por cada fila e indica como se pinta la fila ->

        val vista: View = LayoutInflater.from(contexto).inflate(R.layout.item_marca, parent, false)
        // como se pinta cada fila, por lo que necesito: los elementos donde tengo que dejar las cosas y ademas el elemtno que tengo que poner
        val marca: Marca = lista[position];
        val imagen: ImageView = vista.findViewById(R.id.imagenspMarca)
        val texto: TextView = vista.findViewById(R.id.textospMarca)
        texto.text = marca.nombre
        // imagen.setImageURI(marca.imagen)
        Glide.with(contexto).load(marca.imagen).placeholder(R.drawable.images)
            .into(imagen)
        return vista;
    }
}