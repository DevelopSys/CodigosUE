package org.example;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        String url = "mongodb+srv://root:root@cluster0.atbohp0.mongodb.net/?retryWrites=true&w=majority";
        MongoClient mongoClient = MongoClients.create(url);
        MongoDatabase database = mongoClient.getDatabase("videoclub");
        MongoCollection coleccionPeliculas = database.getCollection("peliculas");
        /*Document pelicula = new Document();
        pelicula.put("titulo","pelicula desde java");
        pelicula.put("anyoPublicacion",2000);
        pelicula.put("categoria","terror");
        Document pelicula1 = new Document();
        pelicula1.put("titulo","pelicula desde java 1");
        pelicula1.put("anyoPublicacion",2001);
        pelicula1.put("categoria","terror");
        List<Document> listaDocumentos = new ArrayList();
        listaDocumentos.add(pelicula);
        listaDocumentos.add(pelicula1);
        coleccionPeliculas.insertMany(listaDocumentos);*/

        Document documentFind = new Document();
        documentFind.put("anyoPublicacion",new Document().append("$gt",1900).append("$lt",2010));
        documentFind.put("titulo","Titulo2");
        FindIterable<Document> resultados =  coleccionPeliculas.find(documentFind);
        MongoCursor<Document> cursor = resultados.iterator();
        while (cursor.hasNext()){
            Document document = cursor.next();
            System.out.println(document.get("titulo"));
            System.out.println(document.get("anyoPublicacion"));
        }




    }
}