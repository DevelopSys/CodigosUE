package com.example.t3sqlite.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.t3sqlite.model.Contact
import com.example.t3sqlite.model.ContactDAO

@Database([Contact::class],[],1)
abstract class ContactDB: RoomDatabase() {

    abstract fun getContactDAO(): ContactDAO;

    companion object BuildDataBase {

        private var INSTANCIA: ContactDB? = null
        fun getInstance(context: Context): ContactDB{
            if (INSTANCIA==null){
                synchronized(ContactDB::class.java){
                    INSTANCIA = buildDatabase(context)
                }

            }
            return INSTANCIA!!
        }
        private fun buildDatabase(context: Context): ContactDB {
            return Room.databaseBuilder(context,ContactDB::class.java,"contact-db")
                .build()
        }
    }

}