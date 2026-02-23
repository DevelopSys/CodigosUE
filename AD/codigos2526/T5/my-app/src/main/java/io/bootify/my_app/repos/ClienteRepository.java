package io.bootify.my_app.repos;

import io.bootify.my_app.domain.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findAllByProductosId(Long id);

    boolean existsByCorreoIgnoreCase(String correo);

}
