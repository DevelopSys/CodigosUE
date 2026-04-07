package com.example.agendajson.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class DialogAyudaSetMultiChoiceItems: DialogFragment() {
    private lateinit var opciones: Array<CharSequence>
    private var listaOpciones = arrayListOf<String>()

    override fun onAttach(context: Context) { // -> se pega a la pantalla
        super.onAttach(context)
        opciones = arrayOf("Opción 1", "Opción 2", "Opción 3", "Opción 4")
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog { // -> junta lógica + gráfica
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Ayuda - setMultiChoiceItems")
        builder.setMultiChoiceItems(opciones, null) { _, position, check ->
            if (check) {
                listaOpciones.add(opciones[position].toString())
                Log.v("dialogo", "[------- Marcado --------] -> ${opciones[position]}")
            }else {
                listaOpciones.remove(opciones[position].toString())
                Log.v("dialogo", "[------ Desmarcado ------] -> ${opciones[position]}")
            }
        }
        builder.setPositiveButton("OK") { _, _ ->
            val mensaje = when (listaOpciones.size) {
                0 -> "ninguna opción seleccionada"
                1 -> "la opción seleccionada es ${listaOpciones[0]}"
                else -> "las opciones seleccionadas son $listaOpciones"
            }
            Log.v("dialogo", "[---------- OK ----------] -> $mensaje")
        }
        return builder.create()
    }

    // onDetach -> despegar de la pantalla

}