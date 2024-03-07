package model;

public class Jefe extends Trabajador implements Responsable{

    private int percAcciones;
    private Puesto puesto;

    @Override
    public void trabajar() {
        System.out.println("El jefe va a trabajar");
    }

    public Jefe() {
    }

    public Jefe(String dni, String nombre, String correo, int salario, int percAcciones, Puesto puesto) {
        super(dni, nombre, correo, salario);
        this.puesto = puesto;
        this.percAcciones = percAcciones;
        setSalario(getSalario()+puesto.getSalarioAdicion());
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("percAcciones = " + percAcciones);

    }

    @Override
    public void realizarVotacion(int valor) {
        System.out.println("El jefe se dispone a votar por un valor de "+valor);
        int voto = valor/2;
        System.out.println("El voto del jefe es "+voto);
    }
}
