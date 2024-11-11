import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Entrada {

    public static void main(String[] args) {
        //agregarCoche("mercedes", "e63 amg",290000);
        //agregarCoche("mercedes", "s63 amg",490000);
        borrarCoche("s63 amg");
        borrarCoche("e63 amg");
    }

    public static void agregarCoche(String marca, String modelo, int precio){
        Connection connection1 = new DBConnection().getConnection();
        // CRUD -> Create, Select, Update, Delete
        // Statatement -> ejecuta una query directa
        // PrepareStatement -> ejecuta una query parametrizada -> INSERT / UPDATE / DELETE
        // Resulset -> ejecuta una query de SELECT
        String query = String.format("INSERT INTO %s (%s,%s,%s) VALUE (?,?,?)"
                , "coches", "marca", "modelo", "precio");
        try {
            PreparedStatement preparedStatement = connection1.prepareStatement(query);
            preparedStatement.setString(1,marca);
            preparedStatement.setString(2,modelo);
            preparedStatement.setInt(3,precio);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("La query esta mal ejecutada");
            System.out.println(e.getMessage());
        }
    }

    public static void borrarCoche(String modelo){
        Connection connection1 = new DBConnection().getConnection();
        // CRUD -> Create, Select, Update, Delete
        // Statatement -> ejecuta una query directa
        // PrepareStatement -> ejecuta una query parametrizada -> INSERT / UPDATE / DELETE
        // Resulset -> ejecuta una query de SELECT
        String query = String.format("DELETE FROM %s WHERE %s=? "
                , "coches",  "modelo");
        try {
            PreparedStatement preparedStatement = connection1.prepareStatement(query);
            preparedStatement.setString(1,modelo);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("La query esta mal ejecutada");
            System.out.println(e.getMessage());
        }
    }
}
