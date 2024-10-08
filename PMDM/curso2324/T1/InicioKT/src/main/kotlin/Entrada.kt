import model.Directivo
import model.Tranajador
import model.Usuario
import model.Votante

// class

// variable
// final - dinamicas // bloque - clase // refencia
// var nombre: tipo = valor -> mutuble
// val nombre: tipo = valor ->  no mutable

var sueldo: Int? = null;
var nombre = "Borja"
var edad: Int = 34
var correo: String? = null
val DNI = "123123A"
val trabajos: ArrayList<String> = ArrayList()
lateinit var puesto: String;

// funcion - metodos
// fun nombre(param1: Tipo, param2: Tipo):Tipo{}
// public static void main(String[]args){}
fun main() {
    var usuario: Usuario = Usuario("Borja", "Martin", "123A")
    var usuario1: Usuario = Usuario("Borja", "Martin", "123A", "qwewe@asdasd.com")
    var trabajador:Usuario = Tranajador("Borja", "Martin", "123A", 123,123)

    //trabajador.mostrarDatos()
    usuario.nombre = "asdasd"
    usuario.mostrarDatos()
    puesto = "profesor"
    println(puesto)
    //par(2)
    //println(division(5,2))
    //println(division())
    println(correo?.length ?: "No hay correo")
    sueldo = 15000
    var pagas= sueldo?.toDouble()?:10000 /14
}

fun division(x: Int, y: Int): Double {
    return x.toDouble()/y;
}
fun division(): Double {
    println("Introduce el primer operando")
    var x: Int  = readln().toInt()
    println("Introduce el segundo operando")
    var y: Int  = readLine()?.toInt() ?: 0
    return x.toDouble()/y;
}
fun par(x: Int): Unit {
    if (x % 2 == 0) {
        println("Numero evaluado ${x} par")
    }
}