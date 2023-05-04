package com.example.proyectospringinicial.serviceimp;

import com.example.proyectospringinicial.model.Pelicula;
import com.example.proyectospringinicial.repository.PeliculasRepo;
import com.example.proyectospringinicial.service.PeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculasServiceImp implements PeliculasService {

    @Autowired
    PeliculasRepo peliculasRepo;

    @Override
    public List<Pelicula> getAllPeliculas() {

        return peliculasRepo.findAll();
    }

    @Override
    public Pelicula addPelicula(Pelicula pelicula) {
        return null;
    }
}
