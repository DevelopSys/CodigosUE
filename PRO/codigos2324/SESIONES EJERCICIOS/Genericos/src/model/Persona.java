package model;

public final class Persona {

    private String nombre, dni;


    public Persona() {
    }

    public void mostrarDatos(){
        System.out.println("nombre = " + nombre);
        System.out.println("dni = " + dni);
    }

    public Persona(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
