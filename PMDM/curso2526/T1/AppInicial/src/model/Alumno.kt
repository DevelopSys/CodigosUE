package model

// constructores primarios: tiene todas las variables obligatorias para el objeto
open class Alumno (var id: Int=0, var nombre: String, var apellido: String){

    var correo: String? = null
    // constructores secundarios: aquellos constructores que SE BASAN EN EL PRIMARIO mas lo adicional
    constructor(id: Int, nombre: String, apellido: String, correo: String): this(id,nombre,apellido) {
        this.correo = correo;
    }

    open fun mostrarDatos(){
        println("id = ${id}")
        println("nombre = ${nombre}")
        println("apellido = ${apellido}")
        println("correo = ${correo ?: "sin correo"}")
        println("Tu correo tiene ${correo?.length ?: "0"}")
    }
}