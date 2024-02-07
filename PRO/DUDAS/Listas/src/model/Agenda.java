package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;

public class Agenda {

    private ArrayList<Usuario> lista;
    private Hashtable<String, Usuario> listaHash;

    public Agenda() {
        lista = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {

        listaHash.put(usuario.getDni(),usuario);

        if (estaUsuario(usuario.getDni()) != null) {
            System.out.println("No se puede agregar porque el usuario ya existe");
        } else {
            lista.add(usuario);
            System.out.println("Agregado con exito");
        }
    }

    private Usuario estaUsuario(String dni) {
        boolean existe = false;
        for (Usuario item : lista) {
            if (item.getDni().equals(dni)) {
                return item;
            }
        }
        return null;
    }

    public void buscarUsuario(String dni) {
        if (estaUsuario(dni) != null) {
            System.out.println(estaUsuario(dni).getNombre());
        } else {

            System.out.println("no esta en la lista");
        }
    }

    public void mostrarOrdenada() {
        Collections.sort(lista, new Comparator<Usuario>() {
            @Override
            public int compare(Usuario o1, Usuario o2) {
                if (o1.getEdad() > o2.getEdad()) {
                    return -1;
                } else if (o1.getEdad() < o2.getEdad()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        for (Usuario usuario : lista) {
            usuario.mostarDatos();
        }
    }
}
