package com.example.agendajson

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.agendajson.adapter.UsuarioAdapter
import com.example.agendajson.databinding.ActivityMainBinding
import com.example.agendajson.dialog.DialogAyuda
import com.example.agendajson.model.User
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UsuarioAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        initGUI()
        // 1 - Peticion del tipo correcto
        realizarPeticionJSON()


    }

    private fun instancias() {
        adapter = UsuarioAdapter(this)
    }

    private fun initGUI() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "MiAPP"
        binding.recyclerUsuarios.adapter = adapter
        binding.recyclerUsuarios.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter.notifyDataSetChanged()
    }

    private fun realizarPeticionJSON() {
        val url = "https://dummyjson.com/users"
        val request: JsonObjectRequest = JsonObjectRequest(url, {
            Log.v("conexion", "Conexion correcta, procesando peticion")
            procesarRepuesta(it)
        }, {
            Log.v("conexion", "Error en la conexion con el servidor")
        })
        // 2 - Añado la peticio a la pila de Volley
        Volley.newRequestQueue(applicationContext).add(request)
    }

    private fun procesarRepuesta(param: JSONObject) {
        val gson = Gson()
        val userArray: JSONArray = param.getJSONArray("users")
        for (i in 0..userArray.length() - 1) {
            val userJSON: JSONObject = userArray.getJSONObject(i)
            val user: User = gson.fromJson(userJSON.toString(), User::class.java)
            adapter.addUser(user)
            // Log.v("conexion", "El nombre de usuario es ${user.firstName} ${user.lastName}")
            // pintar un RecyclerView con los usuarios que me vienen del JSON
            // donde cada carta (fila) tiene el nombre, la imagen y el correo
            // RecyclerView -> xml
            // XML del aspecto de cada fila
            // Logica donde se ubica cada fila -> adapter + viewholder
            // hay que agregar un metodo de añadir usuario
            // cada vez que se lee del JSON, se añade al adapter
            // en este metodo hay que notificar los cambios (notifyDataSetChanged o Inserted)
            // recycler layout manager -> Linear / Grid / Staggered

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.item_cerrar -> {
                finish()
            }
            R.id.item_ayuda -> {
                val dialogo: DialogAyuda = DialogAyuda()
                dialogo.show(supportFragmentManager,null)
            }
        }

        return true
    }


}