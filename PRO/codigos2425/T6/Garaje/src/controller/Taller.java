package controller;

import model.Coche;

public class Taller {
    // representa toda la funcionalidad de la aplicacion
    // Garaje -> coches -> pintados -> reparados ->
    private Coche[] coches;
    private boolean disponible;
    private double caja;
    private int contadorCoches = 0;

    public Taller() {
        // caja = 0
        disponible = true;
        coches = new Coche[3]; // [null,null,null]
    }

    public void pintarCoche(Coche coche, String color) {
        // 500
        if (disponible) {
            // guardar el coche en la posicion donde el valor sea NULL
            for (int i = 0; i < coches.length; i++) {
                if (coches[i] == null) {
                    coches[i] = coche;
                    contadorCoches++;
                    break;
                }
            }
            // cuando el taller no esta disponible
            if(contadorCoches==coches.length){
                disponible = false;
            }
            coche.setColor(color);

        } else {
            System.out.println("No hay hueco en el taller, venga mas adelante");
        }
    }

    public void recogerCoche(String modelo){
        for (int i = 0; i < coches.length; i++) {
            if (coches[i].getModelo().equalsIgnoreCase(modelo)){
                System.out.println("Coche encontrado, procedemos al pago");
                double precioRandom = (Math.random() * 301) + 300;
                caja += precioRandom; // 300 - 600
                System.out.println("Te he cobrado " + precioRandom);
                // [c1,c2,null]
                contadorCoches--;
                coches[i] = null;
                disponible = true;
                return;
            }
        }
        System.out.println("Coche no encontrado, por favor comprueba tu resguardo");
    }

    public Coche[] getCoches() {
        return coches;
    }

    public void setCoches(Coche[] coches) {
        this.coches = coches;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public double getCaja() {
        return caja;
    }

    public void setCaja(double caja) {
        this.caja = caja;
    }
}
