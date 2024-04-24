package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // LA CONEXION A MI BASE DE DATOS !!!!!!!
    static Connection connection = null;
    // configuracion para tener la conexion con la base de datos
    // static: accesible desde todos los sitios de forma directa
    // un elemento que pertenece a la clase, no al objeto

    // crea la conexion
    private static void createConnection(){
        // cargar el driver en memoria
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // abrir la conexion
                // uri -> jdbc:mysql://127.0.0.1/curso_ue
            String uri = "jdbc:mysql://127.0.0.1:3306/curso_ue";
                // abrir la conexion desde una uri, con un usuario que tiene una pass
            connection = DriverManager.getConnection(uri, "root","");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el Driver");
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error en la ejecucion SQL");
            System.out.println(e.getMessage());
        }

    }

    // pide la conexion
    public static Connection getConnection(){

        if (connection == null){
            // crea la conexion
            createConnection();
        }
        return connection;
    }

    // cierra la conexion
    public static void closeConnection(){
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            System.out.println("Error en el cerrado de la base de datos");
        }

    }
}
