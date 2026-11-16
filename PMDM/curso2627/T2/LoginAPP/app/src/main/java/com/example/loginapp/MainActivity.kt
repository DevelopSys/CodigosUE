package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

// : -> extends (de clases -> constructores) implements (interfaces)
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        /*
        binding.btnLogin.setOnClickListener {
            // lo que pasa al pulsar el boton
        }
        binding.btnRegistro?.setOnClickListener {
            // lo que pasa al pulsar el boton
        }
        binding.btnPass.setOnClickListener {
            // lo que pasa al pulsar el boton
        }
        binding.btnGoogle?.setOnClickListener {
            // lo que pasa al pulsar el boton
        }
        binding.btnFacebook?.setOnClickListener {
            // lo que pasa al pulsar el boton
        }*/
        binding.btnGoogle?.setOnClickListener(this)
        binding.btnPass.setOnClickListener(this)
        binding.btnFacebook?.setOnClickListener(this)
        binding.btnRegistro?.setOnClickListener(this)
        binding.btnLogin.setOnClickListener(this)
    }

    override fun onRestart() {
        super.onRestart()
        binding.editMail.text.clear()
        binding.editPass.text.clear()
    }

    // p0 -> el elemento que ha lanzado el evento
    override fun onClick(p0: View?) {
        // diferenciar cual de los botones es el pulsado
        // acciones en comun (p0 as Button).text
        when (p0?.id) {
            binding.btnLogin.id -> {
                if (binding.editPass.text.isEmpty() || binding.editMail.text.isEmpty()) {
                    Snackbar.make(
                        binding.root,
                        resources.getString(R.string.snack_empty_data),
                        Snackbar.LENGTH_LONG
                    ).show()
                } else {
                    // origen (esta pantalla) destino (secondActivity)
                    // val intent: Intent = Intent(applicationContext)
                    if (binding.editMail.text.toString() == "borja@gmail.com" && binding.editPass.text.toString() == "1234"){
                        val intent: Intent = Intent(this, SecondActivity::class.java)
                        startActivity(intent)
                    } else {
                        Snackbar.make(
                            binding.root,
                            resources.getString(R.string.snack_login),
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                }
            }

            binding.btnPass.id -> {}
            binding.btnGoogle?.id -> {}
            binding.btnFacebook?.id -> {}
            binding.btnRegistro?.id -> {}
        }
    }
}