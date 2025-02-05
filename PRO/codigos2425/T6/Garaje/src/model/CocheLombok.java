package model;

public class CocheLombok {

    private String marca, modelo, color, matricula;
    private int cv;
    private double precio;

    public CocheLombok(String marca, String modelo, String color, int cv, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.cv = cv;
        this.precio = precio;
    }

    public CocheLombok(String marca, String modelo, String color, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.matricula = matricula;
    }

    public CocheLombok(String marca, String modelo) {


        this.marca = marca;
        this.modelo = modelo;
    }
}
