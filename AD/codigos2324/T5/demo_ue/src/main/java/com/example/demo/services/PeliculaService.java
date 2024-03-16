package com.example.demo.services;


import com.example.demo.model.Pelicula;

import java.util.List;
import java.util.Optional;

public interface PeliculaService {
	
	public List<Pelicula> findAllPelicula();
	
	public Optional<Pelicula> findPeliculaById(Long id);
	
	public List<Pelicula> findPeliculaByAnyo(int anyo);
	
	public List<Pelicula> findPeliculaByDirectorId(Long id);
	
	public Pelicula savePelicula(Pelicula nuevoPelicula);
	
	public boolean deletePelicula(Long id);
	
	public Pelicula updatePelicula(Pelicula nuevaPelicula);
	
	

}
