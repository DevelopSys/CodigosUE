import database.Conexion;
import database.SchemeDB;
import model.Usuario;

import java.sql.*;
import java.util.ArrayList;

public class EntradaBaseDatos {

    public static void main(String[] args) {

        Connection connection = new Conexion().getConnection();
        // insertar alumnnos --> statement
        Statement st = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            /*st = connection.createStatement();
            String queryTemplate = "INSERT into %s (%s,%s,%s) VALUES ('%s','%s','%s')";
            int rows = st.executeUpdate(String.format(queryTemplate, SchemeDB.NOMBRE_TABLA,
                    SchemeDB.COL_NOMBRE,SchemeDB.COL_APELLIDO,SchemeDB.COL_CORREO,
                    "Borja","Martin","bmartin@correo"));
            if (rows>0){
                System.out.println("Inserción correcta");
                System.out.println(rows);
            }*/
            /*String queryTemplate = "INSERT into %s (%s,%s,%s) VALUES (?,?,?)";
            ps = connection.prepareStatement(String.format(queryTemplate,SchemeDB.NOMBRE_TABLA,
                    SchemeDB.COL_NOMBRE,SchemeDB.COL_APELLIDO,SchemeDB.COL_CORREO));
            ps.setString(1,"Juan");
            ps.setString(2,"Martin");
            ps.setString(3,"correo@correo.com");
            int rows = ps.executeUpdate();
            if (rows>0){
                System.out.println("Inserción correcta");
                System.out.println(rows);
            }*/

            final ArrayList<Usuario> listaUsuarios = new ArrayList<>();

            rs = st.executeQuery("SELECT * FROM "+SchemeDB.NOMBRE_TABLA);
            // [e1 , e2 , e3]
            while (rs.next()){
                String nombre = rs.getString(SchemeDB.COL_NOMBRE);
                String apellido = rs.getString(SchemeDB.COL_APELLIDO);
                String correo = rs.getString(SchemeDB.COL_CORREO);
                Usuario usuario = new Usuario(nombre,apellido,correo);
                listaUsuarios.add(usuario);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ps.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
