package controller;

import database.HibernateUtil;
import model.Alumno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DAOAlumno {

    // operaciones sobre la bd y el modelo que la representan
    private SessionFactory sessionFactory;

    public DAOAlumno(){
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void insertarAlumno(Alumno alumno){
        // session
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        // persit, list, update, delete, HQL
        session.persist(alumno);
        // commit
        session.getTransaction().commit();
        // close
        session.close();

        // nombre, apellido, correo, telefono, provincia, localidad
    }

    public void borrarAlumno(int id){
        // session
        // persit, list, update, delete, HQL
        // commit
        // close
    }


}
