package com.example.ligas

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Grid
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.ligas.adapter.LigasAdapter
import com.example.ligas.databinding.ActivityMainBinding
import com.example.ligas.model.Liga
import com.example.ligas.model.LigaJSON
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import org.json.JSONArray

class MainActivity : AppCompatActivity(), LigasAdapter.OnLigaListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: LigasAdapter;
    private lateinit var listaLigas: ArrayList<LigaJSON>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias();

        val peticion: JsonObjectRequest =
            JsonObjectRequest("https://www.thesportsdb.com/api/v1/json/3/all_leagues.php", {

                val array: JSONArray = it.getJSONArray("leagues")
                val gson = Gson()
                for (i in 0..array.length() - 1) {
                    val leagueJSON = array.getJSONObject(i)
                    val league = gson.fromJson(leagueJSON.toString(), LigaJSON::class.java)
                    if (league.strSport.equals("Soccer")) {
                        adapter.addLeague(league)
                    }
                    // objeto json -> objeto kotlin GSON
                    // cargar en el recyclerview todas las ligas de soccer
                    // Log.v("datos", league.getString("strLeague"))
                }
            }, { Log.v("datos", it.toString()) })
        Volley.newRequestQueue(applicationContext).add(peticion)

    }

    private fun instancias() {

        setSupportActionBar(binding.toolbar)
        /*listaLigas = arrayListOf(
            Liga("BBVA", R.drawable.liga, 90),
            Liga("Bundesliga", R.drawable.icono, 85),
            Liga("Calcio", R.drawable.icono, 70),
            Liga("Premier", R.drawable.premier, 95),
            Liga("Ligue1", R.drawable.icono, 60),
            Liga("Eridivise", R.drawable.icono, 50),
            Liga("SerieB", R.drawable.icono, 40),
            Liga("Liga Santander", R.drawable.icono, 87),
        )*/
        listaLigas = ArrayList()
        adapter = LigasAdapter(listaLigas, this)

        binding.recyclerLigas.adapter = adapter;
        if (resources.configuration.orientation == 1) {
            binding.recyclerLigas.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        } else if (resources.configuration.orientation == 2) {
            binding.recyclerLigas.layoutManager =
                GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        }


        //LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


    }

    override fun onLigaSelected(liga: Liga) {
        Snackbar.make(
            binding.root, "Liga comunicada con existo ${liga.nombre}", Snackbar.LENGTH_SHORT
        ).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // que item se ha pulsado
        when (item.itemId) {
            R.id.menuInfo -> {
                val listaSeleccion: ArrayList<CharSequence> = ArrayList()
                val lista = arrayOf("Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4")
                val builder: AlertDialog.Builder = AlertDialog.Builder(this)
                builder.setTitle("Dialogo info")
                // builder.setMessage("Esta app ha sido realizada por Borja Martin")
                // builder.setItems(lista, DialogInterface.OnClickListener { dialogInterface, i ->  })
                // builder.setSingleChoiceItems(lista,-1, DialogInterface.OnClickListener { dialogInterface, i ->  })
                builder.setMultiChoiceItems(lista, null,
                    DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, b ->
                        if (b) {
                            listaSeleccion.add(lista[i])
                        } else {
                            listaSeleccion.remove(lista[i])
                        }
                    })
                builder.setPositiveButton("OK") { _, _ ->
                    Log.v(
                        "lista",
                        listaSeleccion.toString()
                    )
                }
                builder.setNegativeButton("NO") { _, _ -> }
                builder.setNeutralButton("Quizá") { _, _ -> }
                val dialogo: AlertDialog = builder.create()
                dialogo.show();

            }

            R.id.menuSalir -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}