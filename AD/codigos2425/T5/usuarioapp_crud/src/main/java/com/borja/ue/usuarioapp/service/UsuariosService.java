package com.borja.ue.usuarioapp.service;

import com.borja.ue.usuarioapp.domain.Usuarios;
import com.borja.ue.usuarioapp.model.UsuariosDTO;
import com.borja.ue.usuarioapp.repos.UsuariosRepository;
import com.borja.ue.usuarioapp.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class UsuariosService {

    private final UsuariosRepository usuariosRepository;

    public UsuariosService(final UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    public List<UsuariosDTO> findAll() {
        final List<Usuarios> usuarioses = usuariosRepository.findAll(Sort.by("id"));
        return usuarioses.stream()
                .map(usuarios -> mapToDTO(usuarios, new UsuariosDTO()))
                .toList();
    }

    public UsuariosDTO get(final Integer id) {
        return usuariosRepository.findById(id)
                .map(usuarios -> mapToDTO(usuarios, new UsuariosDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Integer create(final UsuariosDTO usuariosDTO) {
        final Usuarios usuarios = new Usuarios();
        mapToEntity(usuariosDTO, usuarios);
        return usuariosRepository.save(usuarios).getId();
    }

    public void update(final Integer id, final UsuariosDTO usuariosDTO) {
        final Usuarios usuarios = usuariosRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(usuariosDTO, usuarios);
        usuariosRepository.save(usuarios);
    }

    public void delete(final Integer id) {
        usuariosRepository.deleteById(id);
    }

    private UsuariosDTO mapToDTO(final Usuarios usuarios, final UsuariosDTO usuariosDTO) {
        usuariosDTO.setId(usuarios.getId());
        usuariosDTO.setCorreo(usuarios.getCorreo());
        usuariosDTO.setPass(usuarios.getPass());
        return usuariosDTO;
    }

    private Usuarios mapToEntity(final UsuariosDTO usuariosDTO, final Usuarios usuarios) {
        usuarios.setCorreo(usuariosDTO.getCorreo());
        usuarios.setPass(usuariosDTO.getPass());
        return usuarios;
    }

    public boolean passExists(final String pass) {
        return usuariosRepository.existsByPassIgnoreCase(pass);
    }

}
