import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class Entrada {

    public static void main(String[] args) {
        String connectionString = "mongodb+srv://root:root@cluster0.akk2ayo.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        // DriverManager.classfromname
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                // Send a ping to confirm a successful connection
                MongoDatabase database = mongoClient.getDatabase("sample_mflix");
                MongoCollection<Document> collection = database.getCollection("movies");
                Document doc = collection.find(eq("title", "Back to the Future")).first();
                //  find({title: {$eq:"Back to the future}})
                if (doc != null) {
                    System.out.println(doc.toJson());
                } else {
                    System.out.println("No matching documents found.");
                }

            } catch (MongoException e) {
                e.printStackTrace();
            }
        }

    }
}
