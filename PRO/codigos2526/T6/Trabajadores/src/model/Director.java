package model;

import lombok.*;

@Getter
@Setter

public class Director {

    private String nombre;
    private String apellido;

    public Director(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Director() {
    }

    public void dirigirMasas(String mensaje){
        System.out.println("Atento todo el mundo, soy un Director con nombre "+nombre+ " y voy a lansar un mensaje");
        System.out.println(mensaje);
    }

    public void setNombre(String nombre){
        if(nombre.equals("Juan")){
            System.out.println("No me gusta el nombre no me lo cambio");
        } else {
            this.nombre = nombre;
        }
    }


}
