package controller;

import model.Circuito;
import model.Coche;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Carrera {

    private Circuito circuito;
    private Coche ganador;
    private ArrayList<Coche> participantes;

    public Carrera() {
    }

    public Carrera(Circuito circuito) {
        this.circuito = circuito;
        // ganador = null
        this.participantes = new ArrayList<>();
    }


    public void mostrarDatos() {
        System.out.println("La carrera se corre en " + circuito.getNombre());
        System.out.println("Los datos de la carrera son");
        System.out.println("KM: " + circuito.getKmTotales());
        System.out.println("Vueltas: " + circuito.getVueltas());
        System.out.println("Nº de participantes: " + participantes.size());
    }
    public void decidirGanador() {

        ganador = participantes.get(0);
        if (ganador.getKm() >= circuito.getKmTotales()) {
            ganador = participantes.get(0);
            System.out.printf("El ganador de la carrera es %s con %dkm\n",
                    ganador.getNombre(), ganador.getKm());
        } else {
            //System.out.println("No hay ganador");
            ganador = null;
        }

    }

    public void resetearKM(){
        for (Coche coche : participantes ) {
            coche.setKm(0);
        }
    }

    public void iniciarCarrera() {

        for (int i = 0; i < circuito.getVueltas(); i++) {

            for (Coche item : participantes) {
                item.acelerar((int) (Math.random() * 51) + 25);
            }

        }

        decidirGanador();
        // si no hay ganador -> vuelta extra
        // si hay ganador -> muestro datos
        while (ganador == null) {
            //System.out.println("Vuelta extra!!!");
            for (Coche item : participantes) {
                item.acelerar((int) (Math.random() * 51) + 25);
            }
            ordenarParrilla();
            decidirGanador();
        }

        repartirPuntos();

    }

    public void repartirPuntos(){

       participantes.get(0).setPuntos(participantes.get(0).getPuntos()+10);
       participantes.get(1).setPuntos(participantes.get(1).getPuntos()+5);
       participantes.get(2).setPuntos(participantes.get(2).getPuntos()+2);
    }

    public void inscribirParticipante(Coche coche) {
        if (participantes.size() == 20) {
            System.out.println("Error en la inscripcion: no hay plazas");
        } else {

            if (estaCoche(coche.getMatricula()) != null) {
                System.out.println("Error en la inscripcion. Datos duplicados");
            } else {
                participantes.add(coche);
                System.out.println("Agregado correctamente");
            }
        }
    }

    private Coche estaCoche(String matricula) {

        Coche coincideCoche = null;
        // recorre la lista y pregunta por las matriculas
        for (Coche coche : this.participantes) {
            if (coche.getMatricula().equalsIgnoreCase(matricula)) {
                coincideCoche = coche;
                break;
            }
        }
        return coincideCoche;
    }

    public void descalificarParticipante(String matricula) {
        Coche cocheEncontrado = estaCoche(matricula);

        if (cocheEncontrado != null) {
            participantes.remove(cocheEncontrado);
            System.out.println("El coche se ha borrado ok");
        } else {
            System.out.println("No esta");
        }
    }


    public void ordenarParrilla(){
        Collections.sort(participantes, new Comparator<Coche>() {
            @Override
            public int compare(Coche o1, Coche o2) {
                if (o1.getKm() < o2.getKm()) {
                    return 1;
                } else if (o1.getKm() > o2.getKm()) {
                    return -1;
                }
                return 0;
            }
        });
    }
    public void mostrarParrilla() {

        for (int i = 0; i < participantes.size(); i++) {
            System.out.printf("%d - %s %d km\n", i + 1, participantes.get(i).getNombre()
                    , participantes.get(i).getKm());
        }

    }


    public Circuito getCircuito() {
        return circuito;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    public Coche getGanador() {
        return ganador;
    }

    public void setGanador(Coche ganador) {
        this.ganador = ganador;
    }

    public ArrayList<Coche> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Coche> participantes) {
        this.participantes = participantes;
    }
}
