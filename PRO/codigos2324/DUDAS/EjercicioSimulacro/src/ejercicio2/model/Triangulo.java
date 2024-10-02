package ejercicio2.model;

public final class Triangulo extends Figura2D{

    private int longLado1, longLado2, longLado3;

    public Triangulo() {
    }

    public Triangulo(String nombre, int longLado1, int longLado2, int longLado3) {
        super(nombre);
        this.longLado1 = longLado1;
        this.longLado2 = longLado2;
        this.longLado3 = longLado3;
    }

    public int getLongLado1() {
        return longLado1;
    }

    public void setLongLado1(int longLado1) {
        this.longLado1 = longLado1;
    }

    public int getLongLado2() {
        return longLado2;
    }

    public void setLongLado2(int longLado2) {
        this.longLado2 = longLado2;
    }

    public int getLongLado3() {
        return longLado3;
    }

    public void setLongLado3(int longLado3) {
        this.longLado3 = longLado3;
    }

    @Override
    public double calcularPerimetro() {
        setPerimetro(longLado1+longLado2+longLado3);
        return getPerimetro();
    }

    @Override
    public String toString() {
        return "Triangulo{" +
                "longLado1=" + longLado1 +
                ", longLado2=" + longLado2 +
                ", longLado3=" + longLado3 +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        return this.equals(obj);
    }
}
