package controller;

import model.Coche;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Campeonato {

    private String nombre;
    private ArrayList<Carrera> listaCarreras;
    private ArrayList<Coche> listaParticipantes;
    private Coche campeon;


    public Campeonato() {
    }

    public Campeonato(String nombre) {
        this.nombre = nombre;
        this.listaCarreras = new ArrayList<>();
        this.listaParticipantes = new ArrayList<>();
    }

    public void inscribirParticipante(Coche coche) {
        if (listaParticipantes.size() == 20) {
            System.out.println("Error en la inscripcion: no hay plazas");
        } else {

            if (estaCoche(coche.getMatricula()) != null) {
                System.out.println("Error en la inscripcion. Datos duplicados");
            } else {
                listaParticipantes.add(coche);
                System.out.println("Agregado correctamente");
            }
        }
    }

    private Coche estaCoche(String matricula) {

        Coche coincideCoche = null;

        for (Coche coche : this.listaParticipantes) {
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
            listaParticipantes.remove(cocheEncontrado);
            System.out.println("El coche se ha borrado ok");
        } else {
            System.out.println("No esta");
        }


    }

    public void agregarCarrera(Carrera carrera) {
        // restriccion de numero o repetir circuito?
        listaCarreras.add(carrera);
    }

    public void mostrarDatos() {

        System.out.printf("El campeonato con nombre %s " +
                "tiene los siguientes datos:\n", nombre);
        System.out.println("Los participantes son:");
        for (Coche item : listaParticipantes) {
            System.out.printf("\t%s %s\n", item.getNombre()
                    , item.getMatricula());
        }
        System.out.println("Las carreras son:");
        for (Carrera item : listaCarreras) {
            System.out.printf("\tNombre: %s Vueltas: %d KM: %d\n"
                    , item.getCircuito().getNombre(),
                    item.getCircuito().getVueltas(),
                    item.getCircuito().getKmTotales()
            );
        }
    }


    // iniciarCampeonato
    public void iniciarCampeonato() {

        for (Carrera item : listaCarreras) {

            System.out.println("Procedemos a correr la carrara en "
                    + item.getCircuito().getNombre());

            item.setParticipantes(listaParticipantes);
            item.iniciarCarrera();
            System.out.println("La situacion del campeonato tras correr la carrera es");
            mostrarParrilla();

        }
    }

    public void mostrarParrilla() {
        ordenarParrilla();
        for (int i = 0; i < listaParticipantes.size(); i++) {
            System.out.printf("%d - %s %d km\n", i + 1,
                    listaParticipantes.get(i).getNombre()
                    , listaParticipantes.get(i).getPuntos());
        }

    }

    public void ordenarParrilla() {
        Collections.sort(listaParticipantes, new Comparator<Coche>() {
            @Override
            public int compare(Coche o1, Coche o2) {
                if (o1.getPuntos() < o2.getPuntos()) {
                    return 1;
                } else if (o1.getPuntos() > o2.getPuntos()) {
                    return -1;
                }
                return 0;
            }
        });
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Carrera> getListaCarreras() {
        return listaCarreras;
    }

    public void setListaCarreras(ArrayList<Carrera> listaCarreras) {
        this.listaCarreras = listaCarreras;
    }

    public ArrayList<Coche> getListaParticipantes() {
        return listaParticipantes;
    }

    public void setListaParticipantes(ArrayList<Coche> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }

    public Coche getCampeon() {
        return campeon;
    }

    public void setCampeon(Coche campeon) {
        this.campeon = campeon;
    }
}
