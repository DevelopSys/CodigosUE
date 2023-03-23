package com.example.t3sqlite

enum class DatoEnum {

    Dato1("nombre",23), Dato2("nombre",23), Dato3("nombre",23), Dato4("nombre",23)

    var nombre: String? =null
    var edad: Int = 2;

    constructor(nombre: String, edad: Int){
        this.nombre = nombre;
        this.edad = edad
    }

    fun mostrarDatos(){}

}