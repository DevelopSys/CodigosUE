package ejercicio3;

import java.util.ArrayList;
import java.util.Arrays;

public class Sistema {

    private ArrayList<Usuario> listaUsuarios;

    public Sistema() {

        listaUsuarios = new ArrayList<>();
    }

    public void darAltaUsuario(Usuario usuario){
        listaUsuarios.add(usuario);
    }

    public Usuario loginUsuario(String correo, String pass){

        for ( Usuario usuario : listaUsuarios ) {
            if (usuario.getCorreo().equalsIgnoreCase(correo) && usuario.getPass().equalsIgnoreCase(pass)){
                return usuario;
            }
        }

        return null;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}
