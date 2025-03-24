package model;

public final class Asalariado extends Trabajador{

    private double iva;
    private int nPagas;

    public Asalariado() {
    }

    public Asalariado(String nombre, String apellido, int telefono, int sueldoBruto, double iva, int nPagas) {
        super(nombre, apellido, telefono, sueldoBruto);
        this.iva = iva;
        this.nPagas = nPagas;
    }

    @Override
    public void mostarDatos() {
        super.mostarDatos();
        System.out.println("iva = " + iva);
        System.out.println("nPagas = " + nPagas);
    }

    public void descansarAsalariado(){
        System.out.println("El asalariado esta descansando");
    }

    @Override
    public void calcularSueldo() {
        double sueldoNeto = (getSueldoBruto() - getSueldoBruto()*iva)/nPagas;
        System.out.println("El sueldo neto es "+sueldoNeto);
    }
}
