package com.example.agendajson.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class DialogAyudaSetItems: DialogFragment() {
    private lateinit var opciones: Array<CharSequence>

    override fun onAttach(context: Context) { // se pega a la pantalla
        super.onAttach(context)
        opciones = arrayOf("Opción 1", "Opción 2", "Opción 3", "Opción 4")
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog { // -> junta lógica + gráfica
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Ayuda - setItems")
        builder.setItems(opciones, {_, position ->
            run {
                Log.v("dialogo", "[------- Pulsado --------] -> ${opciones[position]}")
            }
        })
        return builder.create()
    }

    // onDetach -> despegar de la pantalla

}