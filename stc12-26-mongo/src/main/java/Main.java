import com.mongodb.*;

import java.net.UnknownHostException;

public class Main {
    private static MongoClient mongoClient;

    public static void main(String[] args) {
        mongoClient = getMongoClient();
/*        List<String> dbs = mongoClient.getDatabaseNames();
        for (String db:dbs){
            System.out.println(db);
        }*/

        //User user = new User("Pavel pavlovich", 25, new Date(1990, 02, 03), new Address("Moscow", "Lenina", 12));
        //addData("users", "name", "Tommy");
        delete("users", "name", "Tom");
        showCollection("users");
    }

    private static void addData(String tableName, String key, Object value) {
        DB db = mongoClient.getDB("test");
        DBCollection table = db.getCollection(tableName);
        BasicDBObject document = new BasicDBObject();
        document.put(key, value);
        table.insert(document);
    }

    private static void delete(String tableName, String key, Object value) {
        DB db = mongoClient.getDB("test");
        DBCollection collection = db.getCollection(tableName);
        BasicDBObject query = new BasicDBObject();
        query.put(key, value);
        collection.remove(query);
    }

/*    private static String getData(String tableName, String key){
        MongoClient mongoClient = getMongoClient();
        DB db = mongoClient.getDB("test");
        DBCollection table = db.getCollection(tableName);
        BasicDBObject query = new BasicDBObject();
        query.put()
    }*/

    private static void showCollection(String tableName) {
        MongoClient mongoClient = getMongoClient();
        DB db = mongoClient.getDB("test");
        DBCollection collection = db.getCollection(tableName);
        DBCursor result = collection.find();
        while (result.hasNext()) {
            DBObject current = result.next();
            System.out.println(current.get("_id") + " " + current.get("name"));
        }
    }

    private static MongoClient getMongoClient() {
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient("localhost", 27017);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return mongoClient;
    }


}