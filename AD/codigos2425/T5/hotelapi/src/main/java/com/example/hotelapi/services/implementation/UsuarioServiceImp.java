package com.example.hotelapi.services.implementation;

import com.example.hotelapi.model.Usuario;
import com.example.hotelapi.repository.UsuarioRepository;
import com.example.hotelapi.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImp implements UsuariosService {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAllUser() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario addUser(Usuario usuario) {

        usuario.setPass(encoder.encode(usuario.getPass()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario getByEmail(String email) {
        return usuarioRepository.getByCorreo(email);
    }

    @Override
    public Usuario getLogin(String email, String pass) {

        Usuario usuario = getByEmail(email);

        if (encoder.matches(pass, usuario.getPass())) {
            // return usuarioRepository.getByCorreoAndPass(email, pass);
            return usuario;
        }
        return null;

    }

    @Override
    public Usuario getUsuarioDetail(int id) {
        return usuarioRepository.getById(id);
    }
}
