package com.example.tienda.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tienda.R
import com.example.tienda.databinding.FragmentListBinding
import com.example.tienda.databinding.FragmentMainBinding
import com.google.firebase.auth.FirebaseAuth

class ListaFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
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
        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()

        val uid = auth.currentUser!!.uid
        binding.textoSaludo.text = "Bienvenido $uid"
        binding.buttonF21.setOnClickListener {
            findNavController().navigate(R.id.action_listaFragment_to_mainFragment)
        }
        binding.buttonF23.setOnClickListener {
            findNavController().navigate(R.id.action_listaFragment_to_detailFragment)
        }

        binding.buttonF2D.setOnClickListener {
            auth.signOut()
            findNavController().navigate(R.id.action_listaFragment_to_mainFragment)
        }
    }
}