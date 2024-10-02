package model;

public abstract class Vehiculo {

    private int bastidor;
    private String marca, modelo;
    private int cc, cv;
    private int velocidad;

    public Vehiculo(){}

    public Vehiculo(int bastidor, String marca, String modelo, int cc, int cv) {
        this.bastidor = bastidor;
        this.marca = marca;
        this.modelo = modelo;
        this.cc = cc;
        this.cv = cv;
    }

    public abstract void acelerar(int velocidad);

    public void mostrarDatos(){
        System.out.println("Bastidor "+bastidor);
        System.out.println("Marca "+marca);
        System.out.println("Modelo "+modelo);
        System.out.println("CC "+cc);
        System.out.println("CV "+cv);
        System.out.println("Velocidad "+velocidad);
    }


    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getBastidor() {
        return bastidor;
    }

    public void setBastidor(int bastidor) {
        this.bastidor = bastidor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }
}
