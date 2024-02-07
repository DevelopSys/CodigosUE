package model;

import jakarta.persistence.*;
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
@Table(name = "alumnos")

@NamedQueries({
        @NamedQuery(name = "alumno.getAll", query = "from Alumno a"),
        @NamedQuery(name = "alumno.getByName",
                query = "from Alumno a where a.nombre=:nombre"),
        @NamedQuery(name="AlumnosRepetidores", query="select a from Alumno a where a.repetidor=true "),
        @NamedQuery(name="AlumnosRangoEdad", query="select a from Alumno a where a.edad between :min and :max"),
        @NamedQuery(name="AlumnosDescEdad", query="select a from Alumno a order by a.edad desc")
})
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String correo;
    @Column
    private int telefono;
    @Embedded
    private Direccion direccion;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "localidad", column = @Column(name = "localidad_fact")),
            @AttributeOverride(name = "provincia", column = @Column(name = "provincia_fact"))
    })
    private Direccion direccionFacturacion;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    /*
    * @Column
    private String provincia;
    @Column
    private String localidad;
    * */


// private direccion Direccion

// session.persiste(new Alumno("Borja","Martin","correo@gmail.com",123123))
// INSERT into alumnos (name, surname,mail, phone) VALUES ('Borja'.'Martin','correo@gmail',123123)

    public Alumno(String nombre, String apellido, String correo, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Alumno(String nombre, String apellido, String correo, int telefono, Direccion direccion, Direccion direccionFacturacion, Curso curso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.direccionFacturacion = direccionFacturacion;
        this.curso = curso;
    }

    public Alumno(String nombre, String apellido, String correo, int telefono, Direccion direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Alumno(String nombre, String apellido, String correo, int telefono, Direccion direccion, Direccion direccionFacturacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.direccionFacturacion = direccionFacturacion;
    }
}
