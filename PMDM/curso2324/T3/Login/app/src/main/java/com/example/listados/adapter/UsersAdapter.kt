package com.example.listados.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.listados.R
import com.example.listados.model.Contacto

class UsersAdapter(
    var lista: ArrayList<Contacto>,
    var context: Context
) : RecyclerView.Adapter<UsersAdapter.MyHolder>() {

    // TODO. PASO 4: Creo un objeto de la interfaz
    private lateinit var listener: OnRecyclerUsuarioListener
    private lateinit var listaCompleta: ArrayList<Contacto>


    // TODO PASO 5: Inicializo la interfaz en el bloque que siempre se ejcuta

    init {
        // OnRecyclerUsuarioListener = Context --> OnRecyclerUsuarioListener
        // OnRecyclerUsuarioListener = (SecondActivity --> OnRecyclerUsuarioListener)
        listener = context as OnRecyclerUsuarioListener
        listaCompleta = lista
    }

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
        //holder.imagen.setImageResource(usuario.imagen)
        Glide.with(context).load(usuario.imagen).into(holder.imagen)
        holder.imagen.setOnClickListener {
            // imagen pulsada --> borrar el elemento
            // Snackbar.make(holder.nombre,"Imagen pulsado",Snackbar.LENGTH_SHORT).show()
            lista.removeAt(position)
            notifyItemRemoved(position)
            //notifyDataSetChanged()

        }
        holder.nombre.setOnClickListener {
            // nombre pulsado --> sacar un snackbar
            // Snackbar.make(holder.nombre,"Nombre pulsado con telefono ${usuario.telefono.toString()}",Snackbar.LENGTH_SHORT).show()
            // llevar el dato a la activity
            // TODO: PASO 3 --> llamo al metodo de la interfaz
            listener.onContactoSelected(usuario)
        }
        holder.nombre.setOnClickListener {
            // nombre pulsado --> sacar un snackbar
            // Snackbar.make(holder.nombre,"Nombre pulsado con telefono ${usuario.telefono.toString()}",Snackbar.LENGTH_SHORT).show()
            // llevar el dato a la activity
            // val intent = Intent(context, MainActivity::class.java)
            // intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            // context.startActivity(intent)
            // TODO: PASO 3 --> llamo al metodo de la interfaz
            listener.onContactoSelected(usuario)
        }

    }
    fun addContact(contact: Contacto) {
        this.lista.add(contact)
        notifyItemInserted(lista.size-1)
    }

    fun filtrarLista(genero: String){
        if (genero.equals("Todos")){
            this.lista = listaCompleta
        } else  {
            this.lista = listaCompleta.filter {
                it.genero.equals(genero, true)
            } as ArrayList<Contacto>
        }


        // cambiada la lista
        // notificar cambios
        notifyDataSetChanged()

    }


    // TODO: PASO 1 -> crear una interfaz en el origen de los datos
    interface OnRecyclerUsuarioListener{
        // TODO: PASO 2 -> crear un metodo con el dato a comunicar como param
        fun onContactoSelected(contacto: Contacto)
    }

}