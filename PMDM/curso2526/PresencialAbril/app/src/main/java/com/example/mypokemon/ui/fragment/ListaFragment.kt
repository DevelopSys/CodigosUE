package com.example.mypokemon.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.mypokemon.adapter.PokemonAdapter
import com.example.mypokemon.databinding.FragmentListaBinding
import com.example.mypokemon.model.Result
import com.google.gson.Gson
import kotlin.math.PI

class ListaFragment : Fragment() {

    private lateinit var binding: FragmentListaBinding
    private lateinit var pokemonAdapter: PokemonAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        pokemonAdapter = PokemonAdapter(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaBinding
            .inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.recyclerPokemon.adapter = pokemonAdapter
        binding.recyclerPokemon.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL,
                false)
        val gson = Gson()
        val peticion = JsonObjectRequest("https://pokeapi.co/api/v2/pokemon/",
            {
                val results = it.getJSONArray("results")
                for (i in 0..results.length()-1){
                    val pokemonJSON = results.getJSONObject(i)
                    val pokemonResult = gson.fromJson(pokemonJSON.toString(),
                        Result::class.java )
                    pokemonAdapter.addResult(pokemonResult)
                }
            },{})
        Volley.newRequestQueue(context).add(peticion)
    }

}