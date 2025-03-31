package controller;

import model.Usuario;
import utils.TamanioException;

import java.util.ArrayList;

public class Empresa {

    private ArrayList<Usuario> listaUsuarios;

    public Empresa() {
        this.listaUsuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) throws NullPointerException, TamanioException {
        if (listaUsuarios.size() > 0) {
            // error
            throw new TamanioException("Error, demasiadas personas");
        } else {
            listaUsuarios.add(usuario);
        }
    }

    public void getUsuario(String nombre) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Usuario encontrado con correo " + usuario.getCorreo());
                break;
            }
        }
    }

}
