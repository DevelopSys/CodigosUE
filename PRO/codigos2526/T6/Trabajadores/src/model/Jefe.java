package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Jefe {

    private String nombre, apellido;
    private int nivelResponsabilidad, personasCargo;

    public Jefe(){}
    public Jefe(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void mandar(){
        System.out.println("Soy jefe y mando mucho");
    }

    public void mostarDatos(){
        System.out.println("nombre = " + nombre);
        System.out.println("apellido = " + apellido);
        System.out.println("nivelResponsabilidad = " + nivelResponsabilidad);
        System.out.println("personasCargo = " + personasCargo);
    }

    // cuantos constructores hay?? -> 1 el vacio
    // constructores -> tantos como necesites -> minimo vacio y el con todo
    // getter y setter

}
