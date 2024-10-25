open class Usuario(var nombre: String, var apellido: String) {

    // si o si se construye con nombre y apellido
    // algunos usuarios tienen correo
    // algunos usuarios tienen telefono
    // variables
    var correo: String? = null;
    var telefono: Int?= null;
    // constructores -> primario // secundarios (se basan en el primario)
    /*constructor(nombre: String, apellido: String, correo: String) : this(nombre, apellido) {
        this.correo = correo
    }
    constructor(nombre: String, apellido: String, telefono: Int?=null) : this(nombre, apellido) {
        this.telefono = telefono;
    }*/
    constructor(nombre: String, apellido: String, telefono: Int?=null, correo: String?=null):this(nombre, apellido){
       this.telefono = telefono;
       this.correo = correo;
    }
    // funciones

    open fun mostrarDatos(){
        println(nombre)
        println(apellido)
        println(correo)
        println(telefono)
    }
    fun getTelefono(): Int? {
        return telefono
    }
    fun setTelefono(telefono: Int?){
        this.telefono = telefono
    }
}