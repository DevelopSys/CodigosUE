package ejercicio2.model;

public final class Circulo extends Figura2D{

    private int radio;

    public Circulo() {
    }

    public Circulo(String nombre, int radio) {
        super(nombre);
        this.radio = radio;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    @Override
    public double calcularPerimetro() {
        setPerimetro(Math.PI*Math.pow(radio,2));
        return getPerimetro();
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "radio=" + radio +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Circulo;
    }
}
