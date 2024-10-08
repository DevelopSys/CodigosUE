package com.example.listados.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.RadioButton
import com.example.listados.R
import com.example.listados.databinding.ActivityMainBinding
import com.example.listados.model.Usuario
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonLogin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.botonLimpiar.id->{
            }
            binding.botonLogin.id->{

                // comprobar campos
                if(!binding.editPass.text.isEmpty()
                    && !binding.editCorreo.text.isEmpty()
                    && findViewById<RadioButton>(binding.grupoPerfil.checkedRadioButtonId) != null
                ){
                    val correo = binding.editCorreo.text.toString()
                    val pass = binding.editPass.text.toString()
                    val perfil = binding.spinnerPerfil.selectedItem.toString()
                    val visibilidad = findViewById<RadioButton>(binding.grupoPerfil.checkedRadioButtonId)
                        .text.toString()

                    // cambiar de pantalla -> accion INTENT
                    val intent: Intent = Intent(applicationContext, SecondActivity::class.java)
                    // asociar clave valor
                    intent.putExtra("usuario",Usuario(correo,pass, perfil, visibilidad))
                    startActivity(intent)

                    // (origen, destino)
                    // (accion, datos(URI))

                } else {

                    Snackbar.make(
                        binding.root,
                        resources.getString(R.string.mensaje_datos),
                        Snackbar.LENGTH_SHORT
                    ).show()
                }

            }
        }
    }


}