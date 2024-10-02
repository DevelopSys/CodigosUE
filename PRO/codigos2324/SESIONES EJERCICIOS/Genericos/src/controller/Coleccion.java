package controller;

import model.Elemento;

import java.util.ArrayList;

public class Coleccion<T extends Elemento,S> {

    private ArrayList<T> listaElementos;

    public Coleccion() {
        listaElementos = new ArrayList<>();
    }

    public void addElementos(T elemento){
        listaElementos.add(elemento);
        // instance of
    }

    public void listarElementos(){
        for ( T elemento : listaElementos ) {
            System.out.println(elemento);
        }
    }

    public void metodosGenerico(S parametro){

    }
}
