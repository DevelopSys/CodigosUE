package controller;

import dao.HabitacionDAO;
import dao.TrabajadorDAO;
import model.Habitacion;
import model.Trabajador;

public class HotelController {

    // LOGICA DEL NEGOCIO
    private HabitacionDAO habitacionDAO;
    private TrabajadorDAO trabajadorDAO;

    public HotelController(){
        habitacionDAO = new HabitacionDAO();
        trabajadorDAO = new TrabajadorDAO();
    }

    public void asignarTrabajorHabitacion(int idTrabajador, int capacidadHabitacion){
        // saco la habitacion -> habitacion
        Habitacion habitacion = habitacionDAO.getHabitacionCapacidad(capacidadHabitacion);
        if (habitacion!=null){
            System.out.println("Perfecto, tenemos habitacion");
            // saco el trabajador -> trabajador
            Trabajador trabajador = trabajadorDAO.obtenerUsuario(idTrabajador);
            if (trabajador!=null){
                System.out.println("Perfecto, tenemos trabajador. Vamos a asignar");
                trabajador.setHabitacion(habitacion);
                trabajadorDAO.actualizarUsuario(trabajador);
            } else {
                System.out.println("Mira el id porque no tengo ningun rabajado con ese id");
            }

        } else {
            System.out.println("No hay habitacion con esa capacidad");
        }
        // modifico el trabajado con la habitacion -> trabajador
    }
    public void despedirTrabajador(int idTrabajador){

        // mandar un correo
        // generar documentacion
        trabajadorDAO.borrarUsuario(idTrabajador);
    }
}
