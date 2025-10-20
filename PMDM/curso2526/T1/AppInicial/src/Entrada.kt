// public static void main (String[] args){}
// fun nombre(argumentos):retorno{cuerpo}

fun main() {
    /*
    println("Primer programa en Kotlin")
    // complejos: Int, Double, Float, Boolean, Char, Byte
    // tipoMod nombre:Tipo = valor
    println("Por favor introduce tu nombre")
    var nombre = readln()
    println("Por favor introduce la edad")
    var edad = readln().toInt()
    println(nombre)
    val DNI = "123123123A"
    println("Introduce el correo")
    var correoE: String? = readlnOrNull()
    // mi nombre es Borja, tengo 12 años y mi dni es 123123
    println("Mi nombre es $nombre y tengo $edad años y mi dni es $DNI")
    println("Mi correo es: ${correoE?.length ?: "sin definir" }")
    */
    // paramatros posicionales
    // parametros nominales
    // saludar()
    // sumar(5, 8)
    alumnos()
}

fun alumnos() {
    val listaAlumnos: ArrayList<String  > =
        arrayListOf("Juan", "Mariaa", "Marta", "Carlos", "Borjaa")
    // alumno in 0..4
    /*for (alumno in listaAlumnos ){
        println(alumno)
    }*/
    // listaAlumnos.forEach {println(it)}
    /*
    * for(int item : lista){ i }
    * */
    /*
    listaAlumnos.forEachIndexed { index, item ->
        if (index % 2 != 0) {
            println("El elemento en posicion $index es $item")
        }
    }*/
    // elemento cuyo nombre es Borja
    // println("${listaAlumnos.find { it.equals("Mateo", true) } ?: "No encontrado"}")

    val listaFiltrada = listaAlumnos.filter {it.length>8 }
    if (listaFiltrada.size==0){
        println("Nadie cummple la condicion de busqueda ")
    }else {
        listaFiltrada.forEach { println(it) }
    }

}

fun saludar(nombre: String = "Maria", veces: Int = 8) {
    // for(int i=0;i<veces;i++){}
    for (item in 0..veces - 1) {
        println("Hola $nombre, te voy a saludar")
    }
}

val sumar = { op1: Int, op2: Int -> println("El resultado de la suma es ${op1 + op2}") }