package controller;

import database.HibernateUtil;
import model.Alumno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class DAOAlumno {

    // operaciones sobre la bd y el modelo que la representan
    private SessionFactory sessionFactory;

    public DAOAlumno() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void insertarAlumno(Alumno alumno) {
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

    public void borrarAlumno(int id) {
        // session
        // persit, list, update, delete, HQL
        // commit
        // close
    }

    public void getAlumnos() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Alumno> query = session.createQuery("Select a from Alumno a", Alumno.class);
        List<Alumno> listado = query.list();
        for (Alumno item : listado) {
            System.out.println(item.getNombre());
        }
    }

    public void getAlumnos(String nombre) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //Query<Alumno> query = session.createQuery("Select a from Alumno a WHERE a.nombre = '"+nombre+"' ", Alumno.class);
        /*Query<Alumno> query = session.createNativeQuery("Select * from alumnos WHERE nombre = :nombre ",
                Alumno.class).setParameter("nombre", nombre);*/
        Query<Alumno> qery = session.createQuery("Select a from Alumno a WHERE a.nombre = :nombre ",
                Alumno.class).setParameter("nombre", nombre);
        Alumno alumno = query.uniqueResult();
        System.out.println(alumno.getNombre());
    }

    public void getNamedAlumnos(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Alumno> lista = session.createNamedQuery("alumno.getAll", Alumno.class).list();
        session.getTransaction().commit();
        session.close();
    }

}
