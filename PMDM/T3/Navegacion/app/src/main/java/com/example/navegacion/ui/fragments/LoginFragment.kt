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

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private var correo: String? = null
    private var pass: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        correo = arguments?.getString("correo")
        pass = arguments?.getString("password")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (correo!=null && pass !=null){
            binding.editCorreo.setText(correo)
            binding.editPass.setText(pass)
        }
        binding.botonLogin.setOnClickListener {
            // FB
            val bundle = Bundle()
            bundle.putString("correo",binding.editCorreo.text.toString())
            findNavController().navigate(R.id.action_loginFragment_to_mainFragment, bundle)
        }
        binding.botonRegistro.setOnClickListener {
            // FB
            findNavController().navigate(R.id.action_loginFragment_to_registroFragment)
        }
    }
    override fun onDetach() {
        super.onDetach()
    }

}