package io.bootify.cursos_app.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProfesorDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String nombre;

    @NotNull
    @Size(max = 255)
    @ProfesorCorreoUnique
    private String correo;

    @ProfesorIdCursoFKUnique
    private Long idCursoFK;

}
