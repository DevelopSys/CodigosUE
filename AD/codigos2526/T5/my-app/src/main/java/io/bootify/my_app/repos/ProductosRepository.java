package io.bootify.my_app.repos;

import io.bootify.my_app.domain.Productos;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductosRepository extends JpaRepository<Productos, Long> {
}
