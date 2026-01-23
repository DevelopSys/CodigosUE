package dao;

import model.Empleado;
import model.Habitacion;
import model.Perfil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HabitacionDAOImpl {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public void crearHabitacion(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        Habitacion habitacion = new Habitacion(1,1,1);
        session.persist(habitacion);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    public void getUsuariosPerfil(int id){
        // creo el sfactory
        sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        Perfil perfil = session.find(Perfil.class,id);
        for (Empleado empleado: perfil.getListaEmpleados()) {
            empleado.mostrarDatos();
        }

        transaction.commit();
        session.close();
        sessionFactory.close();

    }

}
