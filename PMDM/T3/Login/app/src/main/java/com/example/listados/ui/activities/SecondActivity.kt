package com.example.listados.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request.Method
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.listados.R
import com.example.listados.adapter.UsersAdapter
import com.example.listados.databinding.ActivitySecondBinding
import com.example.listados.model.Contacto
import com.example.listados.model.Usuario
import com.example.listados.ui.dialog.AyudaDialogo
import com.example.listados.ui.dialog.FiltrarDialogo
import com.example.listados.ui.dialog.LogoutDialogo
import com.google.android.material.snackbar.Snackbar
import org.json.JSONArray
import org.json.JSONObject

// TODO. PASO 5: Implemento la interfaz en el destino de la comunicacion
class SecondActivity : AppCompatActivity(), UsersAdapter.OnRecyclerUsuarioListener,
    LogoutDialogo.OnDialogoLouOutListener, FiltrarDialogo.OnDialogoFiltrarListener {

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

        /*binding.spinnerGenero.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val seleccionado = parent!!.adapter.getItem(position).toString()
                usersAdapter.filtrarLista(seleccionado)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }*/
        // parte grafica -> XML

        binding.recyclerUsuarios.adapter = usersAdapter
        binding.recyclerUsuarios.layoutManager =
            LinearLayoutManager(
                applicationContext, LinearLayoutManager.VERTICAL,
                false
            )
        rellenarLista();

        /*usersAdapter.addContact(
            Contacto(
                "Borja1",
                "Martin",
                123123,
                R.drawable.imagen1,
                "Masculino"
            )
        )
        usersAdapter.addContact(
            Contacto(
                "Borja2",
                "Martin",
                123123,
                R.drawable.imagen1,
                "Femenino"
            )
        )
        usersAdapter.addContact(
            Contacto(
                "Borja3",
                "Martin",
                123123,
                R.drawable.imagen1,
                "Masculino"
            )
        )
        usersAdapter.addContact(
            Contacto(
                "Borja4",
                "Martin",
                123123,
                R.drawable.imagen1,
                "Masculino"
            )
        )
        usersAdapter.addContact(
            Contacto(
                "Borja5",
                "Martin",
                123123,
                R.drawable.imagen1,
                "Femenino"
            )
        )
        usersAdapter.addContact(
            Contacto(
                "Borja6",
                "Martin",
                123123,
                R.drawable.imagen1,
                "Femenino"
            )
        )*/
        // usersAdapter.filtrarLista("Todos")
        // parte datos -> Adapter RecyclerView.Adapter<ViewHolder>
        /*binding.botonAgregar.setOnClickListener {
            usersAdapter.addContact(Contacto("Nombre", "Apellido", 123123, R.drawable.imagen1))
        }*/
        /*binding.botonLogout.setOnClickListener {
            finish()
        }*/
    }

    fun rellenarLista() {
        // realizar la peticion
        val peticion: JsonObjectRequest =
            JsonObjectRequest("https://dummyjson.com/users/", {
                val users: JSONArray = it.getJSONArray("users")
                for (i in 0 until users.length()) {
                    val user: JSONObject = users.getJSONObject(i)
                    val contacto: Contacto = Contacto(
                        user.getString("firstName"),
                        user.getString("lastName"),
                        user.getString("phone"),
                        user.getString("image"),
                        user.getString("gender")
                    )
                    Log.v("usuario",contacto.imagen)
                    usersAdapter.addContact(contacto)
                }
                //usersAdapter.notifyDataSetChanged()
            },
                {
                    Snackbar.make(binding.root, "Error en la conexion", Snackbar.LENGTH_SHORT)
                        .show()
                })
        //JsonObjectRequest(Method.POST,"https://dummyjson.com/users",null,{},{})
        // lanzar la peticion
        Volley.newRequestQueue(applicationContext).add(peticion)
    }

    override fun onContactoSelected(contacto: Contacto) {
        Snackbar.make(
            binding.root, "Conctacto recibido con nombre ${contacto.nombre}",
            Snackbar.LENGTH_SHORT
        ).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_add -> {
                /*usersAdapter.addContact(
                    Contacto(
                        "Nombre",
                        "Apellido",
                        123123,
                        R.drawable.imagen1,
                        "Masculino"
                    )
                )*/
            }

            R.id.menu_logout -> {
                // preguntar
                val dialogo: LogoutDialogo = LogoutDialogo()
                dialogo.show(supportFragmentManager, null)
                // finish()
            }

            R.id.menu_filtrar -> {
                val dialogo: FiltrarDialogo = FiltrarDialogo()
                dialogo.show(supportFragmentManager, null)
            }

            R.id.menu_ayuda -> {
                val dialogo: AyudaDialogo = AyudaDialogo.newInstance(usuarioRecuperado.correo)
                dialogo.show(supportFragmentManager, null)
            }
        }

        return true
    }

    override fun onLogOutSelected() {
        finish()
    }

    override fun onFiltrarSelected(genero: String) {
        usersAdapter.filtrarLista(genero)
    }
}