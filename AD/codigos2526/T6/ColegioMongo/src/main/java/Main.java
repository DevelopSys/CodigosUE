import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class Main {

    public static void main(String[] args) {
        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "mongodb+srv://ue:ue@cluster0.7a09llb.mongodb.net/?appName=Cluster0";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("colegio");
            MongoCollection<Document> collection = database.getCollection("alumnos");
            /*Document doc = collection.find(eq("nombre", "Borja")).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }*/
            // collection.find(eq("edad", new Document().append("$gt",30))).forEach(item-> System.out.println(item.toJson()));
            collection.insertOne(new Document().append("nombre","testJava"));
        }
    }
}
