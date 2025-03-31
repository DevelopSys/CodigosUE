import controller.Empresa;
import model.Usuario;
import utils.TamanioException;

import java.util.*;

public class Entrada {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Empresa empresa = new Empresa();
        System.out.println("Indica el nombre del usuario");
        String nombre = scanner.next();
        System.out.println("Indica el nombre del apellido");
        String apellido = scanner.next();
        System.out.println("Indica la edad del usuario");
        int edad = scanner.nextInt();
        System.out.println("Indica el correo del usuario");
        String correo = scanner.next();
        try{
            empresa.agregarUsuario(new Usuario(nombre, apellido, correo, edad));
            empresa.agregarUsuario(new Usuario(nombre, apellido, correo, edad));
        } catch (NullPointerException e){
            System.out.println("Error detectado, quieres iniciar la lista");
        } catch (TamanioException e) {
            System.out.println(e.getMessage());
        }

        // empresa.agregarUsuario(new Usuario(nombre, apellido, correo, edad));
        /*ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        // fallo puedo provocar un fallo por mala programacion -> incontrolable -> el compiliador no se lo traga
        try {
            System.out.println("Indica el nombre del usuario");
            String nombre = scanner.next();
            System.out.println("Indica el nombre del apellido");
            String apellido = scanner.next();
            System.out.println("Indica la edad del usuario");
            int edad = scanner.nextInt();
            System.out.println("Indica el correo del usuario");
            String correo = scanner.next();
            Usuario usuario = new Usuario(nombre, apellido, correo, edad);
            listaUsuarios.add(usuario);
            System.out.println("La cantidad de usuarios en la lista es del " + listaUsuarios.size());
            System.out.println("Voy a sacar un usuario cualquiera de la lista");
            Usuario usuarioBusqueda = listaUsuarios.get(0);
            System.out.println("el nombre del usuario encontrado es: "+usuarioBusqueda.getNombre());
            int division = 7/0;
            System.out.println("El resultado de la division es "+division);
        } catch (Exception e){
            System.out.println("Error en el sistema");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }*/

    }
}
