import model.Direccion;
import model.Empleado;
import model.Habitacion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        // INSERT INTO empleados (nombre, apellido, correo, salario) VALUES ('','','',10000)
        Empleado empleado = new Empleado("Borja", "Martin", "borja@gmail.com", 30000,
                new Direccion("Madrid", "Madrid", "C/Madrid"), "becario");
        // empleados
        // nombre
        // apellido
        // correo
        // salario
        // 1-> Creas una session factory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        // 2-> Crea la session
        Session session = sessionFactory.openSession();
        // 3-> EntityManager -> Transaction
        Transaction transaction = session.beginTransaction();
        // 4-> trabaja con la transaccion
        session.persist(empleado);
        // 5-> garantiza la transaccion
        transaction.commit();
        // 6-> cierra flujos de datos
        session.close();
        sessionFactory.close();

        /*sessionFactory = new Configuration().configure().buildSessionFactory();
        // 2-> Crea la session
        session = sessionFactory.openSession();
        // 3-> EntityManager -> Transaction
        transaction = session.beginTransaction();
        // 4-> trabaja con la transaccion
        session.persist(new Habitacion(101,5,1));
        // 5-> garantiza la transaccion
        transaction.commit();
        // 6-> cierra flujos de datos
        session.close();
        sessionFactory.close();*/


    }
}
