import dao.EmpleadoDAOImp;
import model.Direccion;
import model.Empleado;

public class MainDAO {

    public static void main(String[] args) {
        EmpleadoDAOImp empleadoDAOImp = new EmpleadoDAOImp();
        /*empleadoDAOImp.insertarUsuario(new Empleado("Marta", "Martin", "marta@gmail.com", 30000,
                new Direccion("Barcelona", "Barcelona", "C/Madrid"), "marketing"));*/
        // empleadoDAOImp.borrarUsuario(5);
        // empleadoDAOImp.actualizarUsuario(2,"C/Barcelona");
        // empleadoDAOImp.seleccionUsuario(3);
        // empleadoDAOImp.seleccionAll();
        /*System.out.println("Sacando los empleados de madrid");
        empleadoDAOImp.selectByProvincia("Madrid");
        System.out.println("Sacando los empleados de barcelona");
        empleadoDAOImp.selectByProvincia("Barcelona");*/
        // empleadoDAOImp.selectByLocalidad("Pozuelo");
        empleadoDAOImp.actualizarUsuario("Borja","Valencia");
    }
}
