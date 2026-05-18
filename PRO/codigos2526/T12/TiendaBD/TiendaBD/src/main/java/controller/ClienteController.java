package controller;

import model.Cliente;

import java.sql.*;

public class ClienteController {

    // CRUD contra base de datos
    private Connection connection;

    public ClienteController(){
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://127.0.0.1:3306/productos_ue","root","root");
            System.out.println("Conexion correcta!!!!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Error en conexion");
        }
    }

    public void insertarCliente(Cliente cliente){
        // "INSERT INTO clientes (nombre, correo, pass) VALUES ('cliente.nombre','cliente.correo','cliente.pass')"
        String query = String.format("INSERT INTO %s (%s, %s, %s) VALUES ('%s','%s','%s')",
                "clientes","nombre","correo","password",
                cliente.getNombre(), cliente.getCorreo(), cliente.getPass());
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
            // statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("error en la ejecucion de la query");
        }
    }

    public void borrarCliente(String correo){

        String query = String.format("DELETE FROM %s WHERE %s=?","clientes","correo");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,correo);
            int rows = preparedStatement.executeUpdate();
            System.out.println("El numero de filas borradas es de "+rows);
        } catch (SQLException e) {
            System.out.println("Error en la query");
        }
    }

    public void actualizarCliente(String correo, int id){

    }

    public void obtenerClientes(){
        // "SELECT * FROM clientes WHERE XXX"
        String query = "SELECT * FROM clientes";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String nombre = resultSet.getString("nombre");
                String correo = resultSet.getString("correo");
                String pass = resultSet.getString("password");
                long id = resultSet.getLong("id");
                // System.out.println(id+" "+nombre + " "+correo+" "+pass);
                Cliente cliente = new Cliente(id, nombre, correo, pass);
                cliente.mostrarDatos();
            }
        } catch (SQLException e) {
            System.out.println("Error en la query");
        }
    }
}
