import dao.TrabajadorDAO;
import model.Direccion;
import model.Trabajador;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import utils.HibernateUtils;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {

        // pedir datos al usuario y guardar el usuario en bd, pero si hay un fallo de correo, volver a intentarlo con otros datos
        TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
        /*Scanner scanner = new Scanner(System.in);
        String correo;
        boolean fallo = false;
        do{
            try {
                System.out.println("Introduce correo");
                correo = scanner.next();
                trabajadorDAO.insertarTrabajador(new Trabajador("Borja","MArtin",correo,123));
                fallo = false;
            } catch (ConstraintViolationException e) {
                System.out.println("Correo duplicado, por favor intentalo de nuevo");
                fallo = true;
            }
        }while (fallo);

        System.out.println("Agregado correctamente");*/
        // trabajadorDAO.obtenerUsuario(7);
        // trabajadorDAO.actualizarUsuario(6);
        // trabajadorDAO.borrarUsuario(6);
        //trabajadorDAO.insertarTrabajador(new Trabajador("Borja2", "Martin2", "correo2@ue.es", 123,
        //        new Direccion("Villaviciosa", "Madrid")));
        // trabajadorDAO.obtenerTodosTrabajadores();
        // trabajadorDAO.obtenerTodosTrabajadoresNamed();
        trabajadorDAO.obtenerTrabajadoresLocalidad("Villaviciosa");

    }
}
