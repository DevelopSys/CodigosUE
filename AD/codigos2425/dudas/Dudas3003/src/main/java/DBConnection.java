import java.sql.*;

public class DBConnection {

    private static Connection connection;
    public static Connection getConnection(){

        if (connection ==null){
            createConnection();
        }

        return connection;
    }

    private static void createConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hotel_ue","root","");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
