package com.example.listados.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class LogoutDialogo: DialogFragment() {

    private lateinit var contexto: Context
    private lateinit var listener: OnDialogoLouOutListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context
        this.listener = contexto as OnDialogoLouOutListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(contexto)

        // titulo
        builder.setTitle("Cerrar sesion")
        // mensaje
        builder.setMessage("¿Estas seguro que quieres cerrar sesion?")
        // botones
        builder.setPositiveButton("SI"){ _, _ ->
            // cerrar sesion
            listener.onLogOutSelected()
            // finish()
            // dismiss()
            //Toast.makeText(contexto, "Boton pulsado", Toast.LENGTH_SHORT).show()
        }

        builder.setNegativeButton("NO"){ _, _ ->
            // no cerrar sesion
            //Toast.makeText(contexto, "Boton pulsado", Toast.LENGTH_SHORT).show()
        }

        return builder.create()
    }

    interface OnDialogoLouOutListener{

        fun onLogOutSelected()
    }
}