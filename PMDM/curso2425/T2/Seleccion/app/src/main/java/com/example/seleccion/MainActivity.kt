package com.example.seleccion

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.seleccion.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener,
    OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        resources.configuration.orientation

        binding.btnComprobar.setOnClickListener(this)
        binding.toggleSeleccion.setOnCheckedChangeListener(this)
        binding.checkActivar.setOnCheckedChangeListener(this)
        binding.grupoRadios.setOnCheckedChangeListener(this)


    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.btnComprobar.id -> {
                /*Snackbar.make(
                    binding.root,
                    "El estado del toggle es ${binding.toggleSeleccion.isChecked}",
                    Snackbar.LENGTH_SHORT
                ).show()*/
                /*binding.toggleSeleccion.isChecked = !binding.toggleSeleccion.isChecked
                val seleccionado: RadioButton =
                    findViewById(binding.grupoRadios.checkedRadioButtonId)
                Snackbar.make(
                    binding.root,
                    "El seleccionado es ${seleccionado.text}",
                    Snackbar.LENGTH_SHORT
                ).show()*/
                /*val seleccionado: Int = binding.grupoRadios.checkedRadioButtonId
                when(seleccionado){
                    binding.radio1.id->{}
                    binding.radio2.id->{}
                }*/

                /*if (binding.toggleSeleccion.isChecked) {
                    binding.toggleSeleccion.isChecked = false;
                } else {
                    binding.toggleSeleccion.isChecked = true;
                }*/
            }
        }
    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        when (p0?.id) {
            binding.toggleSeleccion.id -> {
                binding.textoToggle.text = p1.toString()
            }

            binding.checkActivar.id -> {
                binding.btnComprobar.isEnabled = p1
            }
        }
    }

    override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
        when(p1){
            binding.radio1.id->{

            }
            binding.radio2.id->{

            }
        }
    }
}