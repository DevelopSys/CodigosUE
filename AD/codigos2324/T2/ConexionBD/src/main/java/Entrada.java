import database.GestionDB;
import database.SchemeDB;

import java.sql.*;

public class Entrada {

    public static void main(String[] args) {

       // conexion -->
        Statement statement;
        PreparedStatement preparedStatement;
        Connection connection = GestionDB.getConnection();

        // Statement -> configuro query y se la doy al motor (posible fallo en el motor)
        // PrapareStatement -> configuro query y la seteo y se la doy al motor (sin fallo en el motor)
        // ResultSet -> lecturas, conjunto de resultados -> St o Ps

        // CUD

        try {
            String nombrePoducto = "telefono";
            int precio = 123;
            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement(String.format("INSERT INTO %s (%s,%s) VALUE (?,?)", SchemeDB.TAB_NAME,
                    SchemeDB.COL_NAME, SchemeDB.COL_PRICE));
            preparedStatement.setString(1,nombrePoducto);
            preparedStatement.setInt(2,precio);
            preparedStatement.executeUpdate();

            // INSERT INTO producto (nombre, precio) VALUE ('telefono', 127)
            // String query = "INSERT INTO"+ %s +"("+%s"+,"+%s+") VALUE ('"+%s+"',"+%d+")";
            // execute -> boolean
            // executeUpdate -> int


            int rows = statement.executeUpdate(String.format("INSERT INTO %s (%s,%s) VALUE ('%s',%d)", SchemeDB.TAB_NAME,
                    SchemeDB.COL_NAME, SchemeDB.COL_PRICE,
                    nombrePoducto,precio));
            statement.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // añadir
        // modificar
        // borrar




        // seleccionar
        // SELECT * FROM producto
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM "+SchemeDB.TAB_NAME); // -> conjunto de resultados
            // [(1,"iphone",123),(2,"camisa",231)]
            while (resultSet.next()){
                // (1,"iphone",123)
                String nombre = resultSet.getString(SchemeDB.COL_NAME);
                int precio = resultSet.getInt(SchemeDB.COL_PRICE);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //R
    }
}
