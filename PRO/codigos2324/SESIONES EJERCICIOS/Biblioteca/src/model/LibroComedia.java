package model;

public class LibroComedia extends Libro{

    private String tipoHumor;

    public LibroComedia() {
    }

    public LibroComedia(String autor, int numeroPaginas, String isbn, String tipoHumor) {
        super(autor, numeroPaginas, isbn);
        this.tipoHumor = tipoHumor;
    }

    public String getTipoHumor() {
        return tipoHumor;
    }

    public void setTipoHumor(String tipoHumor) {
        this.tipoHumor = tipoHumor;
    }
}
