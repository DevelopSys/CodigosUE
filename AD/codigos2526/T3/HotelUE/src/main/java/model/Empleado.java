package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NamedQuery;

// TODO. mucho cuidado con el toString
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "Empleado.findByLocalidad",query = "FROM Empleado e WHERE e.direccion.localidad=:localidadArgs")
@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    @Column(name = "correo", unique = true)
    private String mail;
    private int salario;
    @Embedded
    private Direccion direccion;
    @Transient
    private String categoria;
    // unidireccional
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;






    public Empleado(String nombre, String apellido, String mail, int salario, Direccion direccion, String categoria) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.salario = salario;
        this.direccion = direccion;
        this.categoria = categoria;
    }

    public void mostrarDatos(){
        System.out.println("id = " + id);
        System.out.println("nombre = " + nombre);
        System.out.println("apellido = " + apellido);
        System.out.println("mail = " + mail);
        System.out.println("salario = " + salario);
        System.out.println("direccion = " + direccion.getLocalidad());
    }
}
