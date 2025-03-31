package com.example.hotelapi.services;


import com.example.hotelapi.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UsuariosService {

    List<Usuario> getAllUser();

    Usuario addUser(Usuario usuario);

    Usuario getByEmail(String email);

    Usuario getLogin(String email, String pass);

    Usuario getUsuarioDetail(int id);
}
