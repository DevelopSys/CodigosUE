package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    // getConnection ->
    public static Connection getConnection(){
        if (connection == null){
           createConnection();
        }
        return connection;
    }

    // createConnection
    private static void createConnection(){
        // uri del servidor y la base de datos
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usuariosdb","root","");
            System.out.println("Conectado a la bd correctamente");
        } catch (SQLException e) {
            System.out.println("Error en la conexion con la base de datos");
            System.out.println(e.getMessage());
        }
    }
}
