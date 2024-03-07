package controller;

import model.*;

import java.util.ArrayList;

public class Empresa {

    ArrayList<Persona> listaPersonas;

    public Empresa() {
        this.listaPersonas = new ArrayList<>();
    }

    public void agregarPersona(Persona persona){
        listaPersonas.add(persona);
    }

    public void empezarJornadaLaboral(){
        for ( Persona item : listaPersonas){
            if (item instanceof Trabajador){
                ((Trabajador) item).trabajar();
            }
        }
    }

    public void realizarVotacion(){
        for ( Persona item : listaPersonas){
            if (item instanceof Responsable){
                ((Responsable) item).realizarVotacion((int) (Math.random()*5)+1);
            }
        }
    }
}
