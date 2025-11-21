import controller.EmpresaController;
import database.DBConnection;
import model.Usuario;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        EmpresaController empresaController = new EmpresaController();
        //empresaController.darAltaUsuario(new Usuario("Borja","borja@ue.com",123,1));
        empresaController.buscarUsuario();
    }
}
