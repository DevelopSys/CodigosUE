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
import com.example.agendajson.dialog.DialogAyudaSetItems
import com.example.agendajson.dialog.DialogAyudaSetMessage
import com.example.agendajson.dialog.DialogAyudaSetMultiChoiceItems
import com.example.agendajson.dialog.DialogAyudaSetSingleChoiceItems
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
        // 1 - Petición del tipo correcto
        realizarPeticionJSON()

    }

    private fun instancias() {
        adapter = UsuarioAdapter(this)
    }

    private fun initGUI() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Mi App"
        binding.recyclerUsuarios.adapter = adapter
        binding.recyclerUsuarios.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    private fun realizarPeticionJSON() {
        val url = "https://dummyjson.com/users"
        val request: JsonObjectRequest = JsonObjectRequest(
            url,
            {
                Log.v("conexión", "Conexión correcta. Procesando petición")
                procesarRespuesta(it)
            },
            {
                Log.v("conexión", "Error en la conexión con el servidor")
            }
        )
        // 2 - Añado la petición a la pila de Volley
        Volley.newRequestQueue(applicationContext).add(request)
    }

    private fun procesarRespuesta(param: JSONObject){

        val gson = Gson()
        val userArray: JSONArray = param.getJSONArray("users")

        for (i in 0 until userArray.length()){
            val userJSON: JSONObject = userArray.getJSONObject(i)
//            val nombre = userArray.getJSONObject(i).getString("firstName")
            val user = gson.fromJson(userJSON.toString(), User::class.java)
            adapter.addUser(user)
            Log.v("conexión", "El nombre es ${user.firstName} ${user.lastName}")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

            R.id.item_cerrar -> {
                finish()
            }
            R.id.item_ayuda_message -> {
                val dialog: DialogAyudaSetMessage = DialogAyudaSetMessage()
                dialog.show(supportFragmentManager, null)
            }
            R.id.item_ayuda_setItem -> {
                val dialog: DialogAyudaSetItems = DialogAyudaSetItems()
                dialog.show(supportFragmentManager, null)
            }
            R.id.item_ayuda_setSingleChoiceItem -> {
                val dialog: DialogAyudaSetSingleChoiceItems = DialogAyudaSetSingleChoiceItems()
                dialog.show(supportFragmentManager, null)
            }
            R.id.item_ayuda_setMultiChiceItem -> {
                val dialog: DialogAyudaSetMultiChoiceItems = DialogAyudaSetMultiChoiceItems()
                dialog.show(supportFragmentManager, null)
            }

        }
        return true
    }


}