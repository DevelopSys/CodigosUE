package controller;

import database.DBConnection;
import model.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CentroEscolar {
    private Connection connection;
    private PreparedStatement preparedStatement;
    // CRUD

    // insertarAlumno
    public void insertarAlumno(Alumno alumno) {
        // lleva el alumno a la base de datos
        connection = DBConnection.getConnection();
        // INSERT INTO alumnos (nombre, correo, telefono) VALUES ('alumno.getNombre','alumno.getCorreo',alumno.getTelefono)
        // %s -> string %d -> int %f double/float
        //
        String query = String.format("INSERT INTO %s (%s,%s,%s) VALUES (?,?,?)",
                "alumnos", "nombre", "correo", "telefono");
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, alumno.getName());
            preparedStatement.setString(2, alumno.getMail());
            preparedStatement.setInt(3, alumno.getPhone());
            preparedStatement.execute();
        } catch (SQLException e) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Error de SQL");
            System.out.println(e.getMessage());
            System.out.println("Indica un correo nuevo");
            String correo = scanner.next();
            alumno.setMail(correo);
            insertarAlumno(alumno);
        }
    }

    // borrarAlumno
    public int borrarAlumno(String name) {
        connection = DBConnection.getConnection();
        String query = String.format("DELETE FROM %s WHERE %s=?", "alumnos", "nombre");
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en SQL");
        }

        return 0;
    }

    // obtenerAlumno
    public void obtenerAlumnos(String name) {
        connection = DBConnection.getConnection();
        String query = "SELECT * FROM alumnos WHERE nombre=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            //   v
            //   1 2 3 4
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String correo = resultSet.getString("correo");
                int telefono = resultSet.getInt("telefono");
                System.out.println(nombre + " " + correo + " " + telefono);
            }

        } catch (SQLException e) {
            System.out.println("Error de SQL");
        }
    }
    // modificarAlumno
}
