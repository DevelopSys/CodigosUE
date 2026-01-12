package com.example.listaproductos.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listaproductos.R
import com.example.listaproductos.databinding.ItemRecyclerProductoBinding
import com.example.listaproductos.model.Producto
import com.google.android.material.snackbar.Snackbar

class ProductosAdapter(var lista: ArrayList<Producto>, var contexto: Context) :
    RecyclerView.Adapter<ProductosAdapter.MyHolder>() {
    inner class MyHolder(var binding: ItemRecyclerProductoBinding) :
        RecyclerView.ViewHolder(binding.root)

    // crea el holder (patron de las filas), utilizando la inner class que a su vez utiliza el XML creado
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        val binding: ItemRecyclerProductoBinding = ItemRecyclerProductoBinding.inflate(
            LayoutInflater.from(contexto), parent, false
        )
        return MyHolder(binding)
    }

    // buscar en la posicion de la lista, mostrando en el holder lo que hay en esa posicion -> PINTA cada fila
    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        val item: Producto = lista[position]
        holder.binding.nombreRecycler.text = item.title
        Glide.with(contexto).load(item.image).placeholder(R.drawable.producto)
            .into(holder.binding.imagenRecycler)
        holder.binding.btnRecycler.setOnClickListener {
            Snackbar.make(
                holder.binding.root,
                "El precio del articulo es ${item.price} ",
                Snackbar.LENGTH_SHORT
            ).show()
        }

    }

    // el numero de elementos que hay en la lista -> cuantas filas se pintan
    override fun getItemCount(): Int {
        return lista.size
    }


}