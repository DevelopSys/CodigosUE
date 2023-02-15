package com.example.plantilla

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.plantilla.databinding.FregmentThirdBinding

class ThirdFragment : Fragment() {

    private lateinit var binding: FregmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FregmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.botonInicio.setOnClickListener {
            // lo que pasa cuando pulso el boton
            binding.botonInicio.setOnClickListener {
                findNavController().navigate(R.id.action_thirdFragment_to_FirstFragment)
            }
        }
    }
}