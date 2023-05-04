package com.example.proyectospringinicial.service;

import com.example.proyectospringinicial.model.Pelicula;

import java.util.List;

public interface PeliculasService {

    public List<Pelicula> getAllPeliculas();
    public Pelicula addPelicula(Pelicula pelicula);
}
