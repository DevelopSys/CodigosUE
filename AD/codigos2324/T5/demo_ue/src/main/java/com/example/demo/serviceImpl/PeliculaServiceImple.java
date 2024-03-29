package com.example.demo.serviceImpl;


import com.example.demo.model.Pelicula;
import com.example.demo.repositorio.PeliculaRepo;
import com.example.demo.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImple implements PeliculaService {
	
	@Autowired
	PeliculaRepo peliculaRepo;

	@Override
	public List<Pelicula> findAllPelicula() {
		return peliculaRepo.findAll();
	}

	@Override
	public Optional<Pelicula> findPeliculaById(Long id) {
		return peliculaRepo.findById(id);
	}

	@Override
	public Pelicula savePelicula(Pelicula nuevoPelicula) {
		return peliculaRepo.save(nuevoPelicula);
	}

	@Override
	public boolean deletePelicula(Long id) {
		Optional<Pelicula> p=peliculaRepo.findById(id);
		if(p.isPresent()) {
			peliculaRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Pelicula updatePelicula(Pelicula nuevaPelicula) {
		if (peliculaRepo.findById(nuevaPelicula.getIdPelicula()).isPresent()) { 
			return peliculaRepo.save(nuevaPelicula);
		}
		
			return null;
		
	}

	@Override
	public List<Pelicula> findPeliculaByAnyo(int anyo) {
		return peliculaRepo.findByAnyo(anyo);
	}

	@Override
	public List<Pelicula> findPeliculaByDirectorId(Long id) {

		
		// con consulta propia
		 //return peliculaRepo.findByDirectorId(id);
		
		// directamente
		 return peliculaRepo.findByDirectorIdDirector(id);
	}

}
