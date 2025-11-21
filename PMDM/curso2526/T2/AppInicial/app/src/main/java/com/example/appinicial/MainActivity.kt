package com.example.appinicial

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appinicial.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // Todos los elementos que se han definido en la parte grafica
    private lateinit var binding: ActivityMainBinding // nunca se inicializan aqui

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        this.setContentView(binding.root)
        // despues de esta linea puedo hacer lo que quiera con los elementos graficos
        acciones()
    }

    private fun acciones() {
        // esta interfaz trae el metodo onClick -> solo tiene un parametro que es u view,
        // el elemento que ha provocado la pulsacion
        /*
        binding.botonSaluda.setOnClickListener {
            Snackbar.make(
                it, "Perfecto, primera app completada",
                Snackbar.LENGTH_SHORT
            ).show()
        }
        binding.botonLimpiar.setOnClickListener {
            Snackbar.make(
                it, "Perfecto, vamos a limpiar",
                Snackbar.LENGTH_SHORT
            ).show()
        }
        binding.botonCerrar.setOnClickListener {
            Snackbar.make(
                it, "Perfecto, vamos a cerrar",
                Snackbar.LENGTH_SHORT
            ).show()
        }*/
        binding.botonSaluda.setOnClickListener(this)
        binding.botonCerrar.setOnClickListener(this)
        binding.botonLimpiar.setOnClickListener(this)
        binding.botonCambio?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        // decidir que boton ha sido el pulsado
        // los tres o n botones tienen algo comun hazlo
        when (v?.id) {
            binding.botonLimpiar.id -> {
                binding.editNombre.text.clear()
            }

            binding.botonCerrar.id -> {
                finish()
            }

            binding.botonSaluda.id -> {
                if (binding.editNombre.text.isNotEmpty()){
                    Snackbar.make(
                        v, "Perfecto ${binding.editNombre.text.toString()}, primera app completada",
                        Snackbar.LENGTH_SHORT
                    ).show()
                    binding.editNombre.text.clear()
                } else {
                    Snackbar.make(
                        v, "Por favor introduce datos",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }

            }

            binding.botonCambio?.id ->{
                // intent -> acciones
                // desde donde viajas, hasta donde viajase
                val intent: Intent= Intent(this, SecondActivity::class.java)
                startActivity(intent)

            }
        }
    }
}