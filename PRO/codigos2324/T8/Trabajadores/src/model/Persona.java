package model;

public abstract class Persona {
    private String dni, nombre, correo;

    public Persona(String dni, String nombre, String correo) {
        this.dni = dni;
        this.nombre = nombre;
        this.correo = correo;
    }

    public Persona() {
    }

    public void mostrarDatos(){
        System.out.println("dni = " + dni);
        System.out.println("nombre = " + nombre);
        System.out.println("correo = " + correo);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
