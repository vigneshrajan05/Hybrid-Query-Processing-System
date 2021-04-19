package hqps;

import static com.mongodb.client.model.Filters.eq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mysql.cj.conf.ConnectionUrlParser.Pair;


import java.util.logging.Level;
import java.util.logging.Logger;



public class hybrid {

	private static char[] searchString;

	public static void fetchData(LinkedHashMap<Pair<String, String>, String> dbMap,
			LinkedHashMap<String, String> attributeMap, boolean mongo)  {
		
		// to turn off console logs and warnings
		Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);	
		
		
		// To know which database the connection attribute belong to,
		// we need to iterate the dbMap and find the name of database. Assumption : One connection variable
		String database = "";
		String searchString = "";
		for(String mp : dbMap.values()) {
			if(mp.equals("MySQL")) {
				database = mp;
				break;
			}
			else {
				database = mp;
				break;
			}	
		}
		
		// Since we have assumed there would be only one connection variable, 
		// we get the attribute and its corresponding condition directly
		
		Map.Entry<String,String> entry = attributeMap.entrySet().iterator().next();
		String connAttribute = entry.getKey();
		String condition = entry.getValue();
		
		// mongo is a boolean variable to indicate whether the joining attribute belongs to MySQL or MongoDB
		if(database.equals("MongoDB") && mongo) {

				// Creating mongo client
				MongoClient mongoClient = new MongoClient("localhost", 27017); 
				// if database doesn't exists it creates one
				MongoDatabase db = mongoClient.getDatabase("patients");
				
				LinkedHashSet<String> collections = new LinkedHashSet<String>();
				
				// Storing the table names and attribute list into separate hash sets
				for(Pair<String, String> key : dbMap.keySet()) {
					collections.add(key.right);
				}
				String hybrid="";
				System.out.println("\n\n--------------------From MongoDB--------------------\n");
				hybrid+="\n\n--------------------From MongoDB--------------------\n";
				for(String collectionName : collections) {
					System.out.println("\n********** " + collectionName + " **********");
					hybrid+="\n\n********** " + collectionName + " **********\n";
					MongoCollection<Document> collection = db.getCollection(collectionName);
					
					BasicDBObject whereQuery = new BasicDBObject();
				    whereQuery.put(connAttribute, condition);
				    
				    // Finding the document in the given collection for the given condition
					FindIterable<Document> iterDoc = collection.find(eq(connAttribute, condition));
					MongoCursor<Document> it = iterDoc.iterator();
					
					while (it.hasNext()) {
						Document temp = it.next();
						searchString += temp.toString() + "\n";
					    System.out.println(temp.toString());
					    hybrid+="\n"+temp.toString();
					}
				}
				
				
				
				// finding the doctor who treated that patient
				
				System.out.println("\n\n--------------------From MySQL--------------------\n");
				hybrid+="\n\n--------------------From MySQL--------------------\n";
				// To get details about the doctor who treated the patient, 
				// we need to get the d_id using Regex from the documents
				
				
				//String joinAttributeCondition = ElementToString.getJoiningAttributeCondition(searchString);
				
				LinkedHashSet<String> joinAttributeCondition = ElementToString.getJoiningAttributeCondition(searchString);
				String patientName = ElementToString.getPatientName(searchString);
				//System.out.println(joinAttributeCondition);
				boolean displayFlag = true;
				for(String Attrcond : joinAttributeCondition) {
					String query = "SELECT * FROM doctor WHERE d_id = \""+ Attrcond + "\" ";

					
					// Establishing connection and fetching doctor details from MySQL
					String url = "jdbc:mysql://localhost:3306/hqps";
					String uname = "root";
					String pass = "";

					try {
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection(url,uname,pass);
						Statement st = con.createStatement();
						
						ResultSet rs = st.executeQuery(query);	// returns whole structure of table, so we use result set
						
						// contains meta data about the result set, using it to get the column names and count
						ResultSetMetaData rsmd = rs.getMetaData();
						int columnCount = rsmd.getColumnCount();
						 
						ArrayList<String> columnNames = new ArrayList<String>();
						 
						// we get column names by specifying the column number, and storing it in an ArrayList
						for(int j = 1;j <= columnCount;j++) {
							 columnNames.add(rsmd.getColumnName(j));
						}
						
						// printing the column names
						if(displayFlag) {
							System.out.println("\nDetails of doctor who treated " + patientName + "\n");
							hybrid+="\nDetails of doctor who treated " + patientName + "\n";
							for(var col : columnNames) {
								System.out.print(col + "\t\t");
								hybrid+=col + "\t\t";
							}
							hybrid+="\n";
							displayFlag = false;
							System.out.println();	// separation between column names and records
						}
											
						while(rs.next()) {			
							for(var col : columnNames) {
								var record = rs.getString(col);
								System.out.print(record + "\t\t ");
								hybrid+=record + "\t\t ";
							}
							hybrid+="\n";
							System.out.println();
						}
						con.close();
						SecondFrame s=new SecondFrame(hybrid);
						s.setVisible(true);
				}
					

				catch(Exception e) {
					System.out.println(e.getMessage());
				}	
		}
} 
		
		// If database is MySQL
		else {
			// If a hybrid query is to be performed we need a joining attribute common to both databases, in our case
			// its p_id(present in treatment_history), which is present in treatment history_table, so we directly query and get the p_id value 
			String hybrid="";
			System.out.println("\n\n--------------------From MySQL--------------------\n");
			hybrid+="\n\n--------------------From MySQL--------------------\n";
			Map.Entry<String,String> mapEntry = attributeMap.entrySet().iterator().next();
			String inputAttribute = mapEntry.getKey();
			String conditionForAttribute = mapEntry.getValue();
			
			String p_id = "";
			String url = "jdbc:mysql://localhost:3306/hqps";
			String uname = "root";
			String pass = "";
			String query = "SELECT pid FROM treatment_history WHERE " +  inputAttribute + "=" + "\"" +conditionForAttribute + "\" ";
			System.out.println(query);
			hybrid+="\n\n"+query+"\n";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,uname,pass);
				Statement st = con.createStatement();
				
				ResultSet rs = st.executeQuery(query);	// returns whole structure of table, so we use result set
				
				// contains meta data about the result set, using it to get the column names and count
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				 
				ArrayList<String> columnNames = new ArrayList<String>();
				 
				// we get column names by specifying the column number, and storing it in an ArrayList
				for(int i = 1;i <= columnCount;i++) {
					 columnNames.add(rsmd.getColumnName(i));
				 }
				
				// printing the column names
				for(var col : columnNames) {
					System.out.print(col + "\t\t");
					hybrid+="\n"+col + "\t\t";
				}
				
				System.out.println();	// separation between column names and records
				while(rs.next()) {									
					for(var col : columnNames) {
						var record = rs.getString(col);
						p_id = record;
						System.out.print(record + "\t\t ");
						hybrid+="\n"+record + "\t\t ";
					}
					
					System.out.println();
				}
				con.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			System.out.println("\n\n--------------------From MongoDB----------------------\n");
			hybrid+="\n\n--------------------From MongoDB----------------------\n";

			
			// Creating mongo client
			MongoClient mongoClient = new MongoClient("localhost", 27017); 
			
			// if database doesn't exists it creates one
			MongoDatabase db = mongoClient.getDatabase("patients");
			
			LinkedHashSet<String> collections = new LinkedHashSet<String>();
			
						
			// Storing the table names and attribute list into separate hash sets
			for(Pair<String, String> key : dbMap.keySet()) {
				collections.add(key.right);			// we don't want MySQL tables to be printed
			}
			
			List<String> msTables = new ArrayList<String>();
			msTables.add("doctor");
			msTables.add("treatment_history");
			
//			collections.add("patientDetails");			   
			for(String collectionName : collections) {
				
				if(!msTables.contains(collectionName)) {
					System.out.println("\n********** " + collectionName + " **********");
					hybrid+="\n\n********** " + collectionName + " **********\n";
					MongoCollection<Document> collection = db.getCollection(collectionName);
					
					BasicDBObject whereQuery = new BasicDBObject();
				    whereQuery.put("p_id", p_id);
				    
				    // Finding the document in the given collection for the given condition
					FindIterable<Document> iterDoc = collection.find(eq(connAttribute, condition));
					MongoCursor<Document> it = iterDoc.iterator();
					
					while (it.hasNext()) {
						Document temp = it.next();
						searchString += temp.toString() + "\n";
					    System.out.println(temp.toString());
					    hybrid+= "\n" + temp.toString();
					}
				}
				
			}
			SecondFrame s=new SecondFrame(hybrid);
			s.setVisible(true);
			
		}
	}
}
