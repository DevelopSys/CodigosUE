package com.example.dudascalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import com.example.dudascalculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    var operandoUno: Int = 0;
    var operandoDos: Int = 0;
    var operacion: Int = 0; // sumar 0, restar 1
    var operando: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botonDos.setOnClickListener(this)
        binding.botonUno.setOnClickListener(this)
        binding.botonIgual.setOnClickListener(this)
        binding.botonMas.setOnClickListener(this)
        binding.botonMenos.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {

            binding.botonUno.id -> {
                if (!operando) {
                    binding.textoCalculadora.append((v as Button).text)
                } else {
                    binding.textoCalculadora.text = ((v as Button).text)
                    operando = false
                }
            }

            binding.botonDos.id -> {
                if (!operando) {
                    binding.textoCalculadora.append((v as Button).text)
                } else {
                    binding.textoCalculadora.text = ((v as Button).text)
                    operando = false
                }
            }

            binding.botonMas.id -> {
                operandoUno = binding.textoCalculadora.text.toString().toInt()
                operacion = 0;
                operando = true;
            }

            binding.botonMenos.id -> {
                operandoUno = binding.textoCalculadora.text.toString().toInt()
                operacion = 1;
                operando = true;
            }

            binding.botonIgual.id -> {
                // operandoUno
                operandoDos = binding.textoCalculadora.text.toString().toInt();
                var resultado: Int = 0;
                when (operacion) {
                    0 -> {
                        resultado = operandoUno + operandoDos
                    }

                    1 -> {
                        resultado = operandoUno - operandoDos
                    }
                }
                binding.textoCalculadora.text = resultado.toString()
            }
        }
    }
}