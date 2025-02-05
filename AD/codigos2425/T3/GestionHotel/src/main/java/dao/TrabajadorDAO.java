package dao;

import model.Trabajador;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class TrabajadorDAO {

    private Session session;

    // CREATE
    public void insertarTrabajador(Trabajador trabajador){

        // creo la sesion

        // 1- comprobar en la lista (SELECT) si el correo ya esta en la lista
        // si esta -> error
        // si no esta -> añad
        // 2 - trata la excepcion
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.persist(trabajador);
        transaction.commit();
        session.close();
    }

    // SELECT
    public Trabajador obtenerUsuario(int id) {
        // prepareSt -> executeQuery -> resultSet -> while -> rs.getString("nombre") -> Objeto

        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        //session.beginTransaction();
        Trabajador trabajador = session.get(Trabajador.class, id);
        session.getTransaction().commit();
        session.close();
        if (trabajador != null) {
            return trabajador;
        } return null;
    }

    // UPDATE
    public void actualizarUsuario(int id) {
        // UPDATE usuarios SET correo = nuevo@ue.com AND apellido = apellidoNuevo WHERE id = id
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        // 1. buscar el usuario
        Trabajador trabajador = session.get(Trabajador.class, id);
        //Trabajador trabajador = new Trabajador(6, "NombreMano", "ApellidoMano","correo@mano",1234);

        // 2. cambiar con los setter las propiedades
        if (trabajador != null) {
            trabajador.setNombre("Borja");
            trabajador.setApellido("Martin Herrera");
            trabajador.setCorreo("borja@ue.es");
            session.merge(trabajador);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void actualizarUsuario(Trabajador trabajador) {
        // UPDATE usuarios SET correo = nuevo@ue.com AND apellido = apellidoNuevo WHERE id = id
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.merge(trabajador);

        session.getTransaction().commit();
        session.close();
    }

    // DELETE
    public void borrarUsuario(int id) {
        // DELETE FROM trabajadores WHERE id = 6
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        // session.beginTransaction();
        // 1- busco el trabajador
        Trabajador trabajador = session.get(Trabajador.class, id);
        if (trabajador != null) {
            // 2- borro el trabajador
            session.remove(trabajador);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void obtenerTodosTrabajadores(){
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();

            // prepareST -> resulset -> while -> rs.getString -> creoObject -> List

        Query<Trabajador> query = session.createQuery("FROM Trabajador", Trabajador.class);
        List<Trabajador> lista = query.list();
        for (Trabajador trabajador: lista) {
            System.out.println(trabajador);
        }


        session.getTransaction().commit();
        session.close();
    }

    public void obtenerTodosTrabajadoresNamed(){
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Trabajador> query = session.createNamedQuery("Trabajador.findAll",Trabajador.class);
        List<Trabajador> lista = query.list();
        for (Trabajador t : lista){
            System.out.println(t);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void obtenerTrabajadoresLocalidad(String localidad){
        // ps.setString(1,"aasdasd")
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        //String querySTR = "FROM Trabajador t WHERE t.direccion.localidad=:localidad";
        // Query<Trabajador> query = session.createQuery(querySTR, Trabajador.class);

        Query<Trabajador> query = session.createNamedQuery("Trabajador.findByLocalidad", Trabajador.class);
        query.setParameter("localidad",localidad);

        List<Trabajador> trabajadores = query.list();

        for (Trabajador t: trabajadores ) {
            System.out.println(t);
        }

        session.getTransaction().commit();
        session.close();
    }

    public void modificarTrabajador(String correoOld, String correoNew){
        session = new HibernateUtils().getSessionFactory().openSession();
        session.beginTransaction();
        String query = "FROM Trabajador t WHERE t.correo = :correo";
        Query<Trabajador> trabajadorBusqueda = session.createQuery(query, Trabajador.class);
        trabajadorBusqueda.setParameter("correo",correoOld);
        List<Trabajador> trabajadores  = trabajadorBusqueda.list();
        Trabajador trabajador = trabajadores.get(0);
        trabajador.setCorreo(correoNew);
        session.merge(trabajador);
        // trabajador.get(0);
        session.getTransaction().commit();
        session.close();
    }



}
