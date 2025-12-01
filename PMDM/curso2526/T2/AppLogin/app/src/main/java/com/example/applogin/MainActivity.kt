package com.example.applogin

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.applogin.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // pon a escuchar cada elemento -> activar un binding
        acciones();
    }

    private fun acciones() {
        // pon a escucha cuando se hace click -> onClick(v: View)
        binding.btnLogin.setOnClickListener {
            Snackbar.make(
                it,
                "Intentando hacer login con los datos ${binding.editCorreo.text.toString()} y ${binding.editPass.text.toString()}",
                Snackbar.LENGTH_SHORT
            ).show()
        }
        binding.btnRegistrar.setOnClickListener {
            val perfil: String = binding.spinnerPerfil.selectedItem.toString()
            val recordar: Boolean = binding.checkRecordar.isChecked;
            Snackbar.make(
                it,
                "los datos son ${perfil} y ${recordar}",
                Snackbar.LENGTH_SHORT
            ).show()
        }
        // pon a escucha cuando se hace click -> onChange(v: View, b: Boolean)
        binding.checkRecordar.setOnCheckedChangeListener { view, state ->
            binding.editPass.isEnabled = state;
        }
        // cuando camba la seleccion del spinner -> onItemSelected / onNothingSelected
        binding.spinnerPerfil.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Snackbar.make(
                    binding.root,
                    "El elemento seleccionado es ${parent!!.adapter.getItem(position).toString()}",
                    Snackbar.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }


    }


    /*
    override fun onClick(v: View?) {
        when(v.id){
            binding.btnLogin.id->{}
            binding.btnRegistrar.id->{}
        }
    }*/
}