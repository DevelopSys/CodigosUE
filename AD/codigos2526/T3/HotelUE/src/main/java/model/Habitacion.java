package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "habitaciones")
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int numero;
    private int capacidad;
    private int planta;

    public Habitacion(int numero, int capacidad, int planta) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.planta = planta;
    }
}
