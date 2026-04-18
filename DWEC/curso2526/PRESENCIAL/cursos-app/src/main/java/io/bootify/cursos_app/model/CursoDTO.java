package io.bootify.cursos_app.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CursoDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String nombre;

    private Long idProfesor;

}
