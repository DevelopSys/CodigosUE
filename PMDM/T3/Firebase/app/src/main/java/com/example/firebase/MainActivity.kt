package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.firebase.databinding.ActivityMainBinding
import com.example.firebase.model.Producto
import com.example.firebase.model.Usuario
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database =
            FirebaseDatabase.getInstance("https://bmh-ue2324-default-rtdb.europe-west1.firebasedatabase.app/")

        binding.botonUsuario.setOnClickListener {
            /*auth.signInWithEmailAndPassword("bmartin2@gmail.com", "UE1234a")
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        // hare algo -> navego
                    } else {
                        // hare otra cosa
                    }
                }*/
            auth.createUserWithEmailAndPassword("bmartin4@gmail.com", "UE1234a")
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Snackbar.make(
                            binding.root,
                            "Usuario creado con exito",
                            Snackbar.LENGTH_SHORT
                        ).show()
                        database.getReference("usuarios").child(auth.currentUser!!.uid)
                            .child("nombre").setValue("bmartin4@gmail.com")

                    } else {
                        Snackbar.make(binding.root, "Fallo en el proceso", Snackbar.LENGTH_SHORT)
                            .show()
                    }
                }
        }
        binding.botonBaseDatos.setOnClickListener {
            val referencia = database.getReference("usuarios").child("4")
            referencia.setValue(Usuario("BorjaObj", 45, false))
        }

        //binding.botonLectura.setOnClickListener {
        val referencia = database.getReference("productos").orderByChild("stock")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    snapshot.children.forEach {
                        // id, precio, nombre, foto, marca
                        val producto: Producto = it.getValue(Producto::class.java) as Producto
                        Log.v("datos", producto.title.toString())
                        // adapter.agregarProducto(producto)
                    }

                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
        //}
    }
}