import java.sql.*;

public class Entrada {

    public static void main(String[] args) {
        Connection connection = DBConnection.getConnection();
        // creo la query
        String query = "SELECT * FROM usuarios WHERE ciudad = ?";
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            // creo el ps
            ps = connection.prepareStatement(query);
            ps.setString(1,"Valencia");
            // la ejecuto -> statement / pstatement -> INSERT - DELETE - UPDATE
            resultSet = ps.executeQuery();
            while (resultSet.next()) // hay siguiente elemento?
            {
                String correo = resultSet.getString("correo");
                System.out.println(correo);
            }

            System.out.println("Saliendo del while");

            // todos los datos de la query
            // r r r r r r r r r r
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        // guardar el resultadao en un un RESULTSET -> SELECT
    }
}
