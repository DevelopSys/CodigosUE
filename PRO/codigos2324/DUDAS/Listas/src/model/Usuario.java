package model;

public class Usuario {

    private String nombre, apellido, dni, correo;
    private int telefono, edad;


    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String dni, String correo, int telefono, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.telefono = telefono;
        this.edad = edad;

    }

    public void mostarDatos(){
        System.out.println("Nombre; "+nombre);
        System.out.println("Apellido; "+apellido);
        System.out.println("DNI; "+dni);
        System.out.println("Telfono; "+telefono);
        System.out.println("Correo; "+correo);
        System.out.println("Edad; "+edad);
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
