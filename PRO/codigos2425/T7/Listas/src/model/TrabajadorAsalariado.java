package model;

public class TrabajadorAsalariado extends Trabajador  {

    private int nomina;

    public TrabajadorAsalariado(String nombre, String apellido,
                                String correo, String dni,
                                int telefono, int nomina) {
        super(nombre, apellido, correo, dni, telefono);
        this.nomina = nomina;
    }

    @Override
    public void calcularSalario() {

    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("nomina = " + nomina);
    }

    public int getNomina() {
        return nomina;
    }

    public void setNomina(int nomina) {
        this.nomina = nomina;
    }
}
