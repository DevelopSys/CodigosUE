package com.example.demo.controller;


import com.example.demo.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorInicial {

    @GetMapping("/ejemplo")
    public String metodoEjemplo() {
        Usuario usuario = new Usuario("Borja", "Martin");
        return "Esto es un ejemplo de método que responde con datos " + usuario.getNombre();
    }

    @GetMapping("/datos")
    public String metodoDatos() {
        return "Este es otro ejemplo de endpoint llamado desde HTTP";
    }

    // GET POR URL
    @GetMapping("/parametros")
    public String metodoParametros(@RequestParam String name, @RequestParam String surname) {
        Usuario usuario = new Usuario(name, surname);
        // utilizalo
        return String.format("Perfecto, acabas de realizar un saludo a %s %s", usuario.getNombre(), usuario.getApellido());

    }

    // POST POR URL
    @GetMapping("/parametrosPOST")
    public String metodoParametrosPost(@RequestBody String name, @RequestBody String surname) {
        Usuario usuario = new Usuario(name, surname);
        // utilizalo
        return String.format("Perfecto, acabas de realizar un saludo a %s %s", usuario.getNombre(), usuario.getApellido());
    }

    @GetMapping("/usuariojson")
    public ResponseEntity<Usuario> metodoJSON(@RequestParam String name, @RequestParam String surname) {

        if (name.length() == 1) {
            return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
        } else if (name.length() > 1) {
            return new ResponseEntity<>(new Usuario(name, surname), HttpStatus.OK);
        }

        return null;

    }


}
