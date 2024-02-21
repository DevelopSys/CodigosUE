package model;

public class Deportivo extends Vehiculo{

    // tengo todo lo que tiene vehiculo y lo puedo utilizar sin problema
    // en el caso de querer utilizar un constructor lo tengo que llamar
    // explicitamente

    private int par;

    public Deportivo(){}

    public Deportivo(int bastidor, String marca, String modelo, int cc, int cv, int par){
        // this.bastidor = bastidor
        super(bastidor, marca, modelo, cc, cv);
        this.par = par;
    }

    @Override
    public void acelerar(int velocidad) {
        setVelocidad(getVelocidad()+velocidad+(int)(Math.random()*31)+20);
    }



    public void activarModoSport(){
        System.out.println("Activando super aceleracion");
    }
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("Par "+par);
    }

    public int getPar() {
        return par;
    }

    public void setPar(int par) {
        this.par = par;
    }
}
