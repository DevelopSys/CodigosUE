package com.example.listados

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var usuarioRecuperado: Usuario
    private lateinit var usersAdapter: UsersAdapter
    private lateinit var listaUsuarios: ArrayList<Contacto>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        listaUsuarios = ArrayList();
        listaUsuarios.add(Contacto("Borja1","MArtin",1234,R.drawable.imagen1))
        listaUsuarios.add(Contacto("Borja2","MArtin",1234,R.drawable.imagen2))
        listaUsuarios.add(Contacto("Borja3","MArtin",1234,R.drawable.imagen3))
        listaUsuarios.add(Contacto("Borja4","MArtin",1234,R.drawable.imagen3))
        listaUsuarios.add(Contacto("Borja5","MArtin",1234,R.drawable.imagen3))
        listaUsuarios.add(Contacto("Borja6","MArtin",1234,R.drawable.imagen3))

        setContentView(binding.root)
        usersAdapter = UsersAdapter(listaUsuarios, this);
        listaUsuarios.add(Contacto("Borja6","MArtin",1234,R.drawable.imagen3))
        usersAdapter.notifyItemInserted(listaUsuarios.size-1)

        usuarioRecuperado = intent.extras!!.getSerializable("usuario") as Usuario
        binding.textoUsuario.text = usuarioRecuperado.correo

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


        binding.botonLogout.setOnClickListener {
            finish()
        }
    }
}