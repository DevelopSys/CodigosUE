package io.bootify.peliculas.model;

import jakarta.validation.constraints.Size;


public class DirectorDTO {

    private Long id;

    @Size(max = 255)
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

}
