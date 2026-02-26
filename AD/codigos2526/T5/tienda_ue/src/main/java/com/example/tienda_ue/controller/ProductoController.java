package com.example.tienda_ue.controller;

import com.example.tienda_ue.model.Producto;
import com.example.tienda_ue.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/productos")
// TODO CORS
public class ProductoController {

    // admite las peticione entrantes desde http
        // extre los datos, indica que parte del servio ejecuta
    @Autowired
    private ProductoService productoService;

    @PostMapping("anadir/")
    public void agregarProducto(@RequestBody Producto producto){
        productoService.agregarProducto(producto);
    }

}
