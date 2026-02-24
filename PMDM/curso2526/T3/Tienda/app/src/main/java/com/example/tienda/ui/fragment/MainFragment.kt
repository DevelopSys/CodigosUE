package com.example.tienda.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tienda.R
import com.example.tienda.databinding.FragmentMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()

        binding.buttonRegister.setOnClickListener {
            auth.createUserWithEmailAndPassword(
                binding.editCorreo.text.toString(),
                binding.editPass.text.toString()
            )
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Snackbar.make(
                            binding.root,
                            "El usuario ha sido creado con exito",
                            Snackbar.LENGTH_SHORT
                        ).show()
                        // dialogo para preguntar si quiero inicializar la app
                    } else {
                        Snackbar.make(
                            binding.root,
                            "El usuario no ha sido creado, error en el proceso",
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                }
        }
        binding.buttonLogin.setOnClickListener {
            auth.signInWithEmailAndPassword(
                binding.editCorreo.text.toString(),
                binding.editPass.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    /*
                    Snackbar.make(
                        binding.root, "Login correcto",
                        Snackbar.LENGTH_INDEFINITE
                    ).setAction("Queres iniciar sesion") {
                        findNavController().navigate(R.id.action_mainFragment_to_listaFragment)
                    }.show()*/
                    findNavController().navigate(R.id.action_mainFragment_to_listaFragment)
                } else {
                    Snackbar.make(
                        binding.root,
                        "El usuario no encontrado",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }

        binding.buttonF12.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_listaFragment)
        }
    }
}