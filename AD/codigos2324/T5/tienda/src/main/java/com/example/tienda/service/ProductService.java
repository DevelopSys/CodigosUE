package com.example.tienda.service;

import com.example.tienda.domain.Producto;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface ProductService {

    // todos los metodos que quiero acceder desde el controlador

    Set<Producto> getAllProductos();
    Set<Producto> getProductosFilter(String categoria);

    Producto addProducto(Producto producto);

}
