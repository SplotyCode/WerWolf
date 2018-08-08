package me.david.werwolf.game.database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import lombok.Getter;
import org.bson.Document;

public class DatabaseConnection {

    private MongoClient client = new MongoClient();

    private MongoDatabase database;
    @Getter private MongoCollection<Document> userCollection;

    public DatabaseConnection() {
        database = client.getDatabase("werwolf");
        userCollection = database.getCollection("users");
    }

    public void createUser(UserDatabaseObject user) {
        Document document = new Document();
        user.write(document);
        userCollection.insertOne(document);
    }

    public UserDatabaseObject getUser(String email) {
        UserDatabaseObject user = new UserDatabaseObject();
        user.read(userCollection.find(Filters.eq("email", email)).first());
        return user;
    }

}
