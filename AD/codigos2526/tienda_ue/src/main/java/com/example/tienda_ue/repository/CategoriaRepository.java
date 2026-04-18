package com.example.tienda_ue.repository;

import com.example.tienda_ue.model.Categoria;
import com.example.tienda_ue.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Optional<Categoria> findByNombre(String nombre);
}
