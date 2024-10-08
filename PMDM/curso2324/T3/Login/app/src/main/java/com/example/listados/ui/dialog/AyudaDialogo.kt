package com.example.listados.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class AyudaDialogo: DialogFragment() {

    private lateinit var nombre: String

    companion object{
        fun newInstance(nombre: String): AyudaDialogo{
            val args = Bundle()
            args.putString("nombre",nombre)
            val dialogo = AyudaDialogo()
            dialogo.arguments = args
            return dialogo
        }
    }

    private lateinit var contexto: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context
        nombre = this.arguments?.getString("nombre")?:""
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(contexto)

        // titulo
        builder.setTitle("Ayuda ${nombre}")
        // mensaje
        builder.setMessage("App realizada por Borja Martin")
        // botones
        builder.setPositiveButton("OK"){ _, _ ->
            Toast.makeText(contexto, "Boton pulsado", Toast.LENGTH_SHORT).show()
        }

        return builder.create()
    }
}