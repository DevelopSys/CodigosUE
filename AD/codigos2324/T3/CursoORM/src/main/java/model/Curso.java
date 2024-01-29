package model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table (name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String siglas;
    @Column
    private String nombre;
    @OneToOne (mappedBy = "curso")
    private Alumno alumno;
    public Curso(String siglas, String nombre) {
        this.siglas = siglas;
        this.nombre = nombre;
    }
}
