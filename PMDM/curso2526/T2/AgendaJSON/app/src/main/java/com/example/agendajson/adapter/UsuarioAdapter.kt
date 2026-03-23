package com.example.agendajson.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agendajson.R
import com.example.agendajson.databinding.ItemRecyclerBinding
import com.example.agendajson.model.User

class UsuarioAdapter(
    var contexto: Context
) : RecyclerView.Adapter<UsuarioAdapter.MyHolder>() {
    private val lista = ArrayList<User>()

    inner class MyHolder(var binding: ItemRecyclerBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        val binding: ItemRecyclerBinding = ItemRecyclerBinding.inflate(
            LayoutInflater.from(contexto), parent, false
        )
        return MyHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        val user = lista[position]
        holder.binding.nombreUsuarioRecycler.text =
            contexto.getString(
                R.string.nombre_completo,
                user.firstName,
                user.lastName
            )
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun addUser(user: User){
        this.lista.add(user)
        notifyItemInserted(lista.size-1)
    }

}