package controller;

import model.Trabajador;

import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;

public class EmpresaHash {

    private Hashtable<String, Trabajador> listaTrabajadores;

    public EmpresaHash() {
        this.listaTrabajadores = new Hashtable<>();
    }

    // agregar trabajador
    public void agregarTrabajador(Trabajador trabajador){
        // voy a buscar si el dni del trabajador que tu me intentas add ya lo tengo en la empresa
        if(listaTrabajadores.containsKey(trabajador.getDni())){
            // esta en true, por lo tanto este dni esta en la lista
            System.out.println("No puedo, dni ya registrado");
        } else{
            // esta en false, por lo tanto no esta en la lista el dni
            System.out.println("Contratando trabajador");
            listaTrabajadores.put(trabajador.getDni(), trabajador);
        }
    }
    // obtener trabajador
    // buscar trabajador
    public void obtenerTrabajador(String dni){
        Trabajador trabajador = listaTrabajadores.get(dni);
        // como puedo saber si el dni que me das es de un trabajador que esta en la empresa
        if (trabajador!=null){
            System.out.println("Trabajador encontrado, sus datos no");
            trabajador.mostrarDatos();
        } else {
            System.out.println("Debe ser un error, dni incorrecto");
        }
    }

    // eliminar trabajador
    public void eliminarTrabajor(String dni){
        Trabajador trabajador = listaTrabajadores.remove(dni);
        // como se si lo he eliminado bien
        if ( trabajador!=null){
            /*System.out.println("Sus datos son ");
            trabajador.mostrarDatos();*/
            System.out.println("Perfecto, borrado con existo");
        } else {
            System.out.println("No se ha podido borrar, trabajador no encontrado");
        }
    }

    // listar trabajadores
    public void listarTrabajadores(){
        // 1 obtener todas las claves e iterarlas
        Enumeration<String> claves = listaTrabajadores.keys();

        //                                 v
        //    k    k   k   k   k   k   k   k
        /*while (claves.hasMoreElements()){
            String key = claves.nextElement();
            Trabajador trabajador = listaTrabajadores.get(key);
            trabajador.mostrarDatos();
        }*/

        // 2 obtener todos los valores e iterarlos
        Collection<Trabajador> values = listaTrabajadores.values();
        for ( Trabajador trabajador : values) {
            trabajador.mostrarDatos();
        }
    }

    public Hashtable<String, Trabajador> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public void setListaTrabajadores(Hashtable<String, Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }
}
