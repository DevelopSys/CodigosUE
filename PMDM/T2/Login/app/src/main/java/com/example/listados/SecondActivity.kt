package com.example.listados

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listados.adapter.UsersAdapter
import com.example.listados.databinding.ActivitySecondBinding
import com.example.listados.model.Contacto
import com.example.listados.model.Usuario
import com.google.android.material.snackbar.Snackbar

// TODO. PASO 5: Implemento la interfaz en el destino de la comunicacion
class SecondActivity : AppCompatActivity(), UsersAdapter.OnRecyclerUsuarioListener {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var usuarioRecuperado: Usuario
    private lateinit var usersAdapter: UsersAdapter
    private lateinit var listaUsuarios: ArrayList<Contacto>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        listaUsuarios = ArrayList();

        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)


        usersAdapter = UsersAdapter(listaUsuarios, this);

        usuarioRecuperado = intent.extras!!.getSerializable("usuario") as Usuario
        supportActionBar!!.title = "Bienvenido ${usuarioRecuperado.correo}"
        //binding.textoUsuario.text = usuarioRecuperado.correo

        binding.spinnerGenero.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val seleccionado = parent!!.adapter.getItem(position).toString()
                Snackbar.make(binding.root, seleccionado, Snackbar.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
        // parte grafica -> XML
        binding.recyclerUsuarios.adapter = usersAdapter
        binding.recyclerUsuarios.layoutManager =
            LinearLayoutManager(
                applicationContext, LinearLayoutManager.VERTICAL,
                false
            )

        // parte datos -> Adapter RecyclerView.Adapter<ViewHolder>


        /*binding.botonAgregar.setOnClickListener {
            usersAdapter.addContact(Contacto("Nombre", "Apellido", 123123, R.drawable.imagen1))
        }*/
        /*binding.botonLogout.setOnClickListener {
            finish()
        }*/
    }

    override fun onContactoSelected(contacto: Contacto) {
        Snackbar.make(
            binding.root, "Conctacto recibido con nombre ${contacto.nombre}",
            Snackbar.LENGTH_SHORT
        ).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.menu_add->{
                usersAdapter.addContact(Contacto("Nombre", "Apellido", 123123, R.drawable.imagen1))
            }
            R.id.menu_logout->{
                finish()
            }
            R.id.menu_filtrar->{}
        }

        return true
    }
}