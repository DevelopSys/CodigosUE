package com.borja.ue.usuarioapp.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UsuariosDTO {

    private Integer id;

    @Size(max = 255)
    private String correo;

    @Size(max = 255)
    @UsuariosPassUnique
    private String pass;

}
