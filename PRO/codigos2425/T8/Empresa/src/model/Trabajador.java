package model;

public abstract class Trabajador extends Persona {

    private int sueldoBruto;

    public Trabajador(){}
    public Trabajador(String nombre, String apellido, int telefono, int sueldoBruto) {
        super(nombre, apellido, telefono);
        this.sueldoBruto = sueldoBruto;
    }

    public abstract void calcularSueldo();

    @Override
    public void mostarDatos() {
        System.out.println("sueldoBruto = " + sueldoBruto);
        super.mostarDatos();
    }

    public int getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(int sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }
}
