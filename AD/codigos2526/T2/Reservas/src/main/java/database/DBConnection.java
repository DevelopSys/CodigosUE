package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    public static Connection getConnection(){
        if (connection==null)
            createConnection();
        return connection;
    }

    private static void createConnection(){
        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/reservas_ue";
        try {
            connection = DriverManager.getConnection(url,user,pass);
        } catch (SQLException e) {
            System.out.println("Fallo en conexion");
            System.out.println(e.getMessage());
        }
        // http://www.marca.com/fcbarcelona
    }

}
