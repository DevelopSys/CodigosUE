package model;

public class Accionista extends Persona implements Responsable{

    public Accionista() {
    }

    public Accionista(String dni, String nombre, String correo) {
        super(dni, nombre, correo);
    }

    @Override
    public void realizarVotacion(int voto) {
        System.out.println("El accionista ha entrado en escena y votará con un valor de "+voto);
        int aleatorio = voto *2;
        System.out.println("El voto supremo del accionista es "+aleatorio);
    }
}
