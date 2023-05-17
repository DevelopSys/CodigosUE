package com.joange.reporitory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.joange.model.Director;

public interface DirectorRepo extends JpaRepository<Director,Long>{

	@Query("SELECT d FROM Director d WHERE d.anyoNacimiento<1970")
    List<Director> findOldDirector();

	List<Director> findDirectorByAnyoNacimiento(Integer anyoNacimiento);


    List<Director> findDirectorByAnyoNacimientoBetween(Integer ini, Integer end);


}
