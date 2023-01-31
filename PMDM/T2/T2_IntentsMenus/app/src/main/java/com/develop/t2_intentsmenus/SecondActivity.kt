package com.develop.t2_intentsmenus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.develop.t2_intentsmenus.databinding.ActivitySecondBinding
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recuperarDatos()


        /* val radioSeleccionado: RadioButton = findViewById(binding.grupoSexo.checkedRadioButtonId)
        radioSeleccionado.text*/
        binding.grupoSexo.setOnCheckedChangeListener { radioGroup, i ->
            val radioSeleccionado: RadioButton = findViewById(i)
            Snackbar.make(binding.root,radioSeleccionado.text,Snackbar.LENGTH_SHORT).show()
        }

    }

    private fun recuperarDatos() {
        // quien tiene datos?? --> el objeto que me ha arrancado

        var prueba: String = "7";




        val bundle: Bundle? = intent.extras
        val nombre = bundle?.getString("nombre") ?: "Por defecto"
        val edad = bundle?.getInt("edad") ?: "0"
        val experiencia = bundle?.getBoolean("experiencia") ?: "True"
        val otra = bundle?.getInt("anios",50) ?: 0

        binding.nombreRecuperar.text = nombre
        binding.edadRecuperar.text = edad.toString()
        binding.experienciaRecuperar.text = otra.toString()



    }
}