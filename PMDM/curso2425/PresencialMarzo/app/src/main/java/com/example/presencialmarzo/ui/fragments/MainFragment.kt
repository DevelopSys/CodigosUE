package com.example.presencialmarzo.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.presencialmarzo.databinding.FragmentMainBinding
import com.example.presencialmarzo.model.User
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var database: FirebaseFirestore

    override fun onAttach(context: Context) {
        super.onAttach(context)
        database = FirebaseFirestore.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        val usuario = User()
        binding.btnAgregar.setOnClickListener {
            val user = hashMapOf(
                "nombre" to "Borja",
                "apellido" to "Martin",
                "edad" to 40,
                "correo" to "borja@ue.com"
            )

            database.collection("users").add(user).addOnCompleteListener {
                if (!it.isSuccessful) {
                    Snackbar.make(binding.root, "No se ha podido agregar", Snackbar.LENGTH_SHORT)
                        .show()
                }
            }

            /*
            {
                nombre: "Borja",
                apellido: "Martin",
                edad: 40,
                correo: "borja@ue.com"
            }
            */
        }
        binding.btnConsulta.setOnClickListener {
            /*database.collection("users")
                .get().addOnSuccessListener {
                    for (doc in it){
                        Log.v("datos", doc.get("nombre").toString())
                    }

                }*/

            database.collection("users")
                .addSnapshotListener { value, error -> }
            Log.v("datos", "cambios detectados")
        }
    }
}
