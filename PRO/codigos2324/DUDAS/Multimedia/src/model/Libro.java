package model;

public class Libro extends Elemento {

    private int ISBN;
    private int numeroPaginas;

    public Libro() {

    }



    public Libro(int id, String titulo, String autor, String formato,
                 int tamanio, int ISBN, int numeroPag) {

        super(id,titulo,autor,formato,tamanio);
        this.ISBN = ISBN;
        this.numeroPaginas = numeroPag;

    }

    @Override
    public void validar() {
        if (numeroPaginas>50){
            System.out.println("El libro queda validado");
        }
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("ISBN = " + ISBN);
        System.out.println("numero paginas = " + numeroPaginas);
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
}
