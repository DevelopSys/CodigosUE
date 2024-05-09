package model;

public class LibroTerror extends Libro{

    private int calificacion;

    public LibroTerror() {
    }

    public LibroTerror(String autor, int numeroPaginas, String isbn, int calificacion) {
        super(autor, numeroPaginas, isbn);
        this.calificacion = calificacion;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("calificacion = " + calificacion);
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
