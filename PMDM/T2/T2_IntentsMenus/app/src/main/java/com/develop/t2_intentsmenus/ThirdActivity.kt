package com.develop.t2_intentsmenus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.develop.t2_intentsmenus.R
import java.util.ArrayList

class ThirdActivity : AppCompatActivity() {
    private val miVariable: String? = null
    private var listaCosas: ArrayList<String>? = null
    private var listaCosasFiltrada: ArrayList<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        listaCosasFiltrada = ArrayList()
        listaCosas = ArrayList()
        listaCosas!!.add("Uno")
        listaCosas!!.add("Dos")
        listaCosas!!.add("Tres")
        listaCosas!!.add("Cuatro")
        listaCosas!!.add("Cinco")
        listaCosas!!.add("Seis")
        listaCosas!!.add("Siete")
        for (item in listaCosas!!) {
            if (item.equals("cincop", ignoreCase = true)) {
                listaCosasFiltrada!!.add(item)
            }
        }



        listaCosasFiltrada = listaCosas!!.filter { it.equals("cinco",true)} as ArrayList<String>
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_op1 -> {}
            R.id.menu_op2 -> {}
            R.id.menu_op3 -> {}
            R.id.menu_op4 -> {}
        }
        return true
    }
}