// class Entrada{ psvm(){// cuerpo}}
// fun nombre( nombreArgs: Tipo, nombreArgs: Tipo, nombreArgs: Tipo ): Retorno  { CUERPO }
fun main() {

    var especializado = UsuarioEspecializado("Borja","Martin",123)
    especializado.mostrarDatos()
    var usuario = Usuario("Borja","Martin")
    var usuario2 = Usuario("Borja","Martin", correo = "asd") // null
    var usuario3 = Usuario("Borja","Martin",1234)
    usuario.nombre = "Juan"
    usuario.correo; // null
    usuario2.correo // correo@gmail.com

    println("Primera app kotlin")
    println("Introduce tu nombre")

    // VARIABLES: VAR - VAL (final)
    // TIPO nombre: TIPO = valor
    var nombre = readln()
    println("Introduce tu edad")
    var edad: Int? = readln().toInt()
    edad = null
    var altura: Double = 1.70
    val experiencia = true;

    // NULL ES UN TIPO
    var apellido: String? = null // null
    // Nullpointerexception -> null safety
    println(apellido?.length ?: "No se encuentra el apellido")

    // existira con valor, pero no se cuando se inicia. Para utilizar
    // una variable de este tipo, tengo que iniciarla antes
    lateinit var correo: String
    correo = "borja@gmail.com"
    println(correo)

    // complejas -> Primera en Mayusculas en el tipo -> String, Date, ArrayList
    // simples -> Primera en minuscula en el tipo -> int, double, float, boolean
    // wrapper -> Integer, Double, Float, Boolean
    // sout("asdasdasd "+variable+" asdasdasdads "+variable+" sdasasd")
    // souf("asdasdasd %s asdasdasdads %s sdasasd",variable1, variable2)
    println(
        "Mi nombre es $nombre, mi apellido es ${apellido ?: "sin definir"} " +
                "y mido $altura"
    )

    // posicionales
    sumar(5, 10)
    // nominales
    sumar(operando2 = 10, operando1 = 50)
    // valores por defecto
    sumar(operando2 = 30) // 10 + 30
    sumar() // 10 + 9
    println("El resultado de doblar es ${doblar(operando = 7)}")
    println("El resultado de incrementar es ${incrementar(8)}")
    dividir(4,2)
}

// void -> Unit
fun sumar(operando1: Int = 10, operando2: Int = 9) {
    println("El resultado de la operacion es ${operando1 + operando2}")
}

// Object -> Any
fun doblar(operando: Int): Int {
    return operando * 2
}

fun incrementar(operando: Int?): Int {
    return operando?.inc() ?: 0
}

// funciones lambda -> funcion pero RESUMIDO
// val variable = { arg:Tipo, arg: Tipo -> cuerpo  }
val dividir = { operando1: Int, operando2: Int ->
    println("El resultado de la division es ${operando1 / operando2}")
}