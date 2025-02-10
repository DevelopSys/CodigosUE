package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "habitaciones")
public class Habitacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int numero;
    @Column
    private int planta;
    @Column
    private int capacidad;
    @OneToOne(mappedBy = "habitacion",cascade = CascadeType.ALL)
    private Trabajador trabajador;

    @OneToMany(mappedBy = "habitacion", cascade = CascadeType.ALL)
    private Set<Cliente> clientes;

    public Habitacion(int numero, int planta, int capacidad) {
        this.numero = numero;
        this.planta = planta;
        this.capacidad = capacidad;
    }
}
