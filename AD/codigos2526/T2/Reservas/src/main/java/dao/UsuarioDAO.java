package dao;

import model.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UsuarioDAO {
    // todos los metodos contra la base de datos del usuario
    // metodos abstractos
    void insertarUsuario(Usuario usuario) throws SQLException;
    int eliminarUsuarios(String correo);
    ArrayList<Usuario> listarUsuarios();
    void actualizarUsuario(Usuario usuario, Object[] datos);
}
