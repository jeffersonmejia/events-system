package model;

import model.*;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

//PRINCIPOS (S)OLID: SINGLE RESPONSABILITY
//... TIENE UNA RESPONSABILIDAD: GESTIÓN DB, CRUD
public class ConnectionDB {

    //DB NAME
    private final String databaseName = "P3Proyecto_Mejia_Manzanillas";
    private final MongoClient client;
    private MongoDatabase mongoDB;
    private static ConnectionDB instance;
    public static String collectionName;

    private ConnectionDB() {
        //CONEXIÓN DB
        client = MongoClients.create("mongodb://localhost:27017");
        mongoDB = client.getDatabase(databaseName);
        if (mongoDB.getCollection(collectionName).countDocuments() == 0) {
            mongoDB.createCollection(collectionName);
        }
    }

    //PATRÓN SINGLETÓN
    public static ConnectionDB getInstance() {
        if (instance == null) {
            instance = new ConnectionDB();
        }
        return instance;
    }

    //GETTER
    public MongoDatabase getMongoDB() {
        return mongoDB;
    }

    //CONNECT
    private MongoDatabase createConnection() {
        try {
            mongoDB = getInstance().getMongoDB();
            return mongoDB;
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return null;
    }

    //CREATE
    public boolean createDocument(Document document) {
        try {
            MongoDatabase db = createConnection();
            if (db != null) {
                MongoCollection<Document> collection = db.getCollection(collectionName);
                collection.insertOne(document);
                return true;
            }
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return false;
    }

    //READ
    public List<Document> readDocument(Document document) {
        List<Document> results = new ArrayList<>();
        try {
            MongoDatabase db = createConnection();
            MongoCollection<Document> collection = db.getCollection(collectionName);
            results = collection.find(document).into(results);
            return results;
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return results;
    }

    //DELETE
    public boolean deleteDocument(Document document) {
        try {
            MongoDatabase db = createConnection();
            if (db != null) {
                MongoCollection<Document> collection
                        = db.getCollection(collectionName);
                collection.deleteOne(document);
                return true;
            }
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return false;
    }

    //UPDATE
    public boolean updateDocument(Document document,
            Document update) {
        try {
            MongoDatabase db = createConnection();
            if (db != null) {
                MongoCollection<Document> collection = db.getCollection(collectionName);
                collection.updateOne(document, new Document("$set", update));
                return true;
            }
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return false;
    }
}
