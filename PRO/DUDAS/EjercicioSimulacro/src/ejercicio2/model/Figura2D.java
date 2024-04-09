package ejercicio2.model;

public abstract class Figura2D implements FiguraGeometrica {

    private String nombre;
    private double perimetro;

    public Figura2D() {
    }

    public Figura2D(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    // public abstract void calcularPerimetro();
}
