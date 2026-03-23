package com.example.agendajson.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class DialogAyudaSetMessage: DialogFragment() {

    // onAttach -> se pega a la pantalla

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog { // junta lógica + gráfica
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Ayuda - setMessage")
        builder.setMessage("Esta app muestra datos de un JSON API REST")
        // PODEMOS SACAR EL lambda CUANDO ES EL ÚLTIMO PARÁMETRO
        builder.setPositiveButton("OK") { _, _ ->
            Log.v("dialogo", "[---------- OK ----------] -> pulsado el botón 'OK'")
        }
        builder.setNegativeButton("NO") { _, _ ->
            Log.v("dialogo", "[---------- NO ----------] -> pulsado el botón 'NO'")
        }
        builder.setNeutralButton("CANCEL") { _, _ ->
            Log.v("dialogo", "[-------- CANCEL --------] -> pulsado el botón 'CANCEL'")
        }
        return builder.create() // IMPORTANTE
    }

    // onDetach -> despegar de la pantalla

}