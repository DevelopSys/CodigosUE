import com.google.gson.Gson;
import model.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) {
        // 1- Httoclient "navegador"
        HttpClient client = HttpClient.newHttpClient();
        // 2- HttpRequest "lo que pides"
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://randomuser.me/api/?results=50"))
                .GET()
                .build();
        // 3. HttpResponse "abre el navegador y pide lo que quieras"
        try {
            Gson gson = new Gson();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String reponseJSON = response.body();
            JSONObject jsonObject = new JSONObject(reponseJSON);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectProduct = jsonArray.getJSONObject(i);
                User user = gson.fromJson(jsonObjectProduct.toString(), User.class);
                System.out.println(user.getEmail());
                System.out.println(user.getPhone());
                /*String email =  jsonObjectProduct.getString("email");
                String gender = jsonObjectProduct.getString("gender");
                String first = jsonObjectProduct.getJSONObject("name").getString("first");
                String last = jsonObjectProduct.getJSONObject("name").getString("last");
                System.out.println("Nombre: "+first+" "+last);
                System.out.println("Mail: "+email);
                System.out.println("Gender: "+gender);*/
            }
            System.out.println(jsonArray);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
