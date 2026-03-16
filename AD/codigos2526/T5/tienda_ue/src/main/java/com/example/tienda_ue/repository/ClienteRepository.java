package com.example.tienda_ue.repository;

import com.example.tienda_ue.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // TODOS LOS METODOS QUE VAN CONTRA BASE DE DATOS
    // las firmas solo de aquellos metodos que no son "por defecto"
}
