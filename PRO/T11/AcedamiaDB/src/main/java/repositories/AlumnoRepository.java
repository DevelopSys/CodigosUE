package repositories;

import database.DBConnection;
import model.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AlumnoRepository {

    // tener todas las acciones CRUD que necesito del modelo Alumno

    // INSERT - SELECT - UPDATE - DELETE -> CONNECTION!!!!!
    private Connection connection;

    public void insertarAlumno(Alumno alumno) {
        // abrir la conexion
        connection = DBConnection.getConnection();
        // trabajar con la conexion
        // INSERT INTO alumnos (nombre, apellido, correo, telefono)
        // VALUES ('borja','martin','correo',1234)
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        try {
            /*statement = connection.createStatement();
            String query = "INSERT INTO alumnos (nombre,apellido,correo,telefono) VALUES ('"+alumno.getNombre()+"','"
                    +alumno.getApellido()+"','"+alumno.getCorreo()+"',"+alumno.getTelefono()+")";
            statement.execute(query);
            statement.close();*/
            String query = "INSERT INTO alumnos (nombre,apellido,correo,telefono) VALUES (?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,alumno.getNombre());
            preparedStatement.setString(2,alumno.getApellido());
            preparedStatement.setString(3,alumno.getCorreo());
            preparedStatement.setInt(4,alumno.getTelefono());
            preparedStatement.execute();
            preparedStatement.close();


        } catch (SQLException e) {
            System.out.println("Fallo en la sentencia SQL");
        }


        // cerrar la conexion
        DBConnection.closeConnection();
    }

    // delete
    // update

}
