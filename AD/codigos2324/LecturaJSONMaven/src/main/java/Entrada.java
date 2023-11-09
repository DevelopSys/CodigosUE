import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        // https://www.thesportsdb.com/api/v1/json/3/search_all_teams.php?s=Soccer&c=Spain
        // URL - HTTPConnection - BufferedRead - STRING
        try {
            URL url = new URL("https://www.thesportsdb.com/api/v1/json/3/all_leagues.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            String linea = null;
            while ((linea = reader.readLine())!=null){
                stringBuffer.append(linea);
            }

            //STRING - JSON
            JSONObject response = new JSONObject(stringBuffer.toString());
            JSONArray teams = response.getJSONArray("leagues");
            for (int i = 0; i < teams.length(); i++) {
                JSONObject liga = teams.getJSONObject(i);
                String id = liga.getString("idLeague");
                String nombre = liga.getString("strLeague");
                System.out.println(id);
                System.out.println(nombre);
                // Equipo
                Equipo equipo = new Equipo();
            }

            System.out.println("Dime el id de la liga que quieres ver sus temporadas");
            Scanner scanner = new Scanner(System.in);
            String id = scanner.next();
            URL urlID = new URL("https://www.thesportsdb.com/api/v1/json/3/search_all_seasons.php?id="+id);

            connection = (HttpURLConnection) urlID.openConnection();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            stringBuffer = new StringBuffer();
            linea = null;
            while ((linea = reader.readLine())!=null){
                stringBuffer.append(linea);
            }

            response = new JSONObject(stringBuffer.toString());
            JSONArray season = response.getJSONArray("seasons");
            for (int i = 0; i < season.length(); i++) {
                JSONObject temporada = season.getJSONObject(i);
                String seasonStr = temporada.getString("strSeason");
                System.out.println(seasonStr);
                // INSERT
            }

            SwingWorker worker = new SwingWorker() {
                @Override
                protected Object doInBackground() throws Exception {
                    return null;
                }
            };
            worker.run();

            new Thread(new Runnable() {
                @Override
                public void run() {

                }
            });








        } catch (IOException e) {
            System.out.println("Error en la conextion I/O");
        }
    }
}
