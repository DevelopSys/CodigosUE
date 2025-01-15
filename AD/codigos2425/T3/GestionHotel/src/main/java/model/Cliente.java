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
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private String correo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_habitacion")
    private Habitacion habitacion;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "reservas",
            joinColumns = @JoinColumn(name = "id_cliente"),
            inverseJoinColumns = @JoinColumn(name = "id_trabajador"))
    private List<Trabajador> listaTrabajadores;


    public Cliente(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }
}
