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
        BufferedReader br = null;
        try {
            // URL -> https://dummyjson.com/users
            URL url = new URL("https://dummyjson.com/users");
            // HTTPConnection -> abrir la url
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // BufferedReader -> leer la contestacion de la pagina -> TXT
            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lectura = br.readLine();
            // Pasar el txt a JSON
            JSONObject respuesta = new JSONObject(lectura);
            JSONArray usuarios = respuesta.getJSONArray("users");
            for (int i = 0; i < usuarios.length(); i++) {
                JSONObject usuario = usuarios.getJSONObject(i);
                String firstName = usuario.getString("firstName");
                String lastName = usuario.getString("lastName");
                int age = usuario.getInt("age");
                if (age>40){
                    System.out.println(firstName +" "+lastName +" "+age);
                }
            }
            //System.out.println(usuarios);


        } catch (MalformedURLException e) {
            System.out.println("Error en la codificacion de la URL");
        } catch (IOException e) {
            System.out.println("Error de internet");
        }


    }

}
