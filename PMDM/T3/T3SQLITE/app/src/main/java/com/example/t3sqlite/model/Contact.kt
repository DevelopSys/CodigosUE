package com.example.t3sqlite.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(var nombre: String, var descropcion: String, var telefono: Int, var imagen:String): java.io.Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Long =0
}