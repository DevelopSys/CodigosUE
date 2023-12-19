package com.example.proyectospringinicial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControladorInicial {


    @GetMapping("/peticion1")
    public String metodoEndPintUno(){
        return "Ejemplo de peticion 1";
    }

    @GetMapping("/peticion2")
    public String metodoEndPintDos(){
        return "Ejemplo de peticion 2";
    }

    @RequestMapping(value = "/peticion3",method = RequestMethod.POST )
    public String metodoPOST(){
        return "Ejemplo de retorno método POST";
    }
    @RequestMapping(value = "/peticion4",method = RequestMethod.GET )
    public String metodoParametros(@RequestParam(required = false,defaultValue = "sin parametro")String dato ){
        return "El parémtro pasado es "+dato;
    }

    @RequestMapping(value = "/peticion5",method = RequestMethod.GET )
    public String metodoBody(@RequestBody String dato ){

        // ejecugtar la insercio del parametro
        return "El parémtro pasado es "+dato;
    }
}
