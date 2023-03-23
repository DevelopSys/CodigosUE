package com.example.t3sqlite

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.t3sqlite.database.ContactDB
import com.example.t3sqlite.databinding.ActivityMainBinding
import com.example.t3sqlite.model.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        DatoEnum.Dato1.nombre
        DatoEnum.Dato3.edad

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonGet.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                // 1. accedido a la base de datos ContactDB.BuildDataBase.getInstance(applicationContext)
                val baseDatos: ContactDB = ContactDB.BuildDataBase.getInstance(applicationContext)
                // 2. Accedo al dao  .getContactDAO()
                val contactDao = baseDatos.getContactDAO()
                // 3. utilizo metodo del dao insertContact(Contact(
                val listaContactos = contactDao.getContacts()
                listaContactos.forEach {

                    withContext(Dispatchers.Main){
                        // llevar datos al adaptador
                    }
                }



            }
        }

        binding.botonAdd.setOnClickListener {


            // ejecuciones
            GlobalScope.launch(Dispatchers.IO) {
                // 1. accedido a la base de datos ContactDB.BuildDataBase.getInstance(applicationContext)
                val baseDatos: ContactDB = ContactDB.BuildDataBase.getInstance(applicationContext)
                // 2. Accedo al dao  .getContactDAO()
                val contactDao = baseDatos.getContactDAO()
                // 3. utilizo metodo del dao insertContact(Contact(
                contactDao.insertContact(
                    Contact(
                        "Borja",
                        "trabajo",
                        123123,
                        "https://w7.pngwing.com/pngs/69/512/png-transparent-computer-icons-contact-monochrome-silhouette-internet-thumbnail.png"
                    )
                )

            }
        }

        // esto no se puede hacer


        // AsyncTask vs Corutinas (ejecuciones paralelas)
        // HILOS
        // MAIN --> grafica (repintar) y parte de eventos
        // IO --> entradas y salidas: escrituras en fichero o peticiones url o peticiones a bd

        /*ContactDB.BuildDataBase.getInstance(applicationContext)
            .getContactDAO()
            .insertContact(Contact("nasd","asd",123,"asd"))*/

    }
}