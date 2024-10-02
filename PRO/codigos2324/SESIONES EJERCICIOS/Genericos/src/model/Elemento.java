package model;

// clase base de libro, audio, video
public abstract class Elemento {

    // id, titulo, autor, tamaño, formato
    private int id;
    private String titulo;
    private Persona autor;
    private int tamanio;
    private String formato;

    public Elemento(int id, String titulo, Persona autor, int tamanio, String formato) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.tamanio = tamanio;
        this.formato = formato;
    }

    public void mostrarDatos(){
        System.out.println("id = " + id);
        System.out.println("titulo = " + titulo);
        System.out.println("tamanio = " + tamanio);
        System.out.println("formato = " + formato);
        autor.mostrarDatos();
    }

    public Elemento() {
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

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
}
