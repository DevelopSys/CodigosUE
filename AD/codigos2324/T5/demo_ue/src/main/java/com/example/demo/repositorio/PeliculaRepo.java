package com.example.demo.repositorio;


import com.example.demo.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PeliculaRepo extends JpaRepository<Pelicula,Long> {
	
	 @Query("SELECT p FROM Pelicula p WHERE p.director.idDirector=?1")
	 List<Pelicula> findByDirectorId(Long id);
	
	 List<Pelicula> findByDirectorIdDirector(Long idDirector);
	 
	 List<Pelicula> findByAnyo(Integer anyo);
}
