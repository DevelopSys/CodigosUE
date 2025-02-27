package com.example.navegacion.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navegacion.R
import com.example.navegacion.databinding.FragmentLoginBinding
import com.example.navegacion.ui.model.User

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    // metodo que asocia lo grafico y lo logico
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnLogin.setOnClickListener {

            val bundle = Bundle()
            val usuario = User(binding.editCorreo.text.toString(), binding.editPass.text.toString())
            bundle.putSerializable("usuario", usuario )
            findNavController().navigate(R.id.action_loginFragment_to_mainFragment,bundle)
        }
        binding.btnRegistro.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registroFragment)
        }
    }

}