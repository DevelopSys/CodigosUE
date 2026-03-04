package model;

public final class Revista extends Elemento implements Alquilable{

    private Tapa tipoTapa;
    private Tirada tirada;

    public Revista(){}

    public Revista(String isbn, String autor, int codigo, Tapa tipoTapa, Tirada tirada){
        super(isbn, autor, codigo);
        this.tipoTapa = tipoTapa;
        this.tirada = tirada;
    }

    public Revista(String isbn, String autor, Tapa tipoTapa, Tirada tirada){
        super(isbn, autor);
        this.tirada = tirada;
        this.tipoTapa = tipoTapa;
    }

    public void editar(){
        System.out.println("La revista pasa al proceso de edicion");
    }



    @Override
    public void mostraDatos() {
        super.mostraDatos();
        System.out.println("tipoTapa = " + tipoTapa);
        System.out.println("tirada = " + tirada);
    }

    @Override
    public void vender() {
        if(tipoTapa == Tapa.Blanda && tirada == Tirada.Internacional){
            System.out.println("La vendemos por un pico");
        } else if (tirada == Tirada.Internacional) {
            System.out.println("La vendemos bien");
        } else {
            System.out.println("Se venderá pero no por mucha pasta");
        }
    }

    public Tapa getTipoTapa() {
        return tipoTapa;
    }

    public void setTipoTapa(Tapa tipoTapa) {
        this.tipoTapa = tipoTapa;
    }

    public Tirada getTirada() {
        return tirada;
    }

    public void setTirada(Tirada tirada) {
        this.tirada = tirada;
    }
}
