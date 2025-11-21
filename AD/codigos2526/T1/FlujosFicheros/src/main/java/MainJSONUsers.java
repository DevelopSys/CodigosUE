import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.UsuarioJSON;
import model.UsuarioResponse;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainJSONUsers {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            URL url = new URL("https://dummyjson.com/users/search?q=John");
            UsuarioResponse response = mapper.readValue(url, UsuarioResponse.class);
            for (UsuarioJSON item: response.getUsers()) {
                System.out.println(item);
            }

        } catch (MalformedURLException e) {
            System.out.println("Error en la URL");
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
