package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Sigleton

    private Connection connection = null;

    // abre la conexion
    private void newConnection(){
        String nombre="root";
        String pass="";
        // "jdbc:mysql://127.0.0.1/"+SchemeDB.DB_NOMBRE+"/?user="+nombre+"&pass="+pass
        String urlTemplate = "jdbc:mysql://127.0.0.1:3306/%s";
        String url = String.format(urlTemplate,SchemeDB.DB_NOMBRE,nombre,pass);

        try {
            // cargar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,nombre,pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    // cierra la conexion

    public void closeConnection(){

        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
    // obtiene la conexion

    public Connection getConnection(){

        // si es nula --> creo
        if (connection == null){
            newConnection();
        }

        return connection;
    }

}
