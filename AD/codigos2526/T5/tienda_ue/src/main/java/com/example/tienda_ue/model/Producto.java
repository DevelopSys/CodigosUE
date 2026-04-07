package com.example.tienda_ue.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private double precio;

    @Column
    private String descripcion;

    @Column
    private int stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    @JsonBackReference("producto-categoria")
    private Categoria categoria;

    @ManyToMany (mappedBy = "productos")
    @JsonManagedReference("cliente-producto")
    private Set<Cliente> clientes;

    public Producto(String nombre, double precio, String descripcion, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
    }
}
