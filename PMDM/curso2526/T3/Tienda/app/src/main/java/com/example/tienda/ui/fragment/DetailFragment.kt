package com.example.tienda.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tienda.R
import com.example.tienda.databinding.FragmentDetailBinding
import com.example.tienda.databinding.FragmentMainBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.buttonF31.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_mainFragment)
        }
        binding.buttonF32.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_listaFragment)
        }

        binding.buttonF3Dialog.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_dialogoConfirmacion)
        }
    }
}