package com.example.mypokemon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mypokemon.databinding.ItemPokemonBinding
import com.example.mypokemon.model.Result

class PokemonAdapter(var context: Context) : RecyclerView.Adapter<PokemonAdapter.PokemonHolder>() {
    inner class PokemonHolder(var binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var listaPokemon = ArrayList<Result>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokemonHolder {
        val binding: ItemPokemonBinding =
            ItemPokemonBinding.inflate(
                LayoutInflater.from(context), parent, false
            )
        return PokemonHolder(binding)

    }

    override fun onBindViewHolder(
        holder: PokemonHolder,
        position: Int
    ) {
        var pokemon = listaPokemon[position]
        holder.binding.textoNombre.text = pokemon.name
        holder.binding.btnDetalle.setOnClickListener {
            
        }
    }

    override fun getItemCount(): Int {
        return listaPokemon.size
    }

    fun addResult(result: Result){
        listaPokemon.add(result)
        notifyItemInserted(listaPokemon.size-1)
    }


}