package com.example.listaproductos

import android.os.Bundle
import android.widget.Adapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listaproductos.adapter.ProductosAdapter
import com.example.listaproductos.databinding.ActivityMainBinding
import com.example.listaproductos.model.Producto

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterProductos: ProductosAdapter
    private lateinit var lista: ArrayList<Producto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        initGUI()
    }

    private fun initGUI() {
        binding.recyclerProductos.adapter = adapterProductos
        if (resources.configuration.orientation == 1){
            binding.recyclerProductos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        } else if(resources.configuration.orientation == 2){
        binding.recyclerProductos.layoutManager =
            GridLayoutManager(this,2, LinearLayoutManager.VERTICAL, false)
        }
            // LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun instancias() {

        lista = arrayListOf(
            Producto("Camiseta", 10.20, "Camiseta de deporte", 4, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJ7LPGg1I3JUDFa4F9DT2ru6zIFOIJQQEZyA&s"),
            Producto("Pantalones", 20.20, "Pantalones de deporte", 4, "https://www.ekipol.com/30136-large_default/pantalon-de-deporte-jogging-largo-vestuario-oficial-cnp-deporte.jpg"),
            Producto("Zapatillas", 40.20, "Zapatillas de deporte", 4, "https://sgfm.elcorteingles.es/SGFM/dctm/MEDIA03/202406/06/00117730873530____9__640x640.jpg"),
            Producto("Camisa", 40.20, "Camisa de vestir", 4, ""),
            Producto("Zapatos", 70.20, "Zapatos de vestir", 4, ""),
        )
        adapterProductos = ProductosAdapter(lista, this)
    }
}