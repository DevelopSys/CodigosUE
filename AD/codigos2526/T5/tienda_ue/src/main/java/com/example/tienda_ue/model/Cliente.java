package com.example.tienda_ue.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO cuidado con el toString y el hash
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
// Json ignore -> para ñas relaciones
public class Cliente {

    // DEFINE EL OBJECTO QUE SE MAPEARA SOBRE LA BASE DE DATOS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String correo;

    @Column
    private String nombre;

    @Column
    private int telefono;

    public Cliente(String correo, String nombre, int telefono) {
        this.correo = correo;
        this.nombre = nombre;
        this.telefono = telefono;
    }
}
