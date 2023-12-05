package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection connection = null;

    public static void newConnection(){
        String url = "jdbc:mysql://127.0.0.1:3306/"+SchemaBD.DB_NAME;
        String user = "root";
        String pass = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,pass);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){

        if (connection==null){
            newConnection();
        }

        return connection;
    }

}
