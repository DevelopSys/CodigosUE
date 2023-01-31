import database.SchemeDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class EntradaConnection {

    public static void main(String[] args) {

        // conectar con la BD
        Connection connection = null;
        // statement --> C UD
        // preparestatement --> C UD
        // resulset --> R
        // CRUD

        String nombre = "Borja";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String queryTemplate = "INSER INTO %s (%s, %s, %s) VALUES ('%s', '%s', '%s')";
            // INSER INTO alumnos (nombre, apellidos, correo) VALUES (Borja, Martin, bmartin@correo)
            statement.executeUpdate(String.format(queryTemplate, SchemeDB.NOMBRE_TABLA,
                    SchemeDB.COL_NOMBRE,SchemeDB.COL_APELLIDO,SchemeDB.COL_CORREO,
                    "Borja","Martin","correo@correo"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
