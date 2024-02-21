package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebase.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonUsuario.setOnClickListener {
            auth.signInWithEmailAndPassword("bmartin2@gmail.com","UE1234a")
                .addOnCompleteListener {
                    if(it.isSuccessful){
                        // hare algo -> navego
                    } else {
                        // hare otra cosa
                    }
                }
            auth.createUserWithEmailAndPassword("bmartin2@gmail.com","UE1234a")
                .addOnCompleteListener {
                    if(it.isSuccessful){
                        Snackbar.make(binding.root,"Usuario creado con exito",Snackbar.LENGTH_SHORT).show()
                        auth.currentUser
                    } else {
                        Snackbar.make(binding.root,"Fallo en el proceso",Snackbar.LENGTH_SHORT).show()
                    }
                }
        }
    }
}