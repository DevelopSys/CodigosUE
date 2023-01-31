import database.Conexion;
import database.SchemeDB;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Entrada {

    public static void main(String[] args) {

        Connection conexionDB = new Conexion().getConnection();
        Statement statement = null;

        try {
            URL url = new URL("https://dummyjson.com/products");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            JSONObject respuestaJSON = new JSONObject(reader.readLine());
            JSONArray respuestaProductos = respuestaJSON.getJSONArray("products");
            for ( Object item : respuestaProductos ) {

                int precio = ((JSONObject)item).getInt("price");

                    String nombre = ((JSONObject)item).getString("title");
                    String descripcion = ((JSONObject)item).getString("category");
                    System.out.printf("nombre %s descripcion %s%n",nombre,descripcion);

                    try {
                        statement = conexionDB.createStatement();
                        String queryTemplate = "INSERT INTO %s (%s, %s, %s) VALUES ('%s', '%s', %d)";
                        // INSER INTO alumnos (nombre, apellidos, correo) VALUES (Borja, Martin, bmartin@correo)
                        statement.executeUpdate(String.format(queryTemplate, SchemeDB.NOMBRE_TABLA_PRO,
                                SchemeDB.COL_NOMBRE,SchemeDB.COL_DESC,SchemeDB.COL_PRECIO,
                                nombre,descripcion,precio));

                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
            }
            //System.out.println(respuestaJSON);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
