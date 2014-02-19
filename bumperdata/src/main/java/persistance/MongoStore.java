package persistance;

import java.util.Arrays;
import java.util.List;

import bumperdata.Abbreviation;
import bumperdata.User;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;

public class MongoStore {

	DB db;

	public MongoStore() {
		try {
			MongoClient mongoClient;
			mongoClient = new MongoClient("localhost");
			db = mongoClient.getDB("eubumper");
			createCollections();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createCollections(){
    	DBCollection collection;
    	List<String> collections = Arrays.asList(new String[]{"User"});
    	for(String type : collections){
    	if (!db.collectionExists(type)) {

			DBObject options = BasicDBObjectBuilder.start().get();
		    collection = db.createCollection(type, options);
			if (type.equalsIgnoreCase("User")){
				collection.ensureIndex(new BasicDBObject("username", 1), null, true);
			}
    	}
    	}
    }

	public String storeObject(String type, String obj) {
		DBCollection collection = db.getCollection(type);
		DBObject dbObject = (DBObject) JSON.parse(obj);
		try {
		   collection.insert(dbObject);
		   return "success";
		} catch(MongoException me){
			return me.getMessage();
		}
	}

	
	public Abbreviation findAbbreviation(String abbv){
		return null;
	}
	public User findUser(String username) {
		DBCollection coll = db.getCollection("User");
		BasicDBObject query = new BasicDBObject("username", username);

		DBCursor cursor = coll.find(query);
		try {
			if (cursor.hasNext()) {
				Gson gson = new Gson();
				User obj = gson.fromJson(cursor.next().toString(), User.class);
				return obj;
			}
		} finally {
			cursor.close();
		}
		return null;
	}

}
