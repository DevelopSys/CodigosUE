package model;

import utils.TipoPoliciaca;

public class LibroPoliciaca extends Libro{

    private String personaje;
    private TipoPoliciaca tipo;

    public LibroPoliciaca() {
    }

    public LibroPoliciaca(String autor, int numeroPaginas, String isbn, String personaje, TipoPoliciaca tipo) {
        super(autor, numeroPaginas, isbn);
        this.personaje = personaje;
        this.tipo = tipo;
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    public TipoPoliciaca getTipo() {
        return tipo;
    }

    public void setTipo(TipoPoliciaca tipo) {
        this.tipo = tipo;
    }
}
