package com.develop.t2_intentsmenus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.develop.t2_intentsmenus.databinding.ActivityMainBinding
import com.google.android.material.progressindicator.BaseProgressIndicator
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // menu es nulo  --> no se ejecuta nada
        menuInflater.inflate(R.menu.menu_principal,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // MAINACTIVITY
        // MAINACTIVITY SECONDACTIVITY
        // MAINACTIVITY

        when(item.itemId){
            R.id.menu_op1->{
                // Intent --> Intent(origen, destino (clase))
                // startActivity(intent)
                val intent: Intent = Intent(applicationContext,SecondActivity::class.java)
                startActivity(intent)
            }
            R.id.menu_op2->{

                val intent: Intent = Intent(applicationContext,SecondActivity::class.java)
                // bundle -> Caja
                val bundle: Bundle = Bundle()
                // meto cosas en la caja
                bundle.putString("nombre","Borja")
                bundle.putInt("edad",38)
                bundle.putBoolean("experiencia",true)
                intent.putExtras(bundle)
                startActivity(intent)

            }
            R.id.menu_op3->{
                Snackbar.make(binding.root, "Pulsado elemento 3", Snackbar.LENGTH_SHORT).show()
            }
            R.id.menu_op4->{
                Snackbar.make(binding.root, "Pulsado elemento 4", Snackbar.LENGTH_SHORT).show()
            }
            R.id.sumenu_op1->{
                Snackbar.make(binding.root, "Pulsado elemento submenu5", Snackbar.LENGTH_SHORT).show()
            }
        }


        return true
    }
}