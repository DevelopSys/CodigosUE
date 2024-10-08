package com.example.listados.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.listados.R

class FiltrarDialogo : DialogFragment() {

    private lateinit var contexto: Context
    private lateinit var button: Button
    private lateinit var spinner: Spinner
    private lateinit var vista: View;

    //TODO
    private lateinit var listener: OnDialogoFiltrarListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context
        this.listener = contexto as OnDialogoFiltrarListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(contexto)

        vista = LayoutInflater.from(context)
            .inflate(R.layout.dilogo_filtrar, null)

        builder.setView(vista)

        button = vista.findViewById(R.id.boton_filtrar_dialogo)
        spinner = vista.findViewById(R.id.spinner_generos_dialogo)

        return builder.create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener {
            listener.onFiltrarSelected(spinner.selectedItem.toString())
            dismiss()
        }
    }



    interface OnDialogoFiltrarListener {

        fun onFiltrarSelected(genero: String)
    }
}