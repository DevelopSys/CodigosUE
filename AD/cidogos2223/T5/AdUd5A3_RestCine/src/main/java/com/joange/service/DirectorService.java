package com.joange.service;

import java.util.List;
import java.util.Optional;
import com.joange.model.Director;

public interface DirectorService {

	public List<Director>findAllDirector();
	
	public Optional<Director> findDirectorById(Long id);
	
	public Director saveDirector(Director nuevoDirector);
	
	public String deleteDirector(Long id);
	
	public Director updateDirector(Director nuevoDirector);
	
	public List<Director>findOldDirector();
	
	public List<Director> findDirectorByYear(int year);
	
	public List<Director>findByYearBetween(int min,int max);
}
