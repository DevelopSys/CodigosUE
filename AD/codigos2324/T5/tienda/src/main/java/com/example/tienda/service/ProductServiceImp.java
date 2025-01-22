package com.example.tienda.service;

import com.example.tienda.domain.Producto;
import com.example.tienda.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductServiceImp implements ProductService {

    // la realidad de los metodos del servicio con el acceso a las operaciones que ofrece el respositorio

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Set<Producto> getAllProductos() {

        return productoRepository.findAll();
    }

    @Override
    public Set<Producto> getProductosFilter(String categoria) {
        return productoRepository.getAllProductsCategory(categoria);
    }

    @Override
    public Producto addProducto(Producto producto) {

        return productoRepository.save(producto);
    }
}
