import model.Trabajador;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtils;

public class Entrada {

    public static void main(String[] args) {


        for (int i = 0; i < 4; i++) {
            Trabajador trabajador = new Trabajador("Borja", "Martin", "correo@ue.com", 123123);
        /*
        SessionFactory
        Session -> permite transaccionar contra la base de datos
        beginTransaction
        accion
        commit
         */

            SessionFactory sessionFactory = new HibernateUtils().getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.persist(new Trabajador("Borja" , "Martin","borja@ue.com",123));
            session.getTransaction().commit();
        }

    }
}
