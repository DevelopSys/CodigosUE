package com.example.hotelapi.repository;

import com.example.hotelapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // creamos los metodos que nosotros pensamos utilizar contra la base de datos
    Usuario getByCorreo(String mail);
    @Query("FROM Usuario u WHERE u.correo = :correo AND u.pass = :pass")
    Usuario getByCorreoAndPass(@Param("correo") String mail, @Param("pass") String pass);

}
