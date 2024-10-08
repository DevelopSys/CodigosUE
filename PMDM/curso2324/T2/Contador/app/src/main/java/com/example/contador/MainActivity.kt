package com.example.contador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import com.example.contador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    // elementos!!!
    /*private lateinit var botonIncremento: Button
    private lateinit var botonDecremento: Button
    private lateinit var textoContador: TextView*/

    // fichero!!
    private lateinit var binding: ActivityMainBinding
    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // pegadas parte logica (this) con parte grafica (xml)
        // rellenar el fichero

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // condicion ? true : false
        contador = savedInstanceState?.getInt("contador") ?: 0
        binding.textoContador.text = contador.toString()


        /*botonIncremento = findViewById(R.id.boton_incremento)
        botonDecremento = findViewById(R.id.boton_incremento)
        textoContador = findViewById(R.id.texto_contador)*/
        // funcionalidad --> cuand pulso + suma uno
        // funcionalidad --> cuand pulso - resta uno
        binding.botonDecremento.setOnClickListener(this)
        binding.botonIncremento.setOnClickListener(this)
        binding.botonReset?.setOnClickListener(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contador",contador)
    }

    override fun onClick(v: View?) {
        // diferenciar cual he pulsado -> 30 botones
        when(v?.id){
            binding.botonIncremento.id->{
                // sumar 1
                contador++;
            }
            binding.botonDecremento.id->{
                // restar 1
                contador--;
            }
            binding.botonReset?.id->{
                contador = 0
            }
        }
        // poner en el texto
        binding.textoContador.text = contador.toString();

    }
}