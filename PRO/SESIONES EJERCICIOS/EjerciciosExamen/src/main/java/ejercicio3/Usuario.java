package ejercicio3;

public class Usuario {

    private String nombre, correo, pass;

    public Usuario() {
    }

    public Usuario(String nombre, String correo, String pass) {
        this.nombre = nombre;
        this.correo = correo;
        this.pass = pass;
    }

    public void mostrarDatos(){
        System.out.println("nombre = " + nombre);
        System.out.println("correo = " + correo);
        System.out.println("pass = " + pass);
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
