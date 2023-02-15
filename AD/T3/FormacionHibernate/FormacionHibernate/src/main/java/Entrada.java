
import org.hibernate.Session;


public class Entrada {

    public static void main(String[] args) {
        // jdbc:mysql://127.0.0.1/"+SchemeDB.DB_NOMBRE+"/?user="+nombre+"&pass="+pass

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(new Alumno("Ejemplo","Ejemplo","correo@correo.com")); // db);
        session.getTransaction().commit();
        session.close();

    }

}
