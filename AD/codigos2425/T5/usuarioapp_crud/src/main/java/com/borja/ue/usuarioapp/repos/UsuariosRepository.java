package com.borja.ue.usuarioapp.repos;

import com.borja.ue.usuarioapp.domain.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {

    boolean existsByPassIgnoreCase(String pass);

}
