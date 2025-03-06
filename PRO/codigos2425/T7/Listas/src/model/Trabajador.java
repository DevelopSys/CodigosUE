package model;

abstract public class Trabajador {

    private String nombre, apellido, correo, dni;
    private int telefono;

    public Trabajador() {
    }

    public Trabajador(String nombre, String apellido, String correo, String dni, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.dni = dni;
        this.telefono = telefono;
    }

    abstract public void calcularSalario();

    public void mostrarDatos(){
        System.out.println("nombre = " + nombre);
        System.out.println("apellido = " + apellido);
        System.out.println("correo = " + correo);
        System.out.println("dni = " + dni);
        System.out.println("telefono = " + telefono);
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
