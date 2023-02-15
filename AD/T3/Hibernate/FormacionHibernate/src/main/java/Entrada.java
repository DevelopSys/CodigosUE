
import database.HibernateUtil;
import model.Alumno;
import org.hibernate.Session;


public class Entrada {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(new Alumno("Ejemplo","Ejemplo","correo@correo.com")); // db);
        session.getTransaction().commit();
        session.close();

    }

}
