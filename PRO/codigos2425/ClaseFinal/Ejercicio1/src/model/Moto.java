package model;

final public class Moto extends Vehiculo{

    private int cilindrada;

    public Moto() {
    }

    public Moto(String marca, String modelo, int anio, int cilindrada) {
        super(marca, modelo, anio);
        this.cilindrada = cilindrada;
    }
    public void metodoMoto(){
        System.out.println("Soy una moto");
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("cilindrada = " + cilindrada);
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
}
