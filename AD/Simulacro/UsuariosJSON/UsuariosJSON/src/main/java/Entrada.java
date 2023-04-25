import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Entrada {

    public static void main(String[] args) {

        // 1 url
        URL url = null;
        try {
            url = new URL("https://randomuser.me/api/?results=50");
            // 2 la meto en el nav y entre
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // 3 leo la respuesta
            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String linea = null;
            StringBuilder builder = new StringBuilder();
            /*while ((linea = bf.readLine())!=null){
                builder.append(linea);
            }*/
            // 4 saco los dato
            JSONObject respuesta = new JSONObject(bf.readLine());
            JSONArray usuarios = respuesta.getJSONArray("results");
            for (int i = 0; i < usuarios.length(); i++) {
                JSONObject usuario = usuarios.getJSONObject(i);
                String nombre = usuario.getJSONObject("name").getString("first");
                String apellido = usuario.getJSONObject("name").getString("last");
                String pais = usuario.getJSONObject("location").getString("country");
                //String ejemplo = usuario.getJSONObject("location").getJSONObject("coordinates")
                String correo = usuario.getString("email");
                System.out.println(nombre+" "+apellido+" "+pais+" "+correo);
            }
            //System.out.println(respuesta);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
