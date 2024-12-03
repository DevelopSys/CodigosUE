package com.example.seleccion

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.seleccion.databinding.ActivityCochesBinding
import com.example.seleccion.databinding.ActivityMainBinding
import com.example.seleccion.model.Marca
import com.google.android.material.snackbar.Snackbar

class CochesAcivity : AppCompatActivity(), OnClickListener, OnItemSelectedListener {
    private lateinit var binding: ActivityCochesBinding
    private lateinit var listaMarcas: ArrayList<Marca>
    private lateinit var adaptadorMarcasSpinner: ArrayAdapter<Marca>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCochesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        acciones()

    }

    private fun instancias() {
        listaMarcas = arrayListOf(
            Marca("Mercedes", 1897, -1),
            Marca("Ford", 1927, -1),
            Marca("VW", 1197, -1),
            Marca("Audi", 1397, -1)
        )
        adaptadorMarcasSpinner = ArrayAdapter(applicationContext
            ,android.R.layout.simple_spinner_item
            ,listaMarcas)
        adaptadorMarcasSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerMarcasDinamico.adapter = adaptadorMarcasSpinner
    }

    private fun acciones() {
        binding.botonMarcas.setOnClickListener(this)
        binding.spinnerMarcas.onItemSelectedListener = this
        binding.spinnerMarcasDinamico.onItemSelectedListener = this
    }

    override fun onClick(p0: View?) {
        // when si hay mas de 1 boton
        val marca: String = binding.spinnerMarcas.selectedItem.toString()
        Snackbar.make(binding.root, "La marca seleccionada es ${marca}", Snackbar.LENGTH_SHORT)
            .show()
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        // p0 el elemento que ha provocado la accion -> when
        // p1 la fila que se ha seleccionado, pero en modo view
        // p2 la posicion seleccionada del spinner
        // p3 el id de la posicion seleccionada
        when(p0!!.id){
            binding.spinnerMarcas.id->{
                val marca: String = p0!!.adapter.getItem(p2).toString()
                // val marca: String = binding.spinnerMarcas.adapter
                Snackbar.make(binding.root, "La marca seleccionada es ${marca}", Snackbar.LENGTH_SHORT)
                    .show()
            }
            binding.spinnerMarcasDinamico.id->{
                val marca: Marca = p0!!.adapter.getItem(p2) as Marca
                Snackbar.make(binding.root, "La marca seleccionada es ${marca.anio}", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}