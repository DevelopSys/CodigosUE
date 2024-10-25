import java.io.Serializable

// extends -> Clases
// implements -> Interfaces
class UsuarioEspecializado(nombre: String, apellido: String, var nSS: Int) : Usuario(nombre, apellido),Serializable {
    // nombre
    // apellido
    // correo -> null
    // telefono -> null

    override fun mostrarDatos() {
        super.mostrarDatos()
        println(nSS)
    }

}