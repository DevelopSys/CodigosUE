package com.example.ligas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Grid
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ligas.adapter.LigasAdapter
import com.example.ligas.databinding.ActivityMainBinding
import com.example.ligas.model.Liga

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: LigasAdapter;
    private lateinit var listaLigas: ArrayList<Liga>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias();

    }

    private fun instancias() {
        listaLigas = arrayListOf(
            Liga("BBVA", R.drawable.liga,90),
            Liga("Bundesliga", R.drawable.icono,85),
            Liga("Calcio", R.drawable.icono,70),
            Liga("Premier", R.drawable.premier,95),
            Liga("Ligue1", R.drawable.icono,60),
            Liga("Eridivise", R.drawable.icono,50),
            Liga("SerieB", R.drawable.icono,40),
            Liga("Liga Santander", R.drawable.icono,87),
        )
        adapter = LigasAdapter(listaLigas, this)

        binding.recyclerLigas.adapter = adapter;
        if(resources.configuration.orientation == 1){
            binding.recyclerLigas.layoutManager =
                LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        } else if(resources.configuration.orientation == 2){
            binding.recyclerLigas.layoutManager =
                GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)
        }



    //LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


    }
}