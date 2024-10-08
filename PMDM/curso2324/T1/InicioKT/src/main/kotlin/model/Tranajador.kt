package model

class Tranajador(nombre: String, apellido: String, dni: String, telefono: Int, var salario: Int) :
    Usuario(nombre, apellido, dni, telefono), Votante {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Salario: $salario")
    }

    fun metodoTrabajador(): Unit {
        
    }
    
    override fun votar(): Int {
        return (1..100).first
    }
}