package io.bootify.cursos_app.service;

import io.bootify.cursos_app.domain.Curso;
import io.bootify.cursos_app.domain.Usuario;
import io.bootify.cursos_app.events.BeforeDeleteCurso;
import io.bootify.cursos_app.model.UsuarioDTO;
import io.bootify.cursos_app.repos.CursoRepository;
import io.bootify.cursos_app.repos.UsuarioRepository;
import io.bootify.cursos_app.util.NotFoundException;
import io.bootify.cursos_app.util.ReferencedException;
import java.util.List;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    public UsuarioService(final UsuarioRepository usuarioRepository,
            final CursoRepository cursoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    public List<UsuarioDTO> findAll() {
        final List<Usuario> usuarios = usuarioRepository.findAll(Sort.by("id"));
        return usuarios.stream()
                .map(usuario -> mapToDTO(usuario, new UsuarioDTO()))
                .toList();
    }

    public UsuarioDTO get(final Long id) {
        return usuarioRepository.findById(id)
                .map(usuario -> mapToDTO(usuario, new UsuarioDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final UsuarioDTO usuarioDTO) {
        final Usuario usuario = new Usuario();
        mapToEntity(usuarioDTO, usuario);
        return usuarioRepository.save(usuario).getId();
    }

    public void update(final Long id, final UsuarioDTO usuarioDTO) {
        final Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(usuarioDTO, usuario);
        usuarioRepository.save(usuario);
    }

    public void delete(final Long id) {
        final Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        usuarioRepository.delete(usuario);
    }

    private UsuarioDTO mapToDTO(final Usuario usuario, final UsuarioDTO usuarioDTO) {
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setCorreo(usuario.getCorreo());
        usuarioDTO.setIdCursoFK(usuario.getIdCursoFK() == null ? null : usuario.getIdCursoFK().getId());
        return usuarioDTO;
    }

    private Usuario mapToEntity(final UsuarioDTO usuarioDTO, final Usuario usuario) {
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setCorreo(usuarioDTO.getCorreo());
        final Curso idCursoFK = usuarioDTO.getIdCursoFK() == null ? null : cursoRepository.findById(usuarioDTO.getIdCursoFK())
                .orElseThrow(() -> new NotFoundException("idCursoFK not found"));
        usuario.setIdCursoFK(idCursoFK);
        return usuario;
    }

    public boolean correoExists(final String correo) {
        return usuarioRepository.existsByCorreoIgnoreCase(correo);
    }

    @EventListener(BeforeDeleteCurso.class)
    public void on(final BeforeDeleteCurso event) {
        final ReferencedException referencedException = new ReferencedException();
        final Usuario idCursoFKUsuario = usuarioRepository.findFirstByIdCursoFKId(event.getId());
        if (idCursoFKUsuario != null) {
            referencedException.setKey("curso.usuario.idCursoFK.referenced");
            referencedException.addParam(idCursoFKUsuario.getId());
            throw referencedException;
        }
    }

}
