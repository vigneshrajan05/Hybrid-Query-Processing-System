package hqps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mysql.cj.conf.ConnectionUrlParser.Pair;
import static com.mongodb.client.model.Filters.eq;

public class mongo {
	
	private static MongoCollection<Document> collection;

	public static void fetchData(LinkedHashMap<Pair<String, String>, String> dbMap, LinkedHashMap<String, String> attributeMap){
		
		Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);	 // to prevent warnings and logs
		try {
			
			// Creating MongoDB client
			MongoClient mongoClient = new MongoClient("localhost", 27017); 
			// if database doesn't exists it creates one
			MongoDatabase db = mongoClient.getDatabase("patients");
					
			int n = dbMap.size();
			String field = "", collectionName = "", condition = "";
			ArrayList<String> attributeList = new ArrayList<String>();

			
			// case 1 : Retrieve values from one collection based on one field condition
			if(n == 1) {
				
				for(Pair<String, String> key : dbMap.keySet()) {
					collectionName = key.right;
					field = key.left;
					Map.Entry<String,String> entry = attributeMap.entrySet().iterator().next();
					condition = entry.getValue();
				}
				// System.out.println(collectionName + " -> " + field + " : " + condition);
				
				
				// create collection, if does not exist created automatically
				MongoCollection<Document> collection = db.getCollection(collectionName);
				BasicDBObject whereQuery = new BasicDBObject();
			    whereQuery.put(field, condition);
				FindIterable<Document> iterDoc = collection.find(eq(field, condition));
				
				MongoCursor<Document> it = iterDoc.iterator();
				String mongostr="";

				while (it.hasNext()) {
//				    System.out.println(it.next().toString());
					mongostr+=it.next().toString()+"\n";
				}
				SecondFrame s2=new SecondFrame(mongostr);
				s2.setVisible(true);
			}
			
			// Case 2 : Retrieve values from one collection based on multiple field conditions
			else if(n > 1) {
				LinkedHashSet<String> tables = new LinkedHashSet<String>();
				
				// Storing the table names and attribute list into separate hash sets
				for(Pair<String, String> key : dbMap.keySet()) {
					tables.add(key.right);
					attributeList.add(key.left);
					System.out.println(key.right +  " ->" + key.left);
				}
				
				// one table, many conditional attributes
				if(tables.size() == 1) {	
					
					Iterator<String> it = tables.iterator();
					collectionName = it.next();
					System.out.println("collection name :" + collectionName);
					
					BasicDBObject criteria = new BasicDBObject();
					List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
					// Appending all fields and relevant condition to criteria object
					for(int i = 0;i < attributeList.size();i++) {
						
						obj.add(new BasicDBObject((String)attributeList.get(i), (String)attributeMap.get(attributeList.get(i))));	
						System.out.println(attributeList.get(i) + " : " + (String)attributeMap.get(attributeList.get(i)));
					}
					//obj.add(new BasicDBObject("age","53"));
					//obj.add(new BasicDBObject("roomno","212"));
					criteria.put("$and", obj);
					System.out.println(criteria);
					
					// Passing the criteria object as argument to find()
								
					MongoCollection<Document> collection = db.getCollection(collectionName);
					FindIterable<Document> iterDoc = collection.find(criteria);

//					FindIterable<Document> iterDoc = colleagction.find(criteria);
					//System.out.println("Hello : ");
					MongoCursor<Document> itr = iterDoc.iterator();
					//System.out.println("Hello : " + itr.hasNext()); 
					String mongostr="";

					while (itr.hasNext()) {
//					    System.out.println(itr.next().toString());
						mongostr+=itr.next().toString()+"\n";
					}
					SecondFrame s2=new SecondFrame(mongostr);
					s2.setVisible(true);
				}
				
			}
		}
				
		catch(Exception e) {
			e.getMessage();
		}
	}
}
