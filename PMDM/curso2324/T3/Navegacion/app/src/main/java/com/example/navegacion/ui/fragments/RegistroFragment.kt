package com.example.navegacion.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navegacion.R
import com.example.navegacion.databinding.FragmentLoginBinding
import com.example.navegacion.databinding.FragmentRegistroBinding

class RegistroFragment : Fragment() {

    private lateinit var binding: FragmentRegistroBinding
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistroBinding.inflate(inflater,container,false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.botonRegistro.setOnClickListener {
            // FB
            val bundle = Bundle()
            bundle.putString("correo", binding.editCorreo.text.toString())
            bundle.putString("password", binding.editPass.text.toString())
            findNavController().navigate(R.id.action_registroFragment_to_loginFragment, bundle)
        }
    }


    override fun onDetach() {
        super.onDetach()
    }

}