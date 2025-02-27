package com.example.hotelapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    // crear tantos metodos como peticiones quiere resolver
    // obtener datos de conexion correcta

    @GetMapping("/info")
    public String conexionCorrecta(){
        return "Conexion realizada correctamente";
    }

    @PostMapping("/add")
    public String agregarUsuarios(){
        return "Usuario agregado correctamente";
    }

    @GetMapping("/error")
    public String error(){
        return "Fallo en la consulta";
    }
}
