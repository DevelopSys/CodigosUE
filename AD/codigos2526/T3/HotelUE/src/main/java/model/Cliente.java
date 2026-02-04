package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// TODO cuidado con el toString -> en springboot es @JSONBack o @ JSONManager o @JSONIgnore
@Data // getter setter equal hash toString
@ToString(exclude = "empleados")
@EqualsAndHashCode(exclude = "empleados")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column(name = "email")
    private String correo;

    // relacion unidireccional
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "reservas"
            , joinColumns = @JoinColumn(name = "id_cliente")
            , inverseJoinColumns = @JoinColumn(name = "id_empleado"))
    private Set<Empleado> empleados = new HashSet<>();

    public Cliente(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    // Cliente c = new Cliente(1,"asdasdasd")
    // Empleado e = new Empleado()
    // c.addEmpleado(e)
    public void addEmpleado(Empleado empleado){
        this.empleados.add(empleado);
        empleado.getClientes().add(this);
    }

    public void mostrarDatos(){
        System.out.println("nombre = " + nombre);
        System.out.println("correo = " + correo);
        System.out.println("nEmpleados = " + empleados.size());
    }
}
