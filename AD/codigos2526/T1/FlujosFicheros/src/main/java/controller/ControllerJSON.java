package controller;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Producto;
import model.ProductoResponse;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ControllerJSON {
    public void lecturaJSON(){
        //  lectura del json de la URL https://dummyjson.com/products
        String urlString = "https://dummyjson.com/products";
        ObjectMapper mapper = new ObjectMapper();
        try {
            URL url = new URL(urlString);
            ProductoResponse response = mapper.readValue(url, ProductoResponse.class);
            for (Producto item: response.getProducts()) {
                System.out.println(item);
            }

        } catch (MalformedURLException e) {
            System.out.println("URL Invalida");
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            System.out.println("Error en la asociacion de las caracteristicas");
        } catch (IOException e) {
            System.out.println("Error entrada salida");
        }
    }
}
