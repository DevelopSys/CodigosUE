package repositories;

import database.DBConnection;
import database.EsquemaDB;
import model.Alumno;

import java.sql.*;

public class AlumnoRepository {

    // tener todas las acciones CRUD que necesito del modelo Alumno

    // INSERT - SELECT - UPDATE - DELETE -> CONNECTION!!!!!
    private Connection connection;

    // delete
    // update
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

    // select
    public void obtenerAlumnos(){

        // SELECT * FROM alumnos
        // RESULTSET -> el conjunto de datos que se obtienen de una seleccion
        // [R1, R2, R3, R4, R5]
        // R1 -> [id, nombre, apellido, correo, telefono]

        connection = DBConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery("SELECT * FROM alumnos");

            while (resultado.next()){
                // siguiente elemento
                int id = resultado.getInt("id") ;
                String nombre = resultado.getString("nombre") ;
                String apellido = resultado.getString("apellido");
                String correo = resultado.getString("correo");
                int telefono = resultado.getInt("telefono");
                Alumno alumno = new Alumno(nombre, apellido, telefono);
                alumno.mostrarDatos();
                // System.out.println(alumno.getNombre());
            }



        } catch (SQLException e) {
            System.out.println("Error en SQL");
        } finally {
            DBConnection.closeConnection();
            connection = null;
        }


    }

    public boolean estaAlumno(String nombre, String correo){
        // SELECT * FROM alumnos WHERE nombre='nombre' AND correo='correo'
        // String query = "SELECT * FROM alumnos WHERE nombre='"+nombre+"' AND correo='"+correo+"'";
        boolean estaAlumno = false;
        String query = String.format("SELECT * FROM %s WHERE %s='%s' AND %s='%s'",
                EsquemaDB.TAB_ALUMNOS,
                EsquemaDB.COL_NAME,nombre,
                EsquemaDB.COL_MAIL,correo
                );
        connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            // []
            // [R1]

            estaAlumno = resultSet.next();
        } catch (SQLException e) {
            System.out.println("Error SQL");
        } finally {
            DBConnection.closeConnection();
            connection = null;
        }

        // true cuando -> hay usuario que cumpla condicion
        // false cuando -> no hay usuario que cumpla condicion
        return estaAlumno;
    }

    public boolean realizarLogin(String correo, String pass){
        connection = DBConnection.getConnection();
        boolean estaUsuario = false;
        ResultSet resultSet;
        // "SELECT * FROM alumnos WHERE correo = 'correo' AND pass = 'pass'";
        String query = String.format("SELECT * FROM %s WHERE %s=? AND %s=?",
                EsquemaDB.TAB_ALUMNOS,
                EsquemaDB.COL_MAIL,EsquemaDB.COL_PASSWORD);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,correo);
            preparedStatement.setString(2,pass);
            resultSet = preparedStatement.executeQuery();
            estaUsuario = resultSet.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.closeConnection();
            connection = null;
        }

        return estaUsuario;
    }


}
