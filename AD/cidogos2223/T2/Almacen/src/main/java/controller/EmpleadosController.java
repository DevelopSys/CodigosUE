package controller;

import database.DBConnection;
import database.SchemaBD;
import model.User;

import java.sql.*;

public class EmpleadosController {

    private Connection connectionDB;

    public void addEmpleado(User usuario){
        connectionDB = DBConnection.getConnection();
        try {
            Statement statement = connectionDB.createStatement();
            statement.execute(String.format("INSERT INTO %s (%s,%s,%s) VALUES ('%s','%s','%s')",
                    SchemaBD.TAB_EMPLEADOS,
                    SchemaBD.COL_NOMBRE,SchemaBD.COL_APELLIDO, SchemaBD.COL_CORREO,
                    usuario.getName(),usuario.getSurname(), usuario.getEmail()));
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void getEmpleados(){
        connectionDB = DBConnection.getConnection();
        try {
            ResultSet resultSet = connectionDB.createStatement().executeQuery("SELECT * FROM "+SchemaBD.TAB_EMPLEADOS);
            while (resultSet.next()){
                String nombre = resultSet.getString(SchemaBD.COL_NOMBRE);
                String apellido = resultSet.getString(SchemaBD.COL_APELLIDO);
                String email = resultSet.getString(SchemaBD.COL_CORREO);
                User user = new User(nombre,apellido,email);
                user.mostrarDatos();
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getIdEmpleado(){

        // Resultset
        return 1;

    }
}
