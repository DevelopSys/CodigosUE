package dao;

import model.Habitacion;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.util.List;

public class HabitacionDAO {

    // todas las operaciones con las habitaciones
    private Session session;

    public Habitacion getHabitacionCapacidad(int capacidad) {
        session = new HibernateUtils().getSessionFactory().openSession();
        session.beginTransaction();
        Query<Habitacion> query = session.createQuery("FROM Habitacion h WHERE h.capacidad = :capacidad");
        query.setParameter("capacidad",capacidad);
        List<Habitacion> listaFiltradaHabitaciones = query.list();
        // FROM Habitacion h WHERE h.capacidad == :capacidad
        // SELECT * FROM habitaciones h WHERE h.nombre_columna == :capacidad
        session.getTransaction().commit();
        session.close();
        if (!listaFiltradaHabitaciones.isEmpty()) {
            return listaFiltradaHabitaciones.getFirst();
        }
        return null;

    }


}
