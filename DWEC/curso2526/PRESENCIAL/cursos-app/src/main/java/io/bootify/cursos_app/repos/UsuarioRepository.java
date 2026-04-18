package io.bootify.cursos_app.repos;

import io.bootify.cursos_app.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findFirstByIdCursoFKId(Long id);

    boolean existsByCorreoIgnoreCase(String correo);

    @Query("")
    List<Usuario> getUSuariosMetodoPropio();

}
