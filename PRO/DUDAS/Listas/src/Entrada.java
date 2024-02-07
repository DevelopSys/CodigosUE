import model.Agenda;
import model.Usuario;

import java.util.ArrayList;
import java.util.Arrays;

public class Entrada {

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Usuario usuario1 = new Usuario("Borja1","Martin","1234A","bmartin@gmail.com",123,23);
        Usuario usuario2 = new Usuario("Borja2","Martin","1234B","bmartin@gmail.com",123,21);
        Usuario usuario3 = new Usuario("Borja3","Martin","1234C","bmartin@gmail.com",123,46);
        Usuario usuario4 = new Usuario("Borja4","Martin","1234D","bmartin@gmail.com",123,12);
        agenda.agregarUsuario(usuario1);
        agenda.agregarUsuario(usuario2);
        agenda.agregarUsuario(usuario3);
        agenda.agregarUsuario(usuario4);

        agenda.mostrarOrdenada();


        agenda.buscarUsuario("1234J");
        agenda.buscarUsuario("1234A");


        // List [u1,u3,u4]
        ArrayList<Usuario> lista = new ArrayList(); // []
        // añadir
        lista.add(usuario1); // [u1]
        lista.add(usuario3); // [u1,u3]
        lista.add(usuario4); // [u1,u3]
        lista.add(usuario2); // [u1,u3,u4,u2]
        //lista.add(usuario5); // [u1,u3,u4,u2]
        // borrar
        //lista.remove(0); // [u1,u3,u2]
        //lista.remove(new Usuario("asdasd","2123123","asdasd","123",123)); // [u1,u3,u2]
        // obtener
        //System.out.println(lista.get(lista.size()-1).getNombre());
        for ( Usuario usuario: lista ) {
            System.out.println(usuario.getNombre());
        }

        Usuario usuario5 = new Usuario("Borja5","Martin","1234D","bmartin@gmail.com",123,123);
        usuario5.setDni("1234E");
        boolean existe = false;
        for (Usuario usuario: lista) {
            if (usuario.getDni().equals(usuario5.getDni())){
                existe = true;
                break;
            }
        }

        if (existe){
            System.out.println("No se puede agregar porque el usuario ya existe");
        } else {
            lista.add(usuario5);
            System.out.println("Agregado con exito");
        }


        // no puedo añadir usuario con el mismo dni

    }
}
