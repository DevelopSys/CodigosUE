package model;

public class Todoterreno extends Vehiculo{

    private String traccion;

    public Todoterreno() {
    }

    @Override
    public void acelerar(int velocidad) {
        setVelocidad(getVelocidad()+velocidad);
    }

    public Todoterreno(int bastidor, String marca, String modelo, int cc, int cv, String traccion) {
        super(bastidor, marca, modelo, cc, cv);
        this.traccion = traccion;
    }

    public void subirRampa(){
        System.out.println("Estas subiendo una rampa");
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Traccion "+traccion);
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }
}
