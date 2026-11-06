// main
// class -> metodo
// public static void main(String[] args){  } Entrada.main()
// fun nombre (param: Tipo):retorno {  }
fun main() {

    // variables: mutables var/ no mutables val
    // var o val nombre: Tipo = valor
    var nombre: String = "Borja" // string
    var apellido: String = "Martin" // string
    val edad: Int = 42 // int a = 42; a.
    var altura: Double = 1.72
    var acierto: Boolean = true
    // null safety
    var correo: String? = "null" // null
    lateinit var direccion: String
    // mi nombre es borja y mi apellido es martin
    // println("mi nombre es "+nombre+" y mi apellido es "+apellido)
    // println("mi nombre es $nombre y mi apellido es $apellido, y mi nombre tiene ${nombre.length} letras")
    // println("Mi correo es ${correo?.length ?: "vacio" }")
    // println(direccion)
    println("Introduce tu nombre")
    var nombreSaludo: String = readln()
    println("cuantas veces vas a saludar")
    var veces: Int = readln().toInt() // String.valueOf Integer.parsetInt("5")
    saludar(nombreSaludo, veces) // uso de parametros posicional
    // saludar(nombreSaludo) // uso de parametros posicional
    // saludar() // uso de parametros posicional
    // saludar(veces=7) // uso de parametros nominales
    // saludar(nombre=nombreSaludo) // uso de parametros nominales
    // saludar(veces=veces) // uso de parametros nominales
    /*println("Opcion 1")
    println("Opcion 2")
    println("Opcion 3")
    println("Opcion 4")
    val opcion  = readln().toInt()
    when(opcion){
        1->{}
        2->{}
        3->{}
        4->{}
    }*/
}

fun saludar(nombre: String = "Anonimo", veces: Int = 1): Unit {
    // nombre -> "Borja
    // veces -> cuantas
    // if while dowhile for foreach when
    // for (int i=0;i<10;i+=2){}
    // for (int i=10;i>=0;i--){}
    // 0........8
    /*for (i in 0 until veces step 2) {
        println("Enhorabuena $nombre has completado el programa")
    }
    for (int i : numeros) {
        println("Enhorabuena $nombre has completado el programa")
    }
    */
    /*for (i in veces-1 downTo 0){
        println("Enhorabuena $nombre has completado el programa")
    }*/
    // [0..4]
    (0 until veces).forEach { println("Enhorabuena $nombre has completado el programa") }
    /*
     val resultado = when(veces){
        1 -> {1}
        2 -> {2}
        in 3..10 -> {5}
        else -> {10}
    }*/
}