import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection connection;

    private void createConnection(){
        String urlPostgres = "jdbc:postgresql://localhost/docencia";
        try {
            connection = DriverManager.getConnection(urlPostgres,"postgres","");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Connection getConnection(){

        if (connection==null){
            createConnection();
        }

        return connection;

    }

}
