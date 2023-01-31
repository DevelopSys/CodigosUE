package com.example.listadocoches.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listadocoches.R
import com.example.listadocoches.model.Coche
import com.google.android.material.snackbar.Snackbar

class AdaptadorCoches(var contexto: Context) : RecyclerView.Adapter<AdaptadorCoches.MyHolder>() {

    private lateinit var listaCoches: ArrayList<Coche>
    // TODO 2. Creo un objeto del tipo de la interfaz
    private lateinit var listener: OnRecycerCocheListener

    init {
        listaCoches = ArrayList()
        listaCoches.add(Coche("Mercedes","AMG GTLIne",300000,400,R.drawable.amggt))
        listaCoches.add(Coche("Bentley","Continental",200000,300,R.drawable.continental))
        // contexto --> MainActivity : AppCompatActivity OnRecycerCocheListener
        // OnRecycerCocheListener = ( OnRecycerCocheListener) cambiado a OnRecycerCocheListener
        listener = contexto as OnRecycerCocheListener
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var nombreCocheTextView: TextView
         var imagenCocheImageView: ImageView
         var botonDetalleButton: Button

        init {
            nombreCocheTextView = itemView.findViewById(R.id.nombre_detalle)
            imagenCocheImageView = itemView.findViewById(R.id.imagen_coche_rec)
            botonDetalleButton = itemView.findViewById(R.id.boton_detalle)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista = LayoutInflater.from(contexto).inflate(R.layout.item_recycler,parent, false)
        return MyHolder(vista)
    }
    override fun getItemCount(): Int {
        return listaCoches.size
    }
    fun agregarCoche(coche: Coche){
        this.listaCoches.add(coche)
        //this.notifyItemInserted(listaCoches.size-1)
    }
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val cocheTemp = listaCoches[position]
        holder.nombreCocheTextView.setText(cocheTemp.modelo)
        holder.imagenCocheImageView.setImageResource(cocheTemp.imagen)
        holder.botonDetalleButton.setOnClickListener {
            /*Snackbar.make(holder.botonDetalleButton,cocheTemp.precio.toString(),Snackbar.LENGTH_SHORT)
                .show()*/
            // comunicar
            listener.onCocheSelected(cocheTemp)
        }
    }

    // TODO 1. Creo una interfaz en el origen de los datos
    interface OnRecycerCocheListener{
        fun onCocheSelected(coche: Coche)
        // Las ejecuciones que quiera --> abrir una activity donde se muestren los datos del coche
    }
}