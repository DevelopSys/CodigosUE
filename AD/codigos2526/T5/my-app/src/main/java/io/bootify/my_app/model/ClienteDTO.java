package io.bootify.my_app.model;

import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ClienteDTO {

    private Long id;

    @Size(max = 255)
    private String nombre;

    @Size(max = 255)
    @ClienteCorreoUnique
    private String correo;

    @Size(max = 255)
    private String telefono;

    private List<Long> productos;

}
