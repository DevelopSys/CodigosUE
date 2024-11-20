package dao;

import database.DBConnection;
import database.SchemaDB;
import model.Usuario;

import java.sql.*;

public class UsuarioDAO {

    // todas las acciones contra BD -> CreateReadUpdeateDelete
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Statement statement;

    public boolean registrarUsuario(Usuario usuario) throws SQLException {
        // pido aqui los datos????????
        connection = new DBConnection().getConnection();
        //statement = connection.createStatement();
        String query = String.format("INSERT INTO %s (%s, %s, %s, %s, %s) VALUE (?,?,?,?,?)",
                SchemaDB.TAB_USER,
                SchemaDB.COL_NAME, SchemaDB.COL_MAIL, SchemaDB.COL_PASS, SchemaDB.COL_PH, SchemaDB.COL_ID_PER);
        //statement.execute(query);
        //statement.executeUpdate()
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, usuario.getNombre());
        preparedStatement.setString(2, usuario.getCorreo());
        preparedStatement.setString(3, usuario.getPass());
        preparedStatement.setInt(4, usuario.getTelefono());
        preparedStatement.setInt(5, usuario.getIdPerfil());
        // connection.close();
        return preparedStatement.execute();
    }
    public boolean realizarLogin(String correo, String pass) throws SQLException {
        connection = new DBConnection().getConnection();
        preparedStatement = connection.prepareStatement(String.format("SELECT * FROM %s WHERE %s=? AND %s=?", SchemaDB.TAB_USER,
                SchemaDB.COL_MAIL, SchemaDB.COL_PASS));
        preparedStatement.setString(1,correo);
        preparedStatement.setString(2,pass);
        resultSet = preparedStatement.executeQuery();
        // si hay un resultado -> login ok -> true
        // si no hay un resultado -> login no ok -> false
        return resultSet.next();
    }
}
