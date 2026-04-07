package com.example.tienda_ue.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonBackReference("cliente-producto")
    @JoinTable(name = "carrito",
            joinColumns = {@JoinColumn(name = "id_cliente")},
            inverseJoinColumns = {@JoinColumn(name = "id_producto")})
    private Set<Producto> productos;


    public Cliente(String correo, String nombre, int telefono) {
        this.correo = correo;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public void addProduto(Producto producto){
        productos.add(producto);
        producto.getClientes().add(this);
    }
}
