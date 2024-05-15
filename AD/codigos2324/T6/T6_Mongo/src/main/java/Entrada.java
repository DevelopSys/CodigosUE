import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.*;
import org.bson.Document;

import javax.print.Doc;

public class Entrada {

    public static void main(String[] args) {
        String connectionString = "mongodb+srv://root:root@cluster0.akk2ayo.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

        // crear un server para realizar la conexion
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        // elemento que permite conectar con el cluter
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        // C - Crear - Insert -> insertMany({})
        // U - Actualizar - Update -> updateMany({},{})
        // D - Borrado - Delete -> deleteMany({})
        // Statement o PrepareStatement -> execute - executeUpdate

        // R - Read - Buscar -> Statement o PrepareStatement -> executeQuery -> Resulset -> recorrido // find({})

        // conectar al cluster
        MongoClient mongoClient = MongoClients.create(connectionString);

        // Database -> Collections -> Documents

        // crear la base de datos -> si no esta, la crea
        MongoDatabase database = mongoClient.getDatabase("academia");
        // crear la coleccion asociada la base de datos
        // database.createCollection("profesores");
        MongoCollection collection = database.getCollection("profesores");

        // Insertar un elemento
        /*Document documentInsert = new Document();
        documentInsert.append("nombre","Juan");
        documentInsert.append("apellido","Lopez");
        documentInsert.append("edad",30);
        documentInsert.append("sueldo",30000);
        collection.insertOne(documentInsert);*/

        // Actualizar documento
        // documento donde indico cual es la clausua o clausulas where -> busqueda
        // documento donde indico cual es el nuevo dato -> modifico -> nuevos
        // documento que pone en conjunto lo que modifico y lo que busco - cambio
        /*Document documentBusqueda = new Document();
        documentBusqueda.append("nombre","Borja");
        Document documentNuevos = new Document();
        documentNuevos.append("nombre","Borja nuevo");
        Document documentCambio = new Document();
        documentCambio.append("$set", documentNuevos);
        collection.updateMany(documentBusqueda, documentCambio);*/

        // Borrado
        /*Document documentBorrado = new Document();
        documentBorrado.append("nombre", "Borja nuevo");
        collection.deleteOne(documentBorrado);*/

        // REALTIME
        // FIRESTORE

        // Busqueda
        Document documentoFiltro = new Document();
        // {$gt,39}
        documentoFiltro.append("edad",new Document().append("$lte",40));
        FindIterable resultado = collection.find(documentoFiltro);
        MongoCursor cursor = resultado.iterator();
        // [ d1 , d2 , d3 , d4 ]
        // preguntar si hay siguiente -> obtener el siguiente -> obtener un dato del siguiente
        while (cursor.hasNext()){
           Document documentActual = (Document) cursor.next();
            System.out.printf("El nombre del profesor es %s y su apellido es %s %n",
                    documentActual.getString("nombre"),documentActual.getString("apellido"));
        }
    }
}
