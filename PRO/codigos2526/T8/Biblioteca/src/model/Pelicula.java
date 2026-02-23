package model;

public final class Pelicula extends Elemento {

    private int duracion;

    // solo un constructor
    public Pelicula(){}
    public Pelicula(String isbn, String autor, int codigo, int duracion){
        super(isbn,autor,codigo);
        this.duracion = duracion;
    }

    public Pelicula(String isbn, String autor, int duracion){
        super(isbn, autor);
        this.duracion = duracion;
    }

    @Override // sobreescritura
    public void mostraDatos() {
        super.mostraDatos();
        System.out.println("duracion = " + duracion);
    }

    // tengo todos los metodos publicos de elemento
    public void estrenar(){
        System.out.println("Procedemos al estreno de la pelicula con autor "+getAutor());
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
