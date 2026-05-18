import controller.ClienteController;
import model.Cliente;

public class Main {

    public static void main(String[] args) {
        System.out.println("Ejecuciones sobre base de datos");
        ClienteController controller = new ClienteController();
        // controller.insertarCliente(new Cliente("Borja","borja@gmail.com","123123"));
        // controller.borrarCliente("borja@gmail.com");
        controller.obtenerClientes();

    }
}
