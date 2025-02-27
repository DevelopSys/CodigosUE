import controller.Empresa;
import model.Trabajador;

public class Entrada {

    public static void main(String[] args) {

        Empresa empresa = new Empresa("UE");
        empresa.mostrarTrabajadores();
        // trabajadores : 0 []
        empresa.contratarTrabajador(new Trabajador("Borja", "Martin", "correo@gmail.com", "1234A", 123));
        empresa.contratarTrabajador(new Trabajador("Borja", "Martin", "correo@gmail.com", "1234A", 123));
        empresa.contratarTrabajador(new Trabajador("Borja", "Martin", "correo@gmail.com", "1234A", 123));
        empresa.contratarTrabajador(new Trabajador("Borja4", "Martin", "correo@gmail.com", "1234B", 123));
        empresa.mostrarTrabajadores();
        // empresa.despedirTrabajador();
        // empresa.obtenerTrabajador();
        // empresa.despedirTrabajador("1234A");
        // empresa.despedirTrabajadorNombre("Borja");
        // empresa.mostrarTrabajadores();
        //empresa.obtenerTrabajador("1234C");
        // empresa.obtenerTrabajador("1234B");
        empresa.despedirTodos();
        empresa.mostrarTrabajadores();

    }
}
