package com.example.agendajson.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.agendajson.databinding.ItemRecyclerBinding

class DialogAyuda : DialogFragment() {

    private lateinit var opciones: Array<CharSequence>
    private var seleccionado: String? = null;
    private var listaOpciones = arrayListOf<String>()

    // onAttach -> se pega a la pantalla
    override fun onAttach(context: Context) {
        super.onAttach(context)
        opciones = arrayOf("Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4")
    }

    // onCreateDialog -> junta logica+grafica
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Ayuda")
        // builder.setMessage("Esta app muestra datos de un JSON API REST")
        /*builder.setItems(opciones, { _, position ->
            {
                Log.v("dialogo", "pulsado posicion ${opciones[position]}")
            }
        })*/

        /*builder.setSingleChoiceItems(
            opciones,
            -1,
            { view, position ->
                // Log.v("dialogo", "pulsado posicion ${opciones[position]}")
                seleccionado = opciones[position].toString()
            })*/
        builder.setMultiChoiceItems(opciones, null,
            { view, position, check ->
                if(check){
                    listaOpciones.add(opciones[position].toString())
                } else {
                    listaOpciones.remove(opciones[position].toString())
                }

            })
        builder.setPositiveButton("OK", { _, _ ->
            Log.v("dialogo", "El seleccionado es ${seleccionado ?: "No hay seleccion"}")
            Log.v("dialogo", "El seleccionado es ${listaOpciones}")
        })
        builder.setNegativeButton("NO", { _, _ ->
            Log.v("dialogo", "pulsado el boton no")
        })
        builder.setNeutralButton("CANCEL", { _, _ ->
            Log.v("dialogo", "pulsado el boton cancel")
        })
        // val binding: ItemRecyclerBinding = ItemRecyclerBinding.inflate(layoutInflater)
        // builder.setView(binding.root)

        return builder.create()

        // super.onCreateDialog(savedInstanceState)
    }
    // onDetach -> despegar de la pantalla
}