package model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private long id;
    @Column
    private String siglas;
    @Column
    private String nombre;

    public Curso(String siglas, String nombre) {
        this.siglas = siglas;
        this.nombre = nombre;
    }
}
