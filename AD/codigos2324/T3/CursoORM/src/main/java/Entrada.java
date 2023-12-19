import database.HibernateUtil;
import model.Alumno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Entrada {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        // sesion
        Session session = sessionFactory.getCurrentSession();
        // activar la transacion
        session.beginTransaction();
        // trascient -> el objeto está creado en java pero no en bd
        Alumno alumno = new Alumno("Borja","Martin","corre@gmail.com",123123);

        session.persist(alumno);
        session.getTransaction().commit();
        session.close();

    }
}
