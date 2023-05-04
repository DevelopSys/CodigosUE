package com.example.proyectospringinicial.controller;

import com.example.proyectospringinicial.service.PeliculasService;
import com.example.proyectospringinicial.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PeliculaController {

    @Autowired
    private PeliculasService peliculasService;

    @GetMapping(value = "/peliculas")
    public List<Pelicula> getPeliculas(){
        return peliculasService.getAllPeliculas();
    }

}
