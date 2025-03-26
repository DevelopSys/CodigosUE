package com.example.navegacion.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navegacion.R
import com.example.navegacion.databinding.FragmentLoginBinding
import com.example.navegacion.databinding.FragmentMainBinding
import com.example.navegacion.databinding.FragmentRegistroBinding
import com.example.navegacion.ui.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    private var usuario: User? = null;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        database =
            FirebaseDatabase.getInstance("https://agendaapp-f2321-default-rtdb.europe-west1.firebasedatabase.app/")
        if (arguments?.getSerializable("usuario") != null) {
            this.usuario = arguments?.getSerializable("usuario") as User
        }
    }

    // metodo que asocia lo grafico y lo logico
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        Log.v("usuario", auth.currentUser!!.uid)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        database.reference.child("app").child("nombre")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    // Log.v("datos",snapshot.value.toString())
                    binding.textoUsuario.text = snapshot.value.toString()
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
        database.reference.child("usuarios").child(auth.currentUser!!.uid)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    // Log.v("datos",snapshot.value.toString())
                    // con los datos del usuario actual
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
        binding.textMain.setText("Iniciado como ${usuario?.correo ?: "invitado"}")
        binding.btnConsulta.setOnClickListener {
            /*database.reference.child("app").child("nombre")
                .get()
                .addOnSuccessListener {
                    // Log.v("dato",it.value.toString())
                    binding.textoUsuario.text = it.value.toString()
                }*/
            /* database.reference.child("usuarios").addValueEventListener(object : ValueEventListener {
                 override fun onDataChange(snapshot: DataSnapshot) {
                     for (i in snapshot.children){
                         val user: User? = i.getValue(User::class.java)
                         Log.v("datos", user!!.nombre!!)
                     }
                 }

                 override fun onCancelled(error: DatabaseError) {
                     TODO("Not yet implemented")
                 }

             })*/
            database.reference.child("usuarios").addChildEventListener(object : ChildEventListener {
                override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                    Log.v("datos", snapshot.toString())
                }

                override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                    Log.v("datos", snapshot.toString())
                }

                override fun onChildRemoved(snapshot: DataSnapshot) {
                    Log.v("datos", snapshot.toString())
                }

                override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                    Log.v("datos", snapshot.toString())
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })

        }
        binding.btnVolver.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_loginFragment)
        }
    }

}