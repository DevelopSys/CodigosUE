import model.Usuario;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        /*ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario());
        usuarios.get(9); // obtiene el elemento de la posicion 9
        usuarios.remove(9); // borra el elemento de la posicion 9
        Usuario[] usuariosArray = new Usuario[8];
        Usuario encontrado = usuariosArray[6]; // obtiene el elemento de la posicion 6
        usuariosArray[6] = new Usuario();// cambia el elemento de la posicion 6 al que se le indique*/
        

        HashMap<String, Usuario> mapaUsuarios = null;
        // agregar elementos

        String nombre;
        String apellido;
        String dni;
        String correo;

        mapaUsuarios.put("1234A", new Usuario("Borja", "Martin", "1234A", "borja@gmail.com"));
        mapaUsuarios.put("2345B", new Usuario("Marta", "Gomez", "2345B", "marta@gmail.eu"));
        if (mapaUsuarios.containsKey("2345B")) {
            // la clave esta dentro de la lista
            System.out.println("El usuario no se puede agregar");
        } else {
            // la clave no esta dentro de la lista
            mapaUsuarios.put("2345B", new Usuario("Luis", "Gomez", "2345B", "marta@gmail.com"));
        }
        // pbtener elementos
        Usuario usuarioEncotrado = mapaUsuarios.get("1234A");
        if (usuarioEncotrado == null) {
            System.out.println("No se encuentra la clave asociada");
        } else {
            System.out.println("El nombre del usuario encontrado es " + usuarioEncotrado.getNombre());
            System.out.println("El dni del usuario encontrado es " + usuarioEncotrado.getDni());
        }

        // borrar elementos
        Usuario usuarioBorrado = mapaUsuarios.remove("1234A");
        if (usuarioBorrado != null) {
            System.out.println("Usuario borrado con exito con nombre " + usuarioBorrado.getNombre());
        } else {
            System.out.println("La clave no se encuentra, error en el proceso");
        }

        mapaUsuarios.put("1234A", new Usuario("Borja", "Martin", "1234A", "borja@gmail.es"));
        mapaUsuarios.put("4567A", new Usuario("Maria", "Martin", "4567A", "maria@gmail.com"));
        mapaUsuarios.put("5678A", new Usuario("Juan", "Gomez", "5678A", "juan@gmail.com"));

        System.out.println("El tamaño actual de la lista es de " + mapaUsuarios.size());

        // al no ser indexado no puedes recorrer por posiciones
        // recorres las claves
        /*Set<String> keys = mapaUsuarios.keySet();
        for (String item: keys) {
            if (item.charAt(item.length()-1) == 'A'){
                Usuario usuario = mapaUsuarios.get(item);
                usuario.mostrarDatos();
            }

        }*/
        // recorres los valores
        for (Usuario item : mapaUsuarios.values()) {
            if (item.getCorreo().contains("gmail.com")) {
                item.mostrarDatos();
            }
        }

    }
}
