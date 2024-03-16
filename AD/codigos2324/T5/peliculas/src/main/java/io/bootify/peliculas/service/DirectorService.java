package io.bootify.peliculas.service;

import io.bootify.peliculas.domain.Director;
import io.bootify.peliculas.domain.Pelicula;
import io.bootify.peliculas.model.DirectorDTO;
import io.bootify.peliculas.repos.DirectorRepository;
import io.bootify.peliculas.repos.PeliculaRepository;
import io.bootify.peliculas.util.NotFoundException;
import io.bootify.peliculas.util.ReferencedWarning;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class DirectorService {

    private final DirectorRepository directorRepository;
    private final PeliculaRepository peliculaRepository;

    public DirectorService(final DirectorRepository directorRepository,
            final PeliculaRepository peliculaRepository) {
        this.directorRepository = directorRepository;
        this.peliculaRepository = peliculaRepository;
    }

    public List<DirectorDTO> findAll() {
        final List<Director> directors = directorRepository.findAll(Sort.by("id"));
        return directors.stream()
                .map(director -> mapToDTO(director, new DirectorDTO()))
                .toList();
    }

    public DirectorDTO get(final Long id) {
        return directorRepository.findById(id)
                .map(director -> mapToDTO(director, new DirectorDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final DirectorDTO directorDTO) {
        final Director director = new Director();
        mapToEntity(directorDTO, director);
        return directorRepository.save(director).getId();
    }

    public void update(final Long id, final DirectorDTO directorDTO) {
        final Director director = directorRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(directorDTO, director);
        directorRepository.save(director);
    }

    public void delete(final Long id) {
        directorRepository.deleteById(id);
    }

    private DirectorDTO mapToDTO(final Director director, final DirectorDTO directorDTO) {
        directorDTO.setId(director.getId());
        directorDTO.setNombre(director.getNombre());
        return directorDTO;
    }

    private Director mapToEntity(final DirectorDTO directorDTO, final Director director) {
        director.setNombre(directorDTO.getNombre());
        return director;
    }

    public ReferencedWarning getReferencedWarning(final Long id) {
        final ReferencedWarning referencedWarning = new ReferencedWarning();
        final Director director = directorRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        final Pelicula idDirectPelicula = peliculaRepository.findFirstByIdDirect(director);
        if (idDirectPelicula != null) {
            referencedWarning.setKey("director.pelicula.idDirect.referenced");
            referencedWarning.addParam(idDirectPelicula.getId());
            return referencedWarning;
        }
        return null;
    }

}
