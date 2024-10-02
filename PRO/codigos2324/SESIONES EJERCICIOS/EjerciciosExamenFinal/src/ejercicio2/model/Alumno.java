package ejercicio2.model;

public class Alumno {

    private String nombre, apellido, correo;
    private int nota;

    public Alumno() {
    }

    public Alumno(String nombre, String apellido, String correo, int nota) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
