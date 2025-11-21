package dao;

import database.DBConnection;
import database.SchemeDB;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioDAOImp implements UsuarioDAO {
    // como se comporta la logica contra la base de datos
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public UsuarioDAOImp() {
        connection = DBConnection.getConnection();
    }

    @Override
    public void insertarUsuario(Usuario usuario) throws SQLException{
        // INSERT INTO usuarios (nombre, mail, telefono, idPerfil) VALUES (usuario.nombre,asd,asd,asd)
        String query = String.format("INSERT INTO %s (%s,%s,%s,%s) VALUES (?,?,?,?)"
                , SchemeDB.TAB_NAME, SchemeDB.COL_NAME, SchemeDB.COL_MAIL, SchemeDB.COL_PHONE, SchemeDB.COL_PROFILE);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,usuario.getNombre());
            preparedStatement.setString(2,usuario.getCorreo());
            preparedStatement.setInt(3,usuario.getTelefono());
            preparedStatement.setInt(4,usuario.getIdPerfil());
            preparedStatement.execute();
    }

    @Override
    public int eliminarUsuarios(String correo) {
        return 0;
    }

    @Override
    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> listaResultante = new ArrayList<>();
        String query = "SELECT * FROM "+ SchemeDB.TAB_NAME;
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String nombre = resultSet.getString(SchemeDB.COL_NAME);
                String correo = resultSet.getString(SchemeDB.COL_MAIL);
                int telefono = resultSet.getInt(SchemeDB.COL_PHONE);
                int perfil = resultSet.getInt(SchemeDB.COL_PROFILE);
                listaResultante.add(new Usuario(nombre,correo,telefono,perfil));
            }
            //    x -> next() -> boolean
            //  d,d,d,d,d,d,d,d,d
        } catch (SQLException e) {
            System.out.println("Fallo en la sentencia sql");
        }
        return listaResultante;
    }

    @Override
    public void actualizarUsuario(Usuario usuario, Object[] datos) {

    }
}
