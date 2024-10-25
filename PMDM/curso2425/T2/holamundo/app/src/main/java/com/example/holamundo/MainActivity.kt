package com.example.holamundo

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var boton: Button
    private lateinit var botonAdicional: Button
    // prime metodo del ciclo de vida: juntar logica (this) con lo grafico (layout)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // inicializo las cosas graficas
        boton = findViewById(R.id.botonPulsar)
        botonAdicional = findViewById(R.id.botonAdicional)

        botonAdicional.setOnClickListener {
            Toast.makeText(applicationContext,"Otro boton pulsado", Toast.LENGTH_LONG).show()

        }

        boton.setOnClickListener {
            // las acciones que pasaran si pulso el boton
            Snackbar.make(boton, "Primera app android completada", Snackbar.LENGTH_LONG).show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}