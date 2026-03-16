package com.example.tienda.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tienda.R
import com.example.tienda.databinding.FragmentListBinding
import com.example.tienda.databinding.FragmentMainBinding
import com.example.tienda.model.Product
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ListaFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var firebaseDatabase: FirebaseDatabase

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        firebaseDatabase = FirebaseDatabase
            .getInstance("https://bmhue2526-default-rtdb.europe-west1.firebasedatabase.app/")
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
        binding.btnAgregar.setOnClickListener {
            // firebaseDatabase.reference.child("nAPP").setValue("Usuarios APP")
            val product = Product(3, "Zapatillas", "Zapatillas de deporte", 150.90)
            val databaseReference = firebaseDatabase.reference.child("productos")
                .child(product.id.toString())

            /*
            databaseReference.child("nombre").setValue(product.nombre)
            databaseReference.child("precio").setValue(product.precio)
            databaseReference.child("descripcion").setValue(product.descripcion)*/
            databaseReference.setValue(product)
        }
        binding.btnEliminar.setOnClickListener {
            firebaseDatabase.reference.child("nAPP").setValue(null)
        }
        binding.btnConsultar.setOnClickListener {

            firebaseDatabase.reference.child("productos")
                .addValueEventListener(object : ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        Log.v("firebase", snapshot.toString())
                        // snapshot.getValue()
                    }

                    override fun onCancelled(error: DatabaseError) {

                    }

                })

                /*
                .addChildEventListener(object : ChildEventListener {
                    override fun onChildAdded(
                        snapshot: DataSnapshot,
                        previousChildName: String?
                    ) {
                        Log.v("firebase", "onChildAdded: ${snapshot.toString()}")


                    }

                    override fun onChildChanged(
                        snapshot: DataSnapshot,
                        previousChildName: String?
                    ) {
                        Log.v("firebase", "onChildChanged: ${snapshot.toString()}")
                    }

                    override fun onChildRemoved(snapshot: DataSnapshot) {
                        Log.v("firebase", "onChildRemoved: ${snapshot.toString()}")
                    }

                    override fun onChildMoved(
                        snapshot: DataSnapshot,
                        previousChildName: String?
                    ) {
                        Log.v("firebase", "onChildMoved: ${snapshot.toString()}")
                    }

                    override fun onCancelled(error: DatabaseError) {
                    }

                })
                */

        }
    }
}
