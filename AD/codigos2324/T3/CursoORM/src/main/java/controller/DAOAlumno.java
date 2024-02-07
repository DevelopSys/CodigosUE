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


    // CREATE
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
    public void getAlumnos() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        // query = select * from alumnos -> NativeQuery
        // select a from Alumno a
        // from Alumno a
        // Query

        Query<Alumno> query = session.createQuery("select a from Alumno a", Alumno.class);
        List<Alumno> listado = query.list();
        for (Alumno item : listado) {
            System.out.println(item.getNombre());
        }


        session.beginTransaction().commit();
        session.close();
    }

    // endpoint https://www.miapi.com/users/get
    public void getAlumno(String nombre, int i) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        // SELECT * FROM alumnos where nombre='XX' and id=X
        //String.format("SELECT * FROM alumnos where nombre='%s' and id=%d",asdasdasda);
        // HQL
        // arg posicionales -> ?
        // arg nominales -> :tag
        //String.format("select a from Alumno a WHERE nombre=%s AND id =%d",nombre,i); // Statement
        Query<Alumno> query =
                session.createQuery("select a.nombre, a.curso from Alumno a WHERE nombre=:nombre AND id =:id", Alumno.class)
                .setParameter("nombre",nombre)
                .setParameter("id",i);
                //.setParameter(1, nombre)
                //.setParameter(2,i); // prepareStatment

        //List<Alumno> lista = query.list();
        //lista.get(0);
        Alumno alumno = query.uniqueResult();
        if (alumno!=null){
            // hay resultado
        } else {
            // no hay resultado
        }
        //Query<Alumno> query = session.createQuery("select a from Alumno a WHERE nombre= AND id =",Alumno.class);
    }

    // app srv(jpa) bd

    // endpoint https://www.miapi.com/users/remove
    public void borrarAlumno(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        // session
        // persit, list, update, delete, HQL

        Query query = session.createQuery("delete from Alumno a WHERE a.id=:id", Alumno.class)
                .setParameter("id",id);
        query.executeUpdate();

        session.beginTransaction().commit();
        session.close();

        // commit
        // close
    }
    // endpoint https://www.miapi.com/users/update
    public void actualizarAlumno(int id, String nombre) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        // session
        // persit, list, update, delete, HQL

        Query query = session.createQuery("update Alumno a set a.nombre=:nombre WHERE a.id=:id", Alumno.class)
                .setParameter("nombre",nombre)
                .setParameter("id",id);
        query.executeUpdate();

        session.beginTransaction().commit();
        session.close();

        // commit
        // close
    }

    public void removeIdNamed(){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Query query = session.createNamedQuery("removeById").setParameter("id",1);
        query.executeUpdate();

        session.beginTransaction().commit();
        session.close();
    }

    public void getAllNamed(){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Query<Alumno> query = session.createNamedQuery("getAll", Alumno.class);
        List<Alumno> lista = query.list();

        for (Alumno item : lista) {
            System.out.println(item.getNombre());
        }

        session.beginTransaction().commit();
        session.close();
    }


}
