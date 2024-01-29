package controller;

import database.HibernateUtil;
import model.Curso;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Currency;

public class DAOCurso {

    private SessionFactory sessionFactory;

    public DAOCurso(){
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void insertarCurso(Curso curso){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(curso);
        session.getTransaction().commit();
        session.close();
    }
}
