package io.bootify.peliculas.service;

import io.bootify.peliculas.domain.Director;
import io.bootify.peliculas.domain.Pelicula;
import io.bootify.peliculas.model.PeliculaDTO;
import io.bootify.peliculas.repos.DirectorRepository;
import io.bootify.peliculas.repos.PeliculaRepository;
import io.bootify.peliculas.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class PeliculaService {

    private final PeliculaRepository peliculaRepository;
    private final DirectorRepository directorRepository;

    public PeliculaService(final PeliculaRepository peliculaRepository,
            final DirectorRepository directorRepository) {
        this.peliculaRepository = peliculaRepository;
        this.directorRepository = directorRepository;
    }

    public List<PeliculaDTO> findAll() {
        final List<Pelicula> peliculas = peliculaRepository.findAll(Sort.by("id"));
        return peliculas.stream()
                .map(pelicula -> mapToDTO(pelicula, new PeliculaDTO()))
                .toList();
    }

    public PeliculaDTO get(final Long id) {
        return peliculaRepository.findById(id)
                .map(pelicula -> mapToDTO(pelicula, new PeliculaDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final PeliculaDTO peliculaDTO) {
        final Pelicula pelicula = new Pelicula();
        mapToEntity(peliculaDTO, pelicula);
        return peliculaRepository.save(pelicula).getId();
    }

    public void update(final Long id, final PeliculaDTO peliculaDTO) {
        final Pelicula pelicula = peliculaRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(peliculaDTO, pelicula);
        peliculaRepository.save(pelicula);
    }

    public void delete(final Long id) {
        peliculaRepository.deleteById(id);
    }

    private PeliculaDTO mapToDTO(final Pelicula pelicula, final PeliculaDTO peliculaDTO) {
        peliculaDTO.setId(pelicula.getId());
        peliculaDTO.setTitulo(pelicula.getTitulo());
        peliculaDTO.setDirescripcion(pelicula.getDirescripcion());
        peliculaDTO.setIdDirector(pelicula.getIdDirector());
        peliculaDTO.setIdDirect(pelicula.getIdDirect() == null ? null : pelicula.getIdDirect().getId());
        return peliculaDTO;
    }

    private Pelicula mapToEntity(final PeliculaDTO peliculaDTO, final Pelicula pelicula) {
        pelicula.setTitulo(peliculaDTO.getTitulo());
        pelicula.setDirescripcion(peliculaDTO.getDirescripcion());
        pelicula.setIdDirector(peliculaDTO.getIdDirector());
        final Director idDirect = peliculaDTO.getIdDirect() == null ? null : directorRepository.findById(peliculaDTO.getIdDirect())
                .orElseThrow(() -> new NotFoundException("idDirect not found"));
        pelicula.setIdDirect(idDirect);
        return pelicula;
    }

}
