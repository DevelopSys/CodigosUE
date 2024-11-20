import dao.UsuarioDAO;
import model.Usuario;

import java.sql.SQLException;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        System.out.println("Indica el correo");
        String correo = scanner.next();
        System.out.println("Indica la pass");
        String pass = scanner.next();
        try {
            if (usuarioDAO.realizarLogin(correo,pass)){
                System.out.println("Login correcto");
            } else {
                System.out.println("Fallo de credenciales");
            }
        } catch (SQLException e) {
            System.out.println("Error en la ejecucion");
        }

        /*for (int i = 0; i < 2; i++) {
            System.out.println("Dime nombre a introducir");
            String nombre = scanner.next();
            System.out.println("Dime correo a introducir");
            String correo = scanner.next();
            System.out.println("Dime pass a introducir");
            String pass = scanner.next();
            System.out.println("Dime telefono");
            int telenofo = scanner.nextInt();
            System.out.println("Dime id perfil");
            int id = scanner.nextInt();
            try {
                usuarioDAO.registrarUsuario(new Usuario(nombre, correo, pass, telenofo, id));
            } catch (SQLException e) {
                System.out.println("Hay un error en la ejecucion, quieres hacer XXX");
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }*/


    }
}
