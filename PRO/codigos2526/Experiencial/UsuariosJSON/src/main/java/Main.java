import org.json.JSONArray;
import org.json.JSONObject;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .GET()
                .uri(URI.create("https://randomuser.me/api/?results=50"))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            JSONObject jsonObject = new JSONObject(body);
            JSONArray arrayResults = jsonObject.getJSONArray("results");
            for (int i = 0; i < arrayResults.length(); i++) {
                JSONObject user = arrayResults.getJSONObject(i);
                String correo = user.getString("email");
                String telefono = user.getString("phone");
                String nombre = user.getJSONObject("name").getString("first");
                String apellido = user.getJSONObject("name").getString("last");
                System.out.println(nombre + " "+apellido+ " "+telefono+ " "+correo);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
