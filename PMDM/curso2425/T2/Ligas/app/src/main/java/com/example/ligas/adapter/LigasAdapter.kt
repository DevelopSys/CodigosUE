package com.example.ligas.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.example.ligas.MainActivity
import com.example.ligas.R
import com.example.ligas.SeassonActivity
import com.example.ligas.model.Liga
import com.example.ligas.model.LigaJSON
import com.google.android.material.snackbar.Snackbar

class LigasAdapter(var lista: ArrayList<LigaJSON>, var context: Context) :
    RecyclerView.Adapter<LigasAdapter.MyHolder>() {

    private lateinit var listener: OnLigaListener

    init {
        // OnLigaListener = MainActivity as OnLigaListener
        listener = context as OnLigaListener
    }

    // itemView -> el XML pasado a vista con todos los elementos comunes a la fila
    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // sacar cada uno de los elementos de la vista

        val imagen: ImageView = itemView.findViewById(R.id.imagenLiga)
        val nombre: TextView = itemView.findViewById(R.id.nombreLiga)
        val toolbar: Toolbar = itemView.findViewById(R.id.toolbarCard)

        init {
            toolbar.inflateMenu(R.menu.liga_menu)
        }
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
        val liga: LigaJSON = lista[position]
        // holder.imagen.setImageResource(liga.imagen)
        holder.toolbar.title = liga.strLeague
        holder.nombre.text = liga.strLeague
        holder.imagen.setOnClickListener {
            // listener.onLigaSelected(liga)
            val intent = Intent(context, SeassonActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("liga",liga)
            intent.putExtra("datos",bundle)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
        holder.toolbar.setOnMenuItemClickListener {
            // it -> menuItem
            when(it.itemId){
                R.id.menuLigaFav->{

                }
                R.id.menuLigaDetail->{
                    val intent = Intent(context, SeassonActivity::class.java)
                    val bundle = Bundle();
                    bundle.putSerializable("liga",liga)
                    intent.putExtra("datos",bundle)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(intent)
                }
            }

            return@setOnMenuItemClickListener true
        }

        /*holder.imagen.setOnLongClickListener {
            lista.removeAt(position);
            notifyItemRemoved(position)
            return@setOnLongClickListener true
        }*/

        /*holder.imagen.setOnLongClickListener {
            val intent: Intent = Intent(context, xxxx)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
            return@setOnLongClickListener true*/
    }

    fun addLeague(liga: LigaJSON){
        this.lista.add(liga)
        notifyItemInserted(lista.size-1)
        // notifyDataSetChanged()
    }


    interface OnLigaListener {
        fun onLigaSelected(liga: Liga)
    }

}


