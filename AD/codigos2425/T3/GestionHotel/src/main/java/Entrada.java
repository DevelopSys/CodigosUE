import dao.TrabajadorDAO;
import model.Cliente;
import model.Direccion;
import model.Habitacion;
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
        // trabajadorDAO.obtenerTrabajadoresLocalidad("Villaviciosa");
        Session session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        /*Trabajador trabajador = session.get(Trabajador.class,12);
        if (trabajador!=null){
            System.out.println("Su nombre es "+trabajador.getNombre());
            System.out.println("Su habitacion es "+trabajador.getHabitacion().getNumero());
        }
        Habitacion habitacion = session.get(Habitacion.class,2);
        if (habitacion!=null){
            Trabajador trabajador = habitacion.getTrabajador();
            System.out.println("El nombre del trabajador que esta ubicado en esta habitacion es "+trabajador.getNombre());
        }*/
        /*Cliente cliente = session.get(Cliente.class,3);
        if (cliente !=null){
            Habitacion habitacion = cliente.getHabitacion();
            System.out.println("La habitacion donde se aloja en cliente 2 es la "+habitacion.getNumero());
        }*/
        /*Habitacion habitacion = session.get(Habitacion.class,2);
        System.out.println("Los clientes alojados en esta habitacion son");
        for ( Cliente cliente : habitacion.getClientes() ) {
            System.out.println(cliente.getNombre());
        }*/
        /*Cliente cliente = session.get(Cliente.class,2);
        System.out.println("Los trabajadores que han gestionado la reserva del cliente 2 son:");
        for (Trabajador trabajador: cliente.getListaTrabajadores()) {
            System.out.println(trabajador.getNombre());
        }*/
        Cliente cliente = session.get(Cliente.class,1);
        Trabajador trabajador = session.get(Trabajador.class,11);

        cliente.getListaTrabajadores().add(trabajador);
        trabajador.getListaClientes().add(cliente);

        session.merge(cliente);
        // session.merge(trabajador);

        session.getTransaction().commit();
        session.close();



    }
}
