package com.example.listados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.RadioButton
import com.example.listados.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Date

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)





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