package model;

public class Libro extends Elemento{

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

    public Soporte getSoporte() {
        return soporte;
    }

    public void setSoporte(Soporte soporte) {
        this.soporte = soporte;
    }
}
