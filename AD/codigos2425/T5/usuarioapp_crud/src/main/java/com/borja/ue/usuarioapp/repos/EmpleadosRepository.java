package com.borja.ue.usuarioapp.repos;

import com.borja.ue.usuarioapp.domain.Empleados;
import com.borja.ue.usuarioapp.domain.Perfiles;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpleadosRepository extends JpaRepository<Empleados, Long> {

    Empleados findFirstByIdPerfil(Perfiles perfiles);

    boolean existsByIdPerfilId(Long id);

}
