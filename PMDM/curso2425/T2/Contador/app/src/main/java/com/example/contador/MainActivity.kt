package com.example.contador

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var contador: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(this.layoutInflater)
        // asocia grafico y logico
        setContentView(binding.root)
        contador = savedInstanceState?.getInt("contador") ?: 0
        binding.textoContador.text = contador.toString()
        binding.btnDecremento.setOnClickListener(this)
        binding.btnIncremento.setOnClickListener(this)
        binding.btnRestart?.setOnClickListener(this)
        Log.v("ciclo_vida","Ejecutando onCreate")
    }


    override fun onClick(v: View?) {
        // quien ha provocado el evento?????
        when (v?.id) {
            binding.btnDecremento.id -> {
                // el contador se resta
                contador--
            }

            binding.btnIncremento.id -> {
                // el contador se suma
                contador++;
            }

            binding.btnRestart?.id -> {
                contador = 0;
            }
        }
        Log.v("valor_contador",contador.toString())
        binding.textoContador.text = contador.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo_vida","Ejecutando onDestroy")
    }

    override fun onResume() {
        super.onResume()
        Log.v("ciclo_vida","Ejecutando onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo_vida","Ejecutando onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v("ciclo_vida","Ejecutando onRestart")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contador", contador)
    }
}