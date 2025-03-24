package model;

public final  class Autonomo extends Trabajador{
    private int cuotaSS;

    public Autonomo() {
    }

    public Autonomo(String nombre, String apellido, int telefono, int sueldoBruto, int cuotaSS) {
        super(nombre, apellido, telefono, sueldoBruto);
        this.cuotaSS = cuotaSS;
    }

    @Override
    public void calcularSueldo() {
        double sueldoNeto = (getSueldoBruto() - (cuotaSS*12))/12;
        System.out.println("sueldoNeto = " + sueldoNeto);
    }

    @Override
    public void mostarDatos() {
        super.mostarDatos();
        System.out.println("cuotaSS = " + cuotaSS);
    }

    public int getCuotaSS() {
        return cuotaSS;
    }

    public void setCuotaSS(int cuotaSS) {
        this.cuotaSS = cuotaSS;
    }
}
