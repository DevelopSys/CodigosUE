package model;

import java.io.Serializable;

public abstract class Libro implements Serializable {

    private static Long serialVersionId = 123123123L;

    // autor, numeroPaginas, ISBN
    private String autor;
    private int numeroPaginas;
    private String isbn;

    public Libro(){

    }

    public Libro(String autor, int numeroPaginas, String isbn) {
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
    }

    public void mostrarDatos(){
        System.out.println("autor = " + autor);
        System.out.println("numeroPaginas = " + numeroPaginas);
        System.out.println("isbn = " + isbn);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
