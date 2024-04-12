package model;

public final class Libro extends Elemento {

    private String isbn;
    private int nPaginas;

    public Libro() {
    }

    public Libro(int id, String titulo, Persona autor, int tamanio, String formato, String isbn, int nPaginas) {
        super(id, titulo, autor, tamanio, formato);
        this.isbn = isbn;
        this.nPaginas = nPaginas;
    }

    // todos los metodos del Elemento

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("isbn = " + isbn);
        System.out.println("nPaginas = " + nPaginas);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getnPaginas() {
        return nPaginas;
    }

    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }
}
