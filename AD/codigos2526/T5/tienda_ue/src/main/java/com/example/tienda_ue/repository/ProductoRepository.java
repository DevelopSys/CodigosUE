package com.example.tienda_ue.repository;

import com.example.tienda_ue.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
