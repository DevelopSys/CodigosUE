package com.example.inicial

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // todos los elementos graficos que quiera gestionar: button, edit
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        // junta lo logico (this) con lo grafico
        this.setContentView(binding.root)
        // lo logico + grafico esta junto
        // gestiona la logica que tu quieras
        binding.btnSaludar.setOnClickListener {
            if (binding.editNombre.text.toString().isEmpty()) {
                binding.textSaludo.text = "No hay nombre en el edit"
            } else {
                // capturar el nombre
                val nombre: String = binding.editNombre.text.toString()
                // ponerlo arriba
                binding.textSaludo.text = nombre
            }

        }
    }
}