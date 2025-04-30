import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.*;
import org.bson.Document;

public class Entrada {

    public static void main(String[] args) {
        String connectionString = "mongodb+srv://ue:ue@cluster0.zdk8c7y.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        MongoClient mongoClient = MongoClients.create(settings);

        // obtener la base de datos
        MongoDatabase database = mongoClient.getDatabase("centro_estudios");
        MongoCollection collection = database.getCollection("profesores");

        // collection.
        // db.inserOne({nombre:"Borja", edad:30, FCTS:true})

        /*Document documentoProfesor = new Document();
        documentoProfesor.append("nombre","Borja");
        documentoProfesor.append("edad",30);
        documentoProfesor.append("FCTS",true);
        collection.insertOne(documentoProfesor);*/

        // si yo quiero obtener aquellos con titulo higher_grade Ingeniero informatico
        // db.profesores.find({higher_grade:"DAM"})
        Document documentoBusqueda = new Document();
        // buscar por un titulo documentoBusqueda.append("title","Ingeniero informatico");
        // buscar por un edad db.profesores.find({age:{$lt:54}})
        documentoBusqueda.append("age",new Document().append("$gt",27));

        FindIterable findIterable = collection.find(documentoBusqueda);
        MongoCursor<Document> cursor = findIterable.iterator();
        while (cursor.hasNext()){
            Document elemento = cursor.next();
            String nombre = elemento.getString("name");
            System.out.println(nombre);
        }



    }
}
