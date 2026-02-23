package model;

public abstract class Elemento {
    private String isbn;
    private String autor;
    private int codigo;

    public Elemento() {
    }

    public Elemento(String isbn, String autor, int codigo) {
        this.isbn = isbn;
        this.autor = autor;
        this.codigo = codigo;
    }

    public Elemento(String isbn, String autor) {
        this.isbn = isbn;
        this.autor = autor;
    }

    public void mostraDatos(){
        System.out.println("isbn = " + isbn);
        System.out.println("autor = " + autor);
        System.out.println("codigo = " + codigo);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
