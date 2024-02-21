package model;

public class MotoCarretera extends Vehiculo{

    private String tipoNeumatico;


    public MotoCarretera() {
    }

    @Override
    public void acelerar(int velocidad) {
        setVelocidad(getVelocidad()+velocidad+(int)(Math.random()*30)+25);
    }

    public MotoCarretera(int bastidor, String marca, String modelo, int cc, int cv, String tipoNeumatico) {
        super(bastidor, marca, modelo, cc, cv);
        this.tipoNeumatico = tipoNeumatico;
    }

    public void realizarCaballito(){
        System.out.println("Estas haciendo un caballito con la moto");
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Tipo neumatico: "+tipoNeumatico);
    }

    public String getTipoNeumatico() {
        return tipoNeumatico;
    }

    public void setTipoNeumatico(String tipoNeumatico) {
        this.tipoNeumatico = tipoNeumatico;
    }
}
