package io.bootify.cursos_app.service;

import io.bootify.cursos_app.domain.Curso;
import io.bootify.cursos_app.domain.Profesor;
import io.bootify.cursos_app.events.BeforeDeleteCurso;
import io.bootify.cursos_app.model.ProfesorDTO;
import io.bootify.cursos_app.repos.CursoRepository;
import io.bootify.cursos_app.repos.ProfesorRepository;
import io.bootify.cursos_app.util.NotFoundException;
import io.bootify.cursos_app.util.ReferencedException;
import java.util.List;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ProfesorService {

    private final ProfesorRepository profesorRepository;
    private final CursoRepository cursoRepository;

    public ProfesorService(final ProfesorRepository profesorRepository,
            final CursoRepository cursoRepository) {
        this.profesorRepository = profesorRepository;
        this.cursoRepository = cursoRepository;
    }

    public List<ProfesorDTO> findAll() {
        final List<Profesor> profesors = profesorRepository.findAll(Sort.by("id"));
        return profesors.stream()
                .map(profesor -> mapToDTO(profesor, new ProfesorDTO()))
                .toList();
    }

    public ProfesorDTO get(final Long id) {
        return profesorRepository.findById(id)
                .map(profesor -> mapToDTO(profesor, new ProfesorDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final ProfesorDTO profesorDTO) {
        final Profesor profesor = new Profesor();
        mapToEntity(profesorDTO, profesor);
        return profesorRepository.save(profesor).getId();
    }

    public void update(final Long id, final ProfesorDTO profesorDTO) {
        final Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(profesorDTO, profesor);
        profesorRepository.save(profesor);
    }

    public void delete(final Long id) {
        final Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        profesorRepository.delete(profesor);
    }

    private ProfesorDTO mapToDTO(final Profesor profesor, final ProfesorDTO profesorDTO) {
        profesorDTO.setId(profesor.getId());
        profesorDTO.setNombre(profesor.getNombre());
        profesorDTO.setCorreo(profesor.getCorreo());
        profesorDTO.setIdCursoFK(profesor.getIdCursoFK() == null ? null : profesor.getIdCursoFK().getId());
        return profesorDTO;
    }

    private Profesor mapToEntity(final ProfesorDTO profesorDTO, final Profesor profesor) {
        profesor.setNombre(profesorDTO.getNombre());
        profesor.setCorreo(profesorDTO.getCorreo());
        final Curso idCursoFK = profesorDTO.getIdCursoFK() == null ? null : cursoRepository.findById(profesorDTO.getIdCursoFK())
                .orElseThrow(() -> new NotFoundException("idCursoFK not found"));
        profesor.setIdCursoFK(idCursoFK);
        return profesor;
    }

    public boolean correoExists(final String correo) {
        return profesorRepository.existsByCorreoIgnoreCase(correo);
    }

    public boolean idCursoFKExists(final Long id) {
        return profesorRepository.existsByIdCursoFKId(id);
    }

    @EventListener(BeforeDeleteCurso.class)
    public void on(final BeforeDeleteCurso event) {
        final ReferencedException referencedException = new ReferencedException();
        final Profesor idCursoFKProfesor = profesorRepository.findFirstByIdCursoFKId(event.getId());
        if (idCursoFKProfesor != null) {
            referencedException.setKey("curso.profesor.idCursoFK.referenced");
            referencedException.addParam(idCursoFKProfesor.getId());
            throw referencedException;
        }
    }

}
