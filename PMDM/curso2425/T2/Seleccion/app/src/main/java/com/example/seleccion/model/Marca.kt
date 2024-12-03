package com.example.seleccion.model

class Marca (var titulo: String, var anio: Int,var imagen: Int){
    override fun toString(): String {
        return titulo + " "+ anio
    }
}