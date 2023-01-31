package com.develop.proyectorecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.develop.proyectorecycler.adapter.AdaptadorUsuarios
import com.develop.proyectorecycler.databinding.ActivityMainBinding
import com.develop.proyectorecycler.model.Usuario

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorUsuarios: AdaptadorUsuarios
    private lateinit var listaUsuarios: ArrayList<Usuario>

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        listaUsuarios = ArrayList()
        listaUsuarios.add(Usuario("Borja1","bmartin1@ue.com", R.drawable.libra))
        listaUsuarios.add(Usuario("Borja2","bmartin2@ue.com", R.drawable.dollar))
        listaUsuarios.add(Usuario("Borja3","bmartin3@ue.com", R.drawable.euro))
        listaUsuarios.add(Usuario("Borja4","bmartin4@ue.com", R.drawable.libra))
        listaUsuarios.add(Usuario("Borja5","bmartin5@ue.com", R.drawable.dollar))
        listaUsuarios.add(Usuario("Borja6","bmartin6@ue.com", R.drawable.dollar))
        adaptadorUsuarios = AdaptadorUsuarios(applicationContext,listaUsuarios)

        // junta lo grafico con lo logico
        binding.recyclerUsuarios.adapter = adaptadorUsuarios
        //binding.recyclerUsuarios.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerUsuarios.layoutManager = GridLayoutManager(applicationContext,2)
        // elemento gráfico --> binding.recyclerUsuarios
        // elemento lógico --> datos --> adaptador
    }
}