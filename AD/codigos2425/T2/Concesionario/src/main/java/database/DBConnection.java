package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    // se pueda crear la conexion -> solo la primera vez

    // pedir conexion -> tantas como veces me pida -> te paso la que ya existe
    public Connection getConnection(){

        // la primera vez la creas
        if (connection == null){
           createConnection();
        }

        return connection;
    }

    private void createConnection(){
        // protocolo de conexion jdbc:mysql
        // host 127.0.0.1
        // database concesionario_ue
        String url = "jdbc:mysql://127.0.0.1/concesionario_ue";
        try {
            connection = DriverManager.getConnection(url,"root","");
            System.out.println("Conexion creada con exito");
        } catch (SQLException e) {
            System.out.println("Error en la conexion al servior de BD");
        }
    }

}
