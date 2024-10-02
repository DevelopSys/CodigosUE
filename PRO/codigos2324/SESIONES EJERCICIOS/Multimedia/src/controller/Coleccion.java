package controller;

import model.Elemento;
import model.Libro;
import model.Video;

import java.util.ArrayList;

public class Coleccion {

    private ArrayList<Elemento> listaElementos;

    public Coleccion() {
        listaElementos = new ArrayList<>();
    }

    public void anadirElementos(Elemento elemento){

        if (estaElemento(elemento.getId())==null){
            System.out.println("Agregado correctamente");
            this.listaElementos.add(elemento);
        } else {
            System.out.println("Elemento duplicado");
        }
    }

    public Elemento estaElemento(int id){

        for ( Elemento item : listaElementos ){
            if (item.getId() == id){
                return item;
            }
        }

        return null;

    }

    public void listarElementos(){
        for ( Elemento item : listaElementos){
            item.mostrarDatos();
        }
    }

    public void buscarElemento(int id){
        for ( Elemento item :  listaElementos ){
            if (item.getId() == id){
                System.out.println("Elemento encontrado");
                item.mostrarDatos();
                break;
            }
        }
    }

    public void buscarDirector(String nombre){
        for ( Elemento item :  listaElementos ){
            if (item instanceof Video){
                if (((Video) item).getDirector().getNombre().equalsIgnoreCase(nombre)){
                    item.mostrarDatos();
                }
            }
        }
    }

    public void eliminarElemento(int id){
        for ( Elemento item :  listaElementos ){
            if (item.getId() == id){
                listaElementos.remove(item);
                break;
            }
        }
    }

}
