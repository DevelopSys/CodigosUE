package com.example.proyectospringinicial.repository;

import com.example.proyectospringinicial.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PeliculasRepo extends JpaRepository<Pelicula, Integer> {

}
