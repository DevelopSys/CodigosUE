package model;

import java.io.Serializable;

public class Usuario implements Serializable {

    //Serializable -> permite que el objeto de tipo usuarios sea "partido" en trozos

    // serialVersionUID -> aporta un identificado unico para cada tipo de objeto
    private static final Long serialVersionUID = 123L;

    private String nombre, apellido, correo;

    public Usuario(String nombre, String apellido, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    public Usuario() {
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

    public void mostrarDatos(){
        System.out.println("nombre = " + nombre);
        System.out.println("apellido = " + apellido);
        System.out.println("correo = " + correo);
    }

    public String formatoExportar(){
        return getNombre()+","+getApellido()+","+getCorreo();
    }
}
