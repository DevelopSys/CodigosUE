package io.bootify.cursos_app.repos;

import io.bootify.cursos_app.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

    Profesor findFirstByIdCursoFKId(Long id);

    boolean existsByCorreoIgnoreCase(String correo);

    boolean existsByIdCursoFKId(Long id);

}
