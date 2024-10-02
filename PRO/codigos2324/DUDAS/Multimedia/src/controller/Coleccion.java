package controller;

import model.Elemento;
import model.Libro;
import model.Video;

import java.util.ArrayList;

public class Coleccion {
    private ArrayList<Elemento> lista;

    public Coleccion(){
        lista = new ArrayList<>();
    }

    public void agregarElementos(Elemento elemento){
        this.lista.add(elemento);
    }

    public void validadElementos(){
        for ( Elemento elemento: lista){
            System.out.println("Validando elemento");
            // si es un libro
            if (elemento instanceof Video){
                System.out.println("Voy a validar un video según sus actores");
                ((Video) elemento).metodoVideo();
            } else if (elemento instanceof Libro){
                System.out.println("Voy a validar el libreo según sus paginas");
            }
            // si es un video
            elemento.validar();
        }
    }

    public void mostrarElementos(){
        for ( Elemento elemento: lista ){
            elemento.mostrarDatos();
        }
    }
}
