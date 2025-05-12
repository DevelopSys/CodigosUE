import database.DBConnection;

import java.sql.*;

public class Entrada {

    
    public static void main(String[] args) {
        Connection connection = DBConnection.getConnection();
        System.out.println("Ejercicio de conexion a datos");


        // insercion
        try {
            // String query = String.format("INSERT INTO usuarios (correo, password, nombre) VALUES (?,?,?)","usuarios","correo","password","nombre");
            String query = "INSERT INTO usuarios (correo, password, nombre) VALUES (?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "correops@gmail.com");
            preparedStatement.setString(2, "passwordps");
            preparedStatement.setString(3, "usuariops");
            // Statement statement = connection.createStatement();
            // String query = String.format("INSERT INTO %s (%s, %s, %s) VALUES ('%s','%s','%s')","usuarios","correo","password","nombre","correo@gmail.com","pass1234","pruebaborja");
            // boolean resultadoFallo = statement.execute(query);
            int resultadoFallo = preparedStatement.executeUpdate(query);
            System.out.println(resultadoFallo);

        } catch (SQLException e) {
            System.out.println("error en la ejecucion del statement");
            System.out.println(e.getMessage());
        }

        /*
        String query = String.format("SELECT * FROM %s WHERE %s > ?", "usuarios","sueldo");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,5000);
            ResultSet resultSet = preparedStatement.executeQuery();

            //   v
            //   r r r
            while (resultSet.next()){
                String nombre = resultSet.getString("nombre");
                int sueldo = resultSet.getInt("sueldo");
                System.out.println("El nombre "+nombre +" sueldo "+sueldo);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
    }
}
