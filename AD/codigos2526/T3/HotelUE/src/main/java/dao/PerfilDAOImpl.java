package dao;

import model.Empleado;
import model.Perfil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PerfilDAOImpl {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public void crearPerfil(){

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
