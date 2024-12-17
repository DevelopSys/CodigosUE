package com.example.pasodatos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pasodatos.databinding.ActivitySecondBinding
import com.example.pasodatos.model.Usuario

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var correo: String
    private lateinit var pass: String
    private var usuarioRecuperado: Usuario? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        usuarioRecuperado = intent.getSerializableExtra("dato") as Usuario
        correo = intent.getStringExtra("correo") ?: "sin correo"
        pass = intent.getStringExtra("pass") ?: "sin pass"
        binding.texto.text = usuarioRecuperado?.pass ?: "sin pass"
}
}