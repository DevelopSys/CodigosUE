import controller.EmpleadosController;
import controller.ProductosController;

public class Entrada {

    public static void main(String[] args) {
        ProductosController productosController = new ProductosController();
        EmpleadosController empleadosController = new EmpleadosController();
        //productosController.importarPedidos();
        //empleadosController.addEmpleado(new User("Borja1","Martin1","coreo1@gmail.com"));
        //empleadosController.addEmpleado(new User("Borja2","Martin2","coreo2@gmail.com"));
        //empleadosController.addEmpleado(new User("Borja3","Martin3","coreo3@gmail.com"));
        empleadosController.getEmpleados();
        productosController.getProductos();

        productosController.marcarFav(empleadosController.getIdEmpleado());

    }

}
