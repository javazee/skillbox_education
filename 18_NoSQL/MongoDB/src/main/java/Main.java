import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("127.0.0.1" , 27017);
        MongoDatabase database = mongoClient.getDatabase("local");
        MongoCollection<Document> collection = database.getCollection("students");
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/main/resources/mongo.csv"));
            String delimiter1 = ",(?=\\d)";
            String delimiter2 = ",(?=\")";
            for (int i = 0; i < lines.size(); i++) {
                String[] elements1 = lines.get(i).split(delimiter1);
                String[] elements2 = elements1[1].split(delimiter2);
                Document document = new Document()
                        .append("Name", elements1[0])
                        .append("Age", Integer.parseInt(elements2[0]))
                        .append("Courses", elements2[1]);
                collection.insertOne(document);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
        System.out.println("Общее количество студентов: " + collection.countDocuments());
        BsonDocument query = BsonDocument.parse("{Age: {$gt: 40}}");
        System.out.println("Количество студентов старше 40: " + collection.countDocuments(query));
        BsonDocument sortByAge = BsonDocument.parse("{Age: 1}");
        System.out.println("Самый молодой студент: " + Objects.requireNonNull(collection.find().sort(sortByAge).first()).get("Name"));
        BsonDocument sortByAgeReversed = BsonDocument.parse("{Age: -1}");
        System.out.println("Список курсов самого старого студента: " + Objects.requireNonNull(collection.find().sort(sortByAgeReversed).first()).get("Courses"));
        collection.drop();
    }
}
