package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class Direccion implements Serializable {

    @Column
    private String provincia;
    @Column
    private String localidad;

}
