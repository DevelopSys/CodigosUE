package com.example.demo.serviceImpl;

import com.example.demo.model.Director;
import com.example.demo.repositorio.DirectorRepo;
import com.example.demo.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorServiceImple implements DirectorService {
	
	@Autowired
	DirectorRepo directorRepositorio;

	@Override
	public List<Director>findAllDirector() {

		return directorRepositorio.findAll();
	}

	@Override
	public Optional<Director> findDirectorById(Long id) {
		return directorRepositorio.findById(id);
	}
	@Override
	public Director saveDirector(Director nuevoDirector) {
		if (nuevoDirector!=null) {
			return directorRepositorio.save(nuevoDirector);
		}
		return null;
	}

	@Override
	public String deleteDirector(Long id) {
		Optional<Director> d=directorRepositorio.findById(id);
		if(d.isPresent()) {
			directorRepositorio.deleteById(id);
			return "Director eliminado satisfactoriamente";
		}
		return "El director no existe";
	}

	@Override
	public Director updateDirector(Director directorActualizar) {		
		if( directorRepositorio.findById(directorActualizar.getIdDirector()).isPresent()) { // si existe
			directorRepositorio.save(directorActualizar);
			return directorActualizar;
		}
		return null;		
	}
	
	@Override
	public List<Director>findOldDirector(){

		return directorRepositorio.findOldDirector();
	}
	
	@Override
	public List<Director> findDirectorByYear(int year){
		return directorRepositorio.findDirectorByAnyoNacimiento(year);
	}

	@Override
	public List<Director> findByYearBetween(int min,int max) {
		return directorRepositorio.findDirectorByAnyoNacimientoBetween(min, max);
	}
	
		

}
