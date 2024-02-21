package model;

import java.util.ArrayList;

public class Agenda {

    private ArrayList<Usuario> listaUsuarios;


    public Agenda(){
        listaUsuarios = new ArrayList<>();
    }

    public void eliminarUsuario(String dni){
        if (estaUsuario(dni)==null){
            System.out.println("No se puede borrar porque no existe");
        } else {
            listaUsuarios.remove(estaUsuario(dni));
            System.out.println("Borrado correctamente");
        }
    }

    public void agregarUsuario(Usuario usuario){
        // solo agrega si el dni del usuario no esta en la lista

        if (estaUsuario(usuario.getDni())==null){
        this.listaUsuarios.add(usuario);
            System.out.println("Usuario con nombre "+usuario.getNombre()+" agregado correctamente");
        } else {
            System.out.println("No se puede agregar, fallo en el proceso");
        }

    }

    // [u1,u2,u3,u4,u5,u6]

    // u3
    private Usuario estaUsuario(String dni){

        for ( Usuario item : listaUsuarios){
            if (item.getDni().equals(dni)){
                return item;
            }
        }

        return null;
    }

    public void mostrarUsuarios(){
        for ( Usuario usuario: listaUsuarios){
            usuario.mostrarDatos();
        }
    }
    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}
