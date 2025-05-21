package model;

final public class Coche extends Vehiculo {

    private int numeroPuertas;

    // si en una clase no se escribe ningun constructor, solo tengo el vacio!!!!!!
    // si se escribe un constructor explicito, se pierde el implicito

    public Coche(String marca, String modelo, int anio, int numeroPuertas) {
        super(marca, modelo, anio);
        this.numeroPuertas = numeroPuertas;
    }

    public Coche() {
    }

    // tengo el metodo mostrarDatos()???

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("numeroPuertas = " + numeroPuertas);
    }
    // public void mostrarDatos(String cosa){} -> sobrecarga
    public void metodoCoche(){
        System.out.println("Soy un coche");
    }


    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }
}
