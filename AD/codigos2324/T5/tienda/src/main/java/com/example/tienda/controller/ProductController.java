package com.example.tienda.controller;

import com.example.tienda.domain.Producto;
import com.example.tienda.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class ProductController {

    @Autowired
    ProductService productoService;

    @RequestMapping("/")
    public String getIndex() {
        return "indice";
    }

    @RequestMapping("/productosURL")
    public String getProductosURL(Model model) {
        model.addAttribute("products", productoService.getAllProductos());
        return "productos";
    }

    @GetMapping("/error")
    public String getError() {
        return "Error en la pagina";
    }

    // agregar un producto

    // buscar todos los productos ResponseEntity<Producto>
    @RequestMapping("/productos")
    public ResponseEntity<Set<Producto>> getProductos() {
        return new ResponseEntity<>(productoService.getAllProductos(), HttpStatus.OK);
    }

    @RequestMapping("/productosAdd")
    public ResponseEntity<Producto> addProduct() {
        Producto producto = new Producto("Nombre", "Descripcion", "pantalones", 100.0f);
        return new ResponseEntity<>(productoService.addProducto(producto), HttpStatus.OK);
    }

    // buscar por categoria


}
