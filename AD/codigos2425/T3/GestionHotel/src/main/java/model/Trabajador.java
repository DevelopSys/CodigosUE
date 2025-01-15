package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries(
        {
                @NamedQuery(name = "Trabajador.findAll", query = "FROM Trabajador"),
                @NamedQuery(name = "Trabajador.findByLocalidad", query = "FROM Trabajador WHERE direccion.localidad = :localidad")
        }
)

@Entity
@Table(name = "trabajadores")
public class Trabajador implements Serializable {

    // private static long serialVersionUID = 1L;
    // pk en la base de datos
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_habitacion")
    private Habitacion habitacion;

    @ManyToMany(mappedBy = "listaTrabajadores")
    private List<Cliente> listaClientes;

    public Trabajador(int id) {
        this.id = id;
    }

    public Trabajador(String nombre, String apellido, String correo, int telefono, Direccion direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Trabajador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
