package com.example.tienda_ue.controller;

import com.example.tienda_ue.model.Categoria;
import com.example.tienda_ue.model.Producto;
import com.example.tienda_ue.service.CategoriaService;
import com.example.tienda_ue.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/categoria")
// TODO CORS
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("getAll/")
    public ResponseEntity<?> getAllCategorias() {

        List<Categoria> lista = categoriaService.getAll();
        Map<String, Object> response = new HashMap<>();
        response.put("code", 1);
        response.put("data", lista);
        response.put("size", lista.size());

        return ResponseEntity.status(200).body(response);

    }

    @GetMapping("getProducts/{name}")
    public ResponseEntity<?> getAllProductsByCategorias(@PathVariable String name) {

        Categoria categoria = categoriaService.getByName(name).get();
        Map<String, Object> response = new HashMap<>();
        response.put("code", 1);
        response.put("data", categoria.getProductos());
        response.put("size", categoria.getProductos().size());

        return ResponseEntity.status(200).body(response);

    }

}
