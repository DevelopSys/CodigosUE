package controller;

import com.google.gson.Gson;
import database.DBConnection;
import database.SchemaBD;
import model.Product;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductosController {


    private Connection connectionDB;
    public void importarPedidos(){
         connectionDB = DBConnection.getConnection();
        try {
            URL url = new URL("https://dummyjson.com/products");
            HttpURLConnection connectionURL = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = null;
            bufferedReader = new BufferedReader(new InputStreamReader(connectionURL.getInputStream()));
            JSONObject response  = new JSONObject(bufferedReader.readLine());
            JSONArray products = response.getJSONArray("products");
            for (int i = 0; i < products.length(); i++) {

                JSONObject product = products.getJSONObject(i);
                Product productJAVA = new Gson().fromJson(product.toString(), Product.class);
                /*String nombre = product.getString("title");
                String descripcion = product.getString("description");
                double precio = product.getDouble("price");
                int cantidad = product.getInt("stock");*/
                // INSERT INTO %s (%s,%s,%s,%s) VALUES (?,?,?,?)
                try {
                    PreparedStatement preparedStatement = connectionDB.prepareStatement(String.format("INSERT INTO %s (%s,%s,%s,%s) VALUES (?,?,?,?)",
                            SchemaBD.TAB_PRODUCTOS,
                            SchemaBD.COL_NOMBRE,SchemaBD.COL_DESC,SchemaBD.COL_PRECIO, SchemaBD.COL_CANTIDAD));
                    preparedStatement.setString(1,productJAVA.getTitle());
                    preparedStatement.setString(2,productJAVA.getDescription());
                    preparedStatement.setDouble(3,productJAVA.getPrice());
                    preparedStatement.setInt(4,productJAVA.getStock());
                    preparedStatement.execute();
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                bufferedReader.close();
                //connectionDB.close();

            }

        } catch (IOException  e) {
            throw new RuntimeException(e);
        }
    }

    public void getProductos(){
        connectionDB = DBConnection.getConnection();
        try {
            ResultSet resultSet = connectionDB.createStatement().executeQuery("SELECT * FROM "+SchemaBD.TAB_PRODUCTOS);
            while (resultSet.next()){
                String nombre = resultSet.getString(SchemaBD.COL_NOMBRE);
                String descripcion = resultSet.getString(SchemaBD.COL_DESC);
                double precio = resultSet.getDouble(SchemaBD.COL_PRECIO);
                int cantidad = resultSet.getInt(SchemaBD.COL_CANTIDAD);
                Product product = new Product(nombre,descripcion,precio,cantidad);
                //user.mostrarDatos();
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void marcarFav(int id){

    }

}
