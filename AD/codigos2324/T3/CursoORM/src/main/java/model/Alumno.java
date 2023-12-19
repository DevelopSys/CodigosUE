package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

// POJO -> serializable, getter/setter, atributos private, constructor defauls
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

// entidad -> elemento que enBD representa una tupla de datos
@Entity
// tablas -> elemento que guardare en una tabla
@Table (name = "alumnos")
public class Alumno implements Serializable {

    @Id
    @Column
    private int id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String correo;
    @Column
    private int telefono;

    // private direccion Direccion

    // session.persiste(new Alumno("Borja","Martin","correo@gmail.com",123123))
    // INSERT into alumnos (name, surname,mail, phone) VALUES ('Borja'.'Martin','correo@gmail',123123)

    public Alumno(String nombre, String apellido, String correo, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }

}
