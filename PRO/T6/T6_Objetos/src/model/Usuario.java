package model;

public class Usuario {

    // molde de lo que será un usuario -> manual de instrucciones
    // atributos -> caracteristicas que quiero manejar en el progarama (cualifican)
    // nombre, dni, perfil, altura, correo, telefono, carnet, direccion
    private String nombre, apellido, dni, correo, pass, nacionalidad;
    private int telefono;

    // todos los usuarios tengan una pass por defecto que es root1234

    // metodos -> funcionalidades que el objeto tiene
    // constructor -> contruir el objeto. Por defecto tengo el constructor vacio
    // siempre y cuando no tengas ninguna con parametros
    // public void nombreMetodo(param1, param2, param3){}
    /*public Usuario(){}
    public Usuario(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
    public Usuario(String nombre, String apellido,
                   String dni, String correo, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;
    }
    public Usuario(String nombre, String correo){
        this.nombre = nombre;
        this.correo = correo;
    }*/

    public Usuario() {
        this.pass = "root1234";
    }


    public Usuario(String nombre, String apellido, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.pass = "root1234";
    }


    public Usuario(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.pass = "root1234";
    }


    public Usuario(String nombre, String apellido, String dni, String correo, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.telefono = telefono;
        this.pass = "root1234";
    }

    public Usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
        this.pass = "root1234";
    }

    public void saludar(String mensaje){
        System.out.println("El usuario con nombre "+this.nombre+" te esta diciendo "+mensaje);
    }

    public void mostrarDatos(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Apellido: "+apellido);
        System.out.println("DNI: "+dni);
        System.out.println("Telefono: "+telefono);
        System.out.println("Correo: "+correo);
        System.out.println("Pass: "+pass);
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
