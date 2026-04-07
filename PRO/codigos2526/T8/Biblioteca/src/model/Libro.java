package model;

public final class Libro extends Elemento implements Alquilable{

    private Soporte soporte;


    public Libro(){}

    public Libro(String isbn, String autor, int codigo, Soporte soporte){
        super(isbn, autor, codigo);
        this.soporte = soporte;
    }

    public Libro(String isbn, String autor, Soporte soporte){
        super(isbn, autor);
        this.soporte = soporte;
    }


    public void publicarContenido(){
        if (soporte == Soporte.FISICO){
            System.out.println("Disponible en todas las librerias");
        } else if (soporte == Soporte.DIGITAL) {
            System.out.println("Disponible en Kidel");
        }
    }

    @Override
    public void mostraDatos() {
        super.mostraDatos();
        System.out.println("soporte = " + soporte);
    }

    @Override
    public void vender() {
        if (soporte == Soporte.FISICO){
            System.out.println("Lo venderemos en bibliotecas a un precio alto");
        } else {
            System.out.println("Vendido en plataformas no tan caro");
        }
    }

    public Soporte getSoporte() {
        return soporte;
    }

    public void setSoporte(Soporte soporte) {
        this.soporte = soporte;
    }

    @Override
    public void alquilar() {
        if(soporte == Soporte.FISICO){

        System.out.println("El libro se alquila por 5 dias ya que tiene un n isbn de "+getIsbn());
        } else {
            System.out.println("Solo estará habilitado el acceso durante 3 dias");
        }
    }
}
