package com.example.tienda.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private String categoria;
    @Column
    private float precio;

    public Producto(String nombre, String descripcion, String categoria, float precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
    }
}
