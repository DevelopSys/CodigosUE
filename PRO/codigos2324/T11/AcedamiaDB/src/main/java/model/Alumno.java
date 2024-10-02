package model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {

    private int id;
    private String nombre, apellido, correo;
    private int telefono;

    public Alumno(String nombre, String apellido, String correo, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Alumno(String nombre, String apellido, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public void mostrarDatos(){
        System.out.println("id = " + id);
        System.out.println("nombre = " + nombre);
        System.out.println("apellido = " + apellido);
        System.out.println("correo = " + correo);
        System.out.println("telefono = " + telefono);
    }

    public void agregarAlumno(){} //?????
    public void agregarProfesor(){} // ??????
}
