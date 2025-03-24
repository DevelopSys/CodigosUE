package com.borja.ue.usuarioapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter

@Table(name = "empleados")
public class Empleados {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private Integer sueldo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPerfil", unique = true)
    private Perfiles idPerfil;


    public Empleados() {
    }

    public Empleados(String nombre, Integer sueldo, Perfiles idPerfil) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.idPerfil = idPerfil;
    }

    public Empleados(Long id, String nombre, Integer sueldo, Perfiles idPerfil) {
        this.id = id;
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.idPerfil = idPerfil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getSueldo() {
        return sueldo;
    }

    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }

    public Perfiles getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Perfiles idPerfil) {
        this.idPerfil = idPerfil;
    }
}
