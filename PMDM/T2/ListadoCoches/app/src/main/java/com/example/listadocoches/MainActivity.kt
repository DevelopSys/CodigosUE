package com.example.listadocoches

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadocoches.adapter.AdaptadorCoches
import com.example.listadocoches.databinding.ActivityMainBinding
import com.example.listadocoches.model.Coche
import com.google.android.material.snackbar.Snackbar

// 3. TODO En el destino de la interfaz implemento la interfaz
class MainActivity : AppCompatActivity(), AdaptadorCoches.OnRecycerCocheListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorCoche: AdaptadorCoches
    private lateinit var listaInicial: ArrayList<Coche>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaInicial = ArrayList()
        listaInicial.add(Coche("Mercedes","AMG GTLIne",300000,400,R.drawable.amggt))
        listaInicial.add(Coche("Bentley","Continental",200000,300,R.drawable.continental))

        // agrego el coche a lista inicial

        adaptadorCoche = AdaptadorCoches(this)
        binding.recyclerCoches.adapter = adaptadorCoche
        binding.recyclerCoches.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)



    }

    override fun onCocheSelected(coche: Coche) {
        //Snackbar.make(binding.root,"Coche comunicado",Snackbar.LENGTH_SHORT).show()
        adaptadorCoche.agregarCoche(coche)
    }

    // el coche seleccionado lo tenga en la activity
}