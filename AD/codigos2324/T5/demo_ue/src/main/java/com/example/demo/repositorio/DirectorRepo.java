package com.example.demo.repositorio;


import com.example.demo.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DirectorRepo extends JpaRepository<Director,Long> {

	@Query("SELECT d FROM Director d WHERE d.anyoNacimiento<1970")
    List<Director> findOldDirector();

	List<Director> findDirectorByAnyoNacimiento(Integer anyoNacimiento);


    List<Director> findDirectorByAnyoNacimientoBetween(Integer ini, Integer end);


}
