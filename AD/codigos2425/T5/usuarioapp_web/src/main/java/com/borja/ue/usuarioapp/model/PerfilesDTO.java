package com.borja.ue.usuarioapp.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PerfilesDTO {

    private Long id;

    @Size(max = 255)
    private String nombre;

}
