package com.example.tienda.repository;

import com.example.tienda.domain.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

    // firma de los metodos o el acceso a todas las operaciones contra la base de datos
    Set<Producto> findAll();

    @Query("SELECT p FROM products p WHERE p.categoria = ?1")
    Set<Producto> getAllProductsCategory(String categoria);

}
