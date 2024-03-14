package com.example.demo.controller;


import com.example.demo.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorInicial {

    @GetMapping("/ejemplo")
    public String metodoEjemplo(){
        Usuario usuario = new Usuario("Borja","Martin");
        return "Esto es un ejemplo de método que responde con datos "+usuario.getNombre();
    }

    @GetMapping("/datos")
    public String metodoDatos(){

        return "Este es otro ejemplo de endpoint llamado desde HTTP";
    }
}
