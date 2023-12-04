package com.example.listados

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.annotation.RequiresApi
import com.example.listados.databinding.ActivitySecondBinding
import com.example.listados.model.Usuario
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var usuarioRecuperado: Usuario


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        usuarioRecuperado = intent.extras!!.getSerializable("usuario") as Usuario
        binding.textoUsuario.text = usuarioRecuperado.correo

        binding.spinnerGenero.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val seleccionado = parent!!.adapter.getItem(position).toString()
                Snackbar.make(binding.root,seleccionado,Snackbar.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        binding.botonLogout.setOnClickListener {
            finish()
        }
    }
}