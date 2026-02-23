package com.example.tienda.ui.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.tienda.R

class DialogoConfirmacion: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder : AlertDialog.Builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Navegacion")
        builder.setMessage("Quires navegar al main fragment")
        builder.setPositiveButton("SI"){_,_->
            findNavController().navigate(R.id.action_dialogoConfirmacion_to_mainFragment)
        }

        return builder.create()
    }
}