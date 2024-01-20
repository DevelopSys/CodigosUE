package com.example.trabajadores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trabajadores.adapters.AdaptadorRecycler
import com.example.trabajadores.databinding.ActivityMainBinding
import com.example.trabajadores.model.Trabajador

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorRecycler: AdaptadorRecycler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adaptadorRecycler = AdaptadorRecycler(this)
        binding.recycler.adapter = adaptadorRecycler;
        binding.recycler.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false);

        binding.botonAdd.setOnClickListener {
            //binding.recycler;
            adaptadorRecycler.agregarUsuario(
                Trabajador(
                    binding.editNombre.text.toString(),
                    binding.editApellido.text.toString(),
                    binding.spinnerGenero.selectedItem.toString()
                )
            )
        }
    }
}