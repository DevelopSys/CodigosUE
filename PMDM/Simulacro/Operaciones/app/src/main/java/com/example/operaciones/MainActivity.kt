package com.example.operaciones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.operaciones.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaOperaciones: ArrayList<String>
    private lateinit var adaptadorOperaciones: ArrayAdapter<CharSequence>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        /*listaOperaciones = ArrayList();
        listaOperaciones.add("suma")
        listaOperaciones.add("resta")
        listaOperaciones.add("multiplicacion")
        listaOperaciones.add("division")*/

        /*adaptadorOperaciones = ArrayAdapter(applicationContext,
            android.R.layout.simple_spinner_item, listaOperaciones)*/

        adaptadorOperaciones = ArrayAdapter.createFromResource(applicationContext, R.array.operaciones,android.R.layout.simple_spinner_item)

        binding.spinnerOperacion.adapter = adaptadorOperaciones;

        binding.botonOperar.setOnClickListener {

            if (!binding.editOp1.text.isBlank() && !binding.editOp2.text.isBlank()){
            // si hay cosas en los dos edit
                // 1. saber que hay en el spinner
                //val operacion1 = binding.spinnerOperacion.adapter.getItem(binding.spinnerOperacion.selectedItemPosition)
                val operacion2 = binding.spinnerOperacion.selectedItem
                val op1: Int = binding.editOp1.text.toString().toInt()
                val op2: Int = binding.editOp2.text.toString().toInt()
                var resultado: Int =0;
                when(operacion2.toString().lowercase()){
                    "suma"->{
                        resultado = op1+op2;
                    }
                    "resta"->{
                        resultado = op1-op2;
                    }
                    "multiplicacion"->{
                        resultado = op1*op2;
                    }
                    "division"->{
                        resultado = op1/op2;
                    }
                }
                Snackbar.make(binding.botonOperar,resultado.toString(),Snackbar.LENGTH_SHORT).show()
                // 2. dependiendo de la op hacer una cosa u otra
            } else{
            // si no hay cosas en los dos edit saca aviso
                Snackbar.make(binding.botonOperar,"No hay datos para operar",Snackbar.LENGTH_SHORT).show()

            }


        }

    }
}