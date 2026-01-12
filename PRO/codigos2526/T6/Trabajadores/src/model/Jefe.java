package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Jefe {

    private String nombre, apellido;
    private int nivelResponsabilidad, personasCargo;

    public Jefe(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // cuantos constructores hay?? -> 1 el vacio
    // constructores -> tantos como necesites -> minimo vacio y el con todo
    // getter y setter

}
