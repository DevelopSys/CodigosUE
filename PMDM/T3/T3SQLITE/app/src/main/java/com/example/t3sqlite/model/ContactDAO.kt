package com.example.t3sqlite.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDAO {

    @Query ("SELECT * FROM Contact WHERE nombre = :name")
    fun getContactByName(name: String): List<Contact>

    @Query ("SELECT * FROM Contact")
    fun getContacts(): List<Contact>

    @Query ("SELECT * FROM Contact WHERE telefono = :telefono")
    fun getContactByPhone(telefono: Int): Contact

    @Insert
    fun insertContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)

}