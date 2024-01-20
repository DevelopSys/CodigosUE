package com.example.trabajadores

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.AppBarConfiguration.Builder.build
import androidx.navigation.ui.NavigationUI.navigateUp
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.example.trabajadores.databinding.ActivityMain2Binding
import com.google.android.material.snackbar.Snackbar

class MainActivity2 : AppCompatActivity() {
    private var appBarConfiguration: AppBarConfiguration? = null
    private var binding: ActivityMain2Binding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding!!.root)
        setSupportActionBar(binding!!.toolbar)
        val navController = findNavController(this, R.id.nav_host_fragment_content_main)
        appBarConfiguration = Builder(navController.graph).build()
        setupActionBarWithNavController(this, navController, appBarConfiguration!!)
        binding!!.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAnchorView(R.id.fab)
                .setAction("Action", null).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(this, R.id.nav_host_fragment_content_main)
        return (navigateUp(navController, appBarConfiguration!!)
                || super.onSupportNavigateUp())
    }
}