package io.bootify.peliculas.repos;

import io.bootify.peliculas.domain.Director;
import io.bootify.peliculas.domain.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    Pelicula findFirstByIdDirect(Director director);

}
