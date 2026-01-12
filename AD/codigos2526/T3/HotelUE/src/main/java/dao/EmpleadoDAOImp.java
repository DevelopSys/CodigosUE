package dao;

import model.Direccion;
import model.Empleado;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.UnionSubclass;
import org.hibernate.query.Query;

import java.util.List;

public class EmpleadoDAOImp {
    private Session session;
    private Transaction transaction;

    public void insertarUsuario(Empleado empleado) {
        // capa logica de la app
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.persist(empleado);
        transaction.commit();
        session.close();
    }

    // borrar por id
    public void borrarUsuario(int id) {
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        // SELECT FROM empleados WHERE id = id
        Empleado empleado = session.find(Empleado.class, id);
        if (empleado != null) {
            session.remove(empleado);
            System.out.println("Empleado borrado correctamente");
        } else {
            System.out.println("No se puede borrar, el empleado no se encuentra");
        }
        transaction.commit();
        session.close();
    }

    // actualizar por id
    public void actualizarUsuario(int id, String calleNueva) {
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        // SELECT FROM empleados WHERE id = id
        Empleado empleado = session.find(Empleado.class, id);
        if (empleado != null) {
            // Direccion direccion = empleado.getDireccion();
            // direccion.setCalle(calleNueva);
            // empleado.setDireccion(direccion);
            empleado.getDireccion().setCalle(calleNueva);
            System.out.println("Empleado actualizado correctamente");
        } else {
            System.out.println("No se puede borrar, el empleado no se encuentra");
        }
        transaction.commit();
        session.close();
    }

    // select por id
    public void seleccionUsuario(int id) {
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        // SELECT FROM empleados WHERE id = id
        Empleado empleado = session.find(Empleado.class, id);
        empleado.mostrarDatos();
        transaction.commit();
        session.close();
    }

    public void seleccionAll() {
        // SELECT * FROM empleados
        // PS -> RS -> WHILE -> OBJECT -> ARRAYLIST
        // CriteaQuery - MutationQuery (HQL - JPQL) - SQL
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        // SELECT * FROM empleados
        Query<Empleado> query = session.createQuery("FROM Empleado", Empleado.class);
        List<Empleado> listaResultante = query.getResultList();
        for (Empleado item : listaResultante) {
            item.mostrarDatos();
        }
        transaction.commit();
        session.close();


    }

    public void selectByProvincia(String provincia) {
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        Query<Empleado> query = session.createQuery("FROM Empleado e WHERE e.direccion.provincia=:provinciaArgs", Empleado.class);
        query.setParameter("provinciaArgs", provincia);
        List<Empleado> listaResultante = query.getResultList();
        for (Empleado empleado : listaResultante) {
            empleado.mostrarDatos();
        }
        transaction.commit();
        session.close();
    }

    public void selectByLocalidad(String localidad) {
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        Query<Empleado> query = session.createNamedQuery("Empleado.findByLocalidad", Empleado.class);
        query.setParameter("localidadArgs", localidad);
        List<Empleado> listaResultante = query.getResultList();
        for (Empleado empleado : listaResultante) {
            empleado.mostrarDatos();
        }
        transaction.commit();
        session.close();
    }

    public void actualizarUsuario(String nombre, String localidad) {
        Empleado empleado = seleccionarNombre(nombre);
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        empleado.getDireccion().setLocalidad(localidad);
        session.merge(empleado);
        transaction.commit();
        session.close();
    }

    public Empleado seleccionarNombre(String nombre) {
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        Query<Empleado> query = session.createQuery("FROM Empleado e WHERE e.nombre = :nombre ");
        query.setParameter("nombre", nombre);
        Empleado empleado = query.getSingleResult();
        transaction.commit();
        session.close();
        if (empleado != null) {
            return empleado;
        }
        return null;
    }
}
