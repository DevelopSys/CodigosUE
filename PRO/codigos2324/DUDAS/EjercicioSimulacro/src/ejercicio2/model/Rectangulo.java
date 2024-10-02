package ejercicio2.model;

public final class Rectangulo extends Figura2D{

    private int longBase, longAltura;

    public Rectangulo() {
    }

    public Rectangulo(String nombre, int longBase, int longAltura) {
        super(nombre);
        this.longBase = longBase;
        this.longAltura = longAltura;
    }

    public int getLongBase() {
        return longBase;
    }

    public void setLongBase(int longBase) {
        this.longBase = longBase;
    }

    public int getLongAltura() {
        return longAltura;
    }

    public void setLongAltura(int longAltura) {
        this.longAltura = longAltura;
    }

    @Override
    public double calcularPerimetro() {
        setPerimetro(longAltura+longBase);
        return getPerimetro();
    }

    @Override
    public String toString() {
        return "Rectangulo{" +
                "longBase=" + longBase +
                ", longAltura=" + longAltura +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        return this.equals(obj);
    }
}
