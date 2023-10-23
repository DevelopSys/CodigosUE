package model

open class Usuario(var nombre: String, var apellido: String, var dni: String) {

    // atributos nombre(o) apellido(o) dni(o) correo(?)
    var correo: String? = null
    var telefono: Int? = null

    init {
        // parte de codigo ejecutado siempre despues de un constructor
    }

    // constructores
    // primario --> base
    // secundarios --> base + adicional
    constructor(nombre: String, apellido: String, dni: String, correo: String) : this(nombre, apellido, dni) {
        this.correo = correo
    }

    constructor(nombre: String, apellido: String, dni: String, telefono: Int) : this(nombre, apellido, dni) {
        this.telefono = telefono
    }


    // metodos

    open fun mostrarDatos(): Unit {
        println("Los datos son: ")
        println("Nombre $nombre")
        println("Apellido $apellido")
        println("DNI $dni")
    }

    // getter-setter
}