import java.sql.*;

public class Entrada {

    public static void main(String[] args) {
        Conexion conexion = new Conexion();


        Connection connection = conexion.getConnection();

        try {
            Statement statement = connection.createStatement();
            // statement.executeUpdate("INSERT into"+ aula +"(nombre,sitios,caracteristicas) VALUES ('aula4',20,array['c1','c2'])");
            ResultSet resultSet = statement.executeQuery("SELECT * from only"+SchemeDB.NOMBRE_TABLA);
            while (resultSet.next()){
                String nombre = resultSet.getString("nombre");
                System.out.println(nombre);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
