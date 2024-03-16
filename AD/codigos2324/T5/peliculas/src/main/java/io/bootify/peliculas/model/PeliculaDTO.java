package io.bootify.peliculas.model;

import jakarta.validation.constraints.Size;


public class PeliculaDTO {

    private Long id;

    @Size(max = 255)
    private String titulo;

    @Size(max = 255)
    private String direscripcion;

    private Integer idDirector;

    private Long idDirect;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(final String titulo) {
        this.titulo = titulo;
    }

    public String getDirescripcion() {
        return direscripcion;
    }

    public void setDirescripcion(final String direscripcion) {
        this.direscripcion = direscripcion;
    }

    public Integer getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(final Integer idDirector) {
        this.idDirector = idDirector;
    }

    public Long getIdDirect() {
        return idDirect;
    }

    public void setIdDirect(final Long idDirect) {
        this.idDirect = idDirect;
    }

}
