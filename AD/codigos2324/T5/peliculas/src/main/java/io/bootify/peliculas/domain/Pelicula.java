package io.bootify.peliculas.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Pelicula {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String direscripcion;

    @Column
    private Integer idDirector;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_direct_id")
    private Director idDirect;

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

    public Director getIdDirect() {
        return idDirect;
    }

    public void setIdDirect(final Director idDirect) {
        this.idDirect = idDirect;
    }

}
