package model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column (name = "nombre")
    private String nombre;
    @Column (name = "apellidos")
    private String apellido;
    @Column (name = "correo")
    private String correo;

    @Embedded
    private Direccion direccion_propia;
    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "poblacion", column = @Column(name = "poblacion_tutor")),
            @AttributeOverride(name = "provincia", column = @Column(name = "provincia_tutor")),
            @AttributeOverride(name = "calle", column = @Column(name = "calle_tutor")),
            @AttributeOverride(name = "numero", column = @Column(name = "numero_tutor"))})
    private Direccion direccion_tutor;

    public Alumno() {
    }


    public Alumno(String nombre, String apellido, String correo, Direccion direccion_propia, Direccion direccion_tutor) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion_propia = direccion_propia;
        this.direccion_tutor = direccion_tutor;
    }
    public Alumno(String nombre, String apellido, String correo, Direccion direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion_propia = direccion;
    }
    public Alumno(String nombre, String apellido, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Direccion getDireccion() {
        return direccion_propia;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion_propia = direccion;
    }


    public Direccion getDireccion_propia() {
        return direccion_propia;
    }

    public void setDireccion_propia(Direccion direccion_propia) {
        this.direccion_propia = direccion_propia;
    }

    public Direccion getDireccion_tutor() {
        return direccion_tutor;
    }

    public void setDireccion_tutor(Direccion direccion_tutor) {
        this.direccion_tutor = direccion_tutor;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", direccion_propia=" + direccion_propia +
                ", direccion_tutor=" + direccion_tutor +
                '}';
    }
}
