package dao;

import model.Cliente;
import model.Empleado;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClienteDAOImpl {
    private Session session;
    private Transaction transaction;

    public void getAllEmpleadosReserva(int id){
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();

        Cliente cliente = session.find(Cliente.class,id);
        /*for ( Empleado e: cliente.getEmpleados() ) {
            e.mostrarDatos();
        }*/
        // p->cuerpo
        // cliente.getEmpleados().forEach(item->item.mostrarDatos());
        cliente.getEmpleados().forEach(Empleado::mostrarDatos);

        // sacar todos los empleados que gestionan las reservas de un cliente
        // cliente -> id -> find -> CLIENTE -> empleados

        transaction.commit();
        session.close();
    }

    public void realizarReservar(int idCliente, int idEmpleado){
        session = new Configuration().configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        Cliente cliente = session.find(Cliente.class,idCliente);
        Empleado empleado = session.find(Empleado.class, idEmpleado);
        cliente.addEmpleado(empleado);
        // save?
        transaction.commit();
        session.close();
    }
}
