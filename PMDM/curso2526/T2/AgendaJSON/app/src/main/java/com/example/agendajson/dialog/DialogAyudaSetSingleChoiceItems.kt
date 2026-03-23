package com.example.agendajson.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class DialogAyudaSetSingleChoiceItems: DialogFragment() {
    private lateinit var opciones: Array<CharSequence>
    private var seleccionado: String? = null

    override fun onAttach(context: Context) { // se pega a la pantalla
        super.onAttach(context)
        opciones = arrayOf("Opción 1", "Opción 2", "Opción 3", "Opción 4")
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog { // junta lógica + gráfica
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Ayuda - setSingleChoiceItems")
        builder.setSingleChoiceItems(opciones, -1) { _, position ->
            seleccionado = opciones[position].toString()
            Log.v("dialogo", "[----- seleccionado -----] -> el seleccionado es '${seleccionado ?: "No hay selección"}'")
            /*// Opción también válida:
            Log.v("dialogo", "[ --opciones[position]-- ] -> el seleccionado es '${opciones[position]}'")*/
        }
        builder.setPositiveButton("OK") { _, _ ->
            Log.v("dialogo", "[---------- OK ----------] -> el seleccionado es '${seleccionado ?: "No hay selección"}'")
        }
        return builder.create()
    }

    // onDetach -> despegar de la pantalla

}