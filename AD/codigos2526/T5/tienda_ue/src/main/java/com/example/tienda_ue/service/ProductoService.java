package com.example.tienda_ue.service;

import com.example.tienda_ue.model.Producto;
import com.example.tienda_ue.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@Transactional
public class ProductoService {

    // la logica para poder decir sobre las ejecuciones en la bd
    @Autowired
    private ProductoRepository productoRepository;

    @PostMapping("anadir")
    public void agregarProducto(Producto producto){
        // decide logicamente si puedeshacer una llamada al elemento
        // producto con stock negativo
        productoRepository.save(producto);
    }


}
