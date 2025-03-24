package com.example.hotelapi.services.implementation;

import com.example.hotelapi.model.Usuario;
import com.example.hotelapi.repository.UsuarioRepository;
import com.example.hotelapi.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImp implements UsuariosService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAllUser() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario addUser(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario getByEmail(String email) {
        return usuarioRepository.getByCorreo(email);
    }

    @Override
    public Usuario getLogin(String email, String pass) {
        return usuarioRepository.getByCorreoAndPass(email,pass);

    }
}
