package com.example.demo.controller;


import com.example.demo.model.Pelicula;
import com.example.demo.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorInicial {

    @GetMapping(value = "")
    public String sayHello() {
        return "Bienvenido a la Api de Cine";
    }
    @GetMapping("/ejemplo")
    public String metodoEjemplo(){
        Usuario usuario = new Usuario("Borja","Martin");
        return "Esto es un ejemplo de método que responde con datos "+usuario.getNombre();
    }

    @GetMapping("/datos")
    public String metodoDatos(){

        return "Este es otro ejemplo de endpoint llamado desde HTTP";
    }

    @GetMapping("/parametros")
    public String saludo(@RequestParam(value = "name", defaultValue = "Borja") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/parametrosBody")
    public String saludoBody(@RequestBody String name, @RequestBody String surname) {
        return String.format("Hello %s %s! ", name, surname);
    }

    @GetMapping("/parametrosJSON")
    public ResponseEntity<Usuario> parametrosJSON(@RequestParam String name, @RequestParam String surname) {
        return new ResponseEntity<>(new Usuario(name, surname), HttpStatus.OK);
    }



}
