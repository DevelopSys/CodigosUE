package database;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() {

        if (connection == null) {
            createNewConnection();
        }

        return connection;
    }

    private static void createNewConnection() {
        try {
            connection = DriverManager.getConnection(
                    System.getenv("DB_URL"),
                    System.getenv("DB_USER"),
                    System.getenv("DB_PASS"));
        } catch (SQLException e) {
            System.out.println("Erroe en la conexion con la base de datos");
            System.out.println(e.getMessage());
        }
    }
}
