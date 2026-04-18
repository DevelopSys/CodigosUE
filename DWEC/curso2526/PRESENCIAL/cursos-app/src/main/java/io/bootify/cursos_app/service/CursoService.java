package io.bootify.cursos_app.service;

import io.bootify.cursos_app.domain.Curso;
import io.bootify.cursos_app.events.BeforeDeleteCurso;
import io.bootify.cursos_app.model.CursoDTO;
import io.bootify.cursos_app.repos.CursoRepository;
import io.bootify.cursos_app.util.CustomCollectors;
import io.bootify.cursos_app.util.NotFoundException;
import java.util.List;
import java.util.Map;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class CursoService {

    private final CursoRepository cursoRepository;
    private final ApplicationEventPublisher publisher;

    public CursoService(final CursoRepository cursoRepository,
            final ApplicationEventPublisher publisher) {
        this.cursoRepository = cursoRepository;
        this.publisher = publisher;
    }

    public List<CursoDTO> findAll() {
        final List<Curso> cursoes = cursoRepository.findAll(Sort.by("id"));
        return cursoes.stream()
                .map(curso -> mapToDTO(curso, new CursoDTO()))
                .toList();
    }

    public CursoDTO get(final Long id) {
        return cursoRepository.findById(id)
                .map(curso -> mapToDTO(curso, new CursoDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final CursoDTO cursoDTO) {
        final Curso curso = new Curso();
        mapToEntity(cursoDTO, curso);
        return cursoRepository.save(curso).getId();
    }

    public void update(final Long id, final CursoDTO cursoDTO) {
        final Curso curso = cursoRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(cursoDTO, curso);
        cursoRepository.save(curso);
    }

    public void delete(final Long id) {
        final Curso curso = cursoRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        publisher.publishEvent(new BeforeDeleteCurso(id));
        cursoRepository.delete(curso);
    }

    private CursoDTO mapToDTO(final Curso curso, final CursoDTO cursoDTO) {
        cursoDTO.setId(curso.getId());
        cursoDTO.setNombre(curso.getNombre());
        cursoDTO.setIdProfesor(curso.getIdProfesor());
        return cursoDTO;
    }

    private Curso mapToEntity(final CursoDTO cursoDTO, final Curso curso) {
        curso.setNombre(cursoDTO.getNombre());
        curso.setIdProfesor(cursoDTO.getIdProfesor());
        return curso;
    }

    public Map<Long, String> getCursoValues() {
        return cursoRepository.findAll(Sort.by("id"))
                .stream()
                .collect(CustomCollectors.toSortedMap(Curso::getId, Curso::getNombre));
    }

}
