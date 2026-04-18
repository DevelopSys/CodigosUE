package io.bootify.cursos_app.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Cursoes")
@Getter
@Setter
public class Curso {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column
    private Long idProfesor;

    @OneToMany(mappedBy = "idCursoFK")
    private Set<Usuario> usuario = new HashSet<>();

    @OneToOne(mappedBy = "idCursoFK", fetch = FetchType.LAZY)
    private Profesor profesor;

}
