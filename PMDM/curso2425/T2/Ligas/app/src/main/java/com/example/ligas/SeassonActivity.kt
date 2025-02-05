package com.example.ligas

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.ligas.adapter.AdaptadorEquipo
import com.example.ligas.databinding.ActivitySeassonBinding
import com.example.ligas.model.Equipo
import com.example.ligas.model.LigaJSON
import com.google.gson.Gson

class SeassonActivity : AppCompatActivity() {
    private lateinit var liga: LigaJSON
    private lateinit var adapterEquipo: AdaptadorEquipo
    private lateinit var binding: ActivitySeassonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeassonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapterEquipo = AdaptadorEquipo(ArrayList(), this)
        binding.recyclerEquipos.adapter = adapterEquipo;
        binding.recyclerEquipos.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        liga = intent.getBundleExtra("datos")!!
            .getSerializable("liga") as LigaJSON
        liga.strLeague = liga.strLeague!!.replace(" ", "%20")
        val url =
            "https://www.thesportsdb.com/api/v1/json/3/search_all_teams.php?l=" + liga.strLeague

        val petecion = JsonObjectRequest(url, {
            val equipos = it.getJSONArray("teams")
            val gson = Gson()
            for (i in 0..equipos.length() - 1) {
                val equipoJSON = equipos.getJSONObject(i)
                val equipo = gson.fromJson(equipoJSON.toString(), Equipo::class.java)
                adapterEquipo.addEquipo(equipo)
            }
        }, {})
        Volley.newRequestQueue(applicationContext).add(petecion);


    }
}