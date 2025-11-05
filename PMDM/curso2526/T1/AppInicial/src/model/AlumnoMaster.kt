package model

// ademas de todo lo que tiene un alumno, tambien tiene numeroCreditos
class AlumnoMaster(id: Int, nombre: String, apellido: String, correo: String, var numeroCreditos: Int)
    : Alumno(id, nombre,apellido, correo){

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("numeroCreditos = ${numeroCreditos}")
    }

}