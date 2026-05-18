import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import static com.mongodb.client.model.Aggregates.set;
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
            // collection.find(eq("edad", new Document().append("$gt",30))).forEach(item-> System.out.println(item.toJson())); GSON
            // collection.insertOne(new Document().append("nombre","testJava").append("edad",30));
            DeleteResult result = collection.deleteMany(eq("nombre","juan"));
            DeleteResult result1 = collection.deleteOne(new Document("nombre","juan"));
            // result.getDeletedCount();
            // collection.deleteOne()
            UpdateResult resultUpdate = collection.updateMany(eq("nombre","borja"),new Document("edad",30));
            resultUpdate.getModifiedCount();

        }
    }
}
