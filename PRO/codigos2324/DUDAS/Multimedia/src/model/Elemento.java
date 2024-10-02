package model;

public abstract class Elemento {

    private int id;
    private String titulo, autor, formato;
    private int tamanio;

    public Elemento() {
    }

    public Elemento(int id, String titulo, String autor, String formato, int tamanio) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.formato = formato;
        this.tamanio = tamanio;
    }

    public abstract void validar();

    public void mostrarDatos(){
        System.out.println("id = " + id);
        System.out.println("titulo = " + titulo);
        System.out.println("autor = " + autor);
        System.out.println("formato = " + formato);
        System.out.println("tamaño = " + tamanio);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
}
