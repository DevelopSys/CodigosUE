package database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestionDB {

    static Connection connection;

    private static void createConnection(){
        try {
            Class.forName("mysql.jdbc.cj.jdbc.Driver");
            //String url = "jdbc:mysql://"+SchemeDB.HOST+"/"+SchemeDB.DB_NAME;
            String url = String.format("jdbc:mysql://%s/%s",SchemeDB.HOST,SchemeDB.DB_NAME) ;
            connection = DriverManager.getConnection(url,"root","");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){

        if (connection == null){
            createConnection();
        }
        // crearla con los parametros
        return connection;
    }



}
