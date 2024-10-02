package model;

public class Asalariado extends Trabajador {

    private int numeroPagas;

    public Asalariado() {
    }

    public Asalariado(String dni, String nombre, String correo, int salario, int numeroPagas) {
        super(dni, nombre, correo, salario);
        this.numeroPagas = numeroPagas;
    }

    @Override
    public void trabajar() {
        System.out.println("Iniciando la jornada");
        System.out.println("tu numero de pagas es " + numeroPagas);
        System.out.println("Que sepas que eres un trabajador");
    }

    public int getNumeroPagas() {
        return numeroPagas;
    }

    public void setNumeroPagas(int numeroPagas) {
        this.numeroPagas = numeroPagas;
    }
}
