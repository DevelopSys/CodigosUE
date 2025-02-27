package controller;

import model.Trabajador;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Empresa {
    private String nombre;
    private ArrayList<Trabajador> listaTrabajadores;
    private ArrayList<Trabajador> listaDespedidos;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.listaTrabajadores = new ArrayList();
        this.listaDespedidos = new ArrayList<>();
    }

    public void contratarTrabajador(Trabajador trabajador){
        if (estaTrabajador(trabajador.getDni())!=null) {
            // un trabajador no se puede contratar si ya tengo uno con el mismo dni
            System.out.println("Lo siento el trabajado esta en la empresa");
        } else {
            // un trabajdor se puede contratar si no tengo el dni en la lista
            listaTrabajadores.add(trabajador);
            System.out.println("Contratado con exito");
        }
    }

    private Trabajador estaTrabajador(String dni){

        for (Trabajador item: listaTrabajadores) {
            if(item.getDni().equalsIgnoreCase(dni)){
                return item;
            }
        }
        return null;
    }

    public void obtenerTrabajador(String dni){
        Trabajador trabajadorBusqueda = estaTrabajador(dni);
        if (trabajadorBusqueda!=null){
            trabajadorBusqueda.mostrarDatos();
        } else {
            System.out.println("Trabajador no encontrado");
        }
    }
    public void obtenerTrabajador(){
        listaTrabajadores.getLast().mostrarDatos();
    }
    public void mostrarTrabajadores(){
        // si hay trabajadores
        if (!listaTrabajadores.isEmpty()){
            for ( Trabajador item : listaTrabajadores ) {
                item.mostrarDatos();
            }
        } else {
            System.out.println("No hay trabajadores, todos despedidos");
        }

        // si no hay trabajadores -> aviso
    }
    public void despedirTrabajador(){
        listaTrabajadores.remove(1);
    }
    public void despedirTrabajador(String dni){
        // recorro la lista
        // if
        for ( Trabajador t: listaTrabajadores) {
            if (t.getDni().equalsIgnoreCase(dni)){
                listaTrabajadores.remove(t);
                break;
                // listaDespedidos.add(t);
            }
        }

    }
    public void despedirTrabajadorNombre(String nombre){
        listaTrabajadores.removeIf(new Predicate<Trabajador>() {
            @Override
            public boolean test(Trabajador trabajador) {
                return trabajador.getNombre().equalsIgnoreCase(nombre);
            }
        });
    }
    public void despedirTodos(){
        // listaTrabajadores = new ArrayList<>();
        /*listaTrabajadores.removeIf(new Predicate<Trabajador>() {
            @Override
            public boolean test(Trabajador trabajador) {
                return true;
            }
        });*/
        listaTrabajadores.clear();
    }



}
