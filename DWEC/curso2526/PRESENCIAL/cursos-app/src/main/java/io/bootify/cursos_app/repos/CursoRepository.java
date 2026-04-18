package io.bootify.cursos_app.repos;

import io.bootify.cursos_app.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CursoRepository extends JpaRepository<Curso, Long> {
}
