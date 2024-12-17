package com.example.pasodatos

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pasodatos.databinding.ActivityMainBinding
import com.example.pasodatos.model.Usuario
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonLogin.setOnClickListener {
            // evaluar, si todos los datos estan rellenos
            if (binding.editPass.text.isNotEmpty() && binding.editCorreo.text.isNotEmpty()) {
                // evaluar, si los datos de correo y pass estan en bd
                if (binding.editCorreo.text.toString().equals("admin@gmail.com", true)
                    && binding.editPass.text.toString().equals("1234", true)
                ) {
                    // pasar de pantalla
                    // origen - destino
                    val intent = Intent(applicationContext, SecondActivity::class.java)
                    // intent.putExtra("correo", binding.editCorreo.text.toString())
                    // intent.putExtra("pass", binding.editPass.text.toString())
                    intent.putExtra(
                        "dato",
                        Usuario(
                            binding.editCorreo.text.toString(),
                            binding.editPass.text.toString()
                        )
                    )
                    startActivity(intent)
                } else {
                    Snackbar.make(binding.root, "Fallo de credenciales", Snackbar.LENGTH_SHORT)
                        .show()
                }
            } else {
                Snackbar.make(binding.root, "Faltan datos por rellenar", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }

    }
}