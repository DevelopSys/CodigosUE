package com.joange.service;

import java.util.List;
import java.util.Optional;
import com.joange.model.Pelicula;

public interface PeliculaService {
	
	public List<Pelicula>findAllPelicula();
	
	public Optional<Pelicula> findPeliculaById(Long id);
	
	public List<Pelicula> findPeliculaByAnyo(int anyo);
	
	public List<Pelicula> findPeliculaByDirectorId(Long id);
	
	public Pelicula savePelicula(Pelicula nuevoPelicula);
	
	public boolean deletePelicula(Long id);
	
	public Pelicula updatePelicula(Pelicula nuevaPelicula);
	
	

}
