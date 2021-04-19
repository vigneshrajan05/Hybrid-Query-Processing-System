package hqps;

import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.*; 

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;


public class parser {

	private static String tableName;
	private static String contentName;
	private static String databaseName;
	
	public static void parse(LinkedHashMap<String,String> attributeMap) {
		// SAXBuilder used only for specifying path of XML file
		SAXBuilder builder = new SAXBuilder();
		Scanner sc = new Scanner(System.in);
		boolean flag = true, isHybrid = false;
		int choice = 1;
						
		
		// Using LinkedHashMap to maintain insertion order
		//<attribute name, attr_condition>
		//LinkedHashMap<String,String> attributeMap = new LinkedHashMap<String,String>();	
		// contains <<attributeName, tableName>, database>
		LinkedHashMap<Pair<String,String>, String> dbMap = new LinkedHashMap<Pair<String,String>,String>();	 
		
/*		
		do {
			System.out.print("Enter the name of attribute to retrieve:");
			String attribute = sc.nextLine();
			System.out.print("Enter the condition for " + attribute + ":");
			String condition = sc.nextLine();
			attributeMap.put(attribute, condition);
			sc.nextLine();
			System.out.print("Do you wish to input more attributes?(1/0) :");
			choice= sc.nextInt();
			sc.nextLine();
		}while(choice == 1);
 								
 */
		
		// Reading XML document using try catch block
		Document xml = null;
		try {
			xml = builder.build(new File("hqps.xml"));
		}
		catch(JDOMException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		// Obtaining root of XML document
		Element root = xml.getRootElement();
		//System.out.println("The root element of specified XML document is : " + root.getName());
		
		// Getting all children of database
		List<Element> db = root.getChildren();
		
		// Iterator to iterate over the databases(MySQL, MongoDB)					
		// iterate over keys and find corresponding database
		for (String inputAttribute : attributeMap.keySet()) {
			flag = true;		
			Iterator<Element> databaseItr = db.iterator();
			while(flag && databaseItr.hasNext()) {
				
				//Iterator for MySQL
				Element dbIterator = databaseItr.next();
				databaseName = ElementToString.getString(dbIterator);
				
				// Gets all children of MySQL
				List<Element> my = dbIterator.getChildren();
				
				// Iterator to iterate over tables in MySQL
				Iterator<Element> tableItr = my.iterator();

				while(flag && tableItr.hasNext()) {
					// create iterator for children of tables
					Element table = (Element) tableItr.next();
					tableName = ElementToString.getString(table); 	// Since its a static method present in ElementToString Class
					
					List<Element> contentList = table.getChildren();
					Iterator<Element> contentItr = contentList.iterator();
					while(flag && contentItr.hasNext()) {
						Element content = (Element)contentItr.next();
						contentName = ElementToString.getString(content);
						
						// Compare input attribute and content, when equal break the loop
						if(inputAttribute.equals(contentName)){
							System.out.println(databaseName + " -> " + tableName + " -> "+ contentName);
							dbMap.put(new Pair(contentName, tableName), databaseName);
							if(inputAttribute.equals("p_id") || inputAttribute.equals("d_id")) {
								continue;
							}
							else {
								flag  = false;
								break;
							}
							
						}
					}
				}					
			}
		}
		
			
		boolean isMongoQuery = true;
		// checking if input is p_id. If yes we need to perform a Hybrid Query
		if(attributeMap.size() == 1) {
			Map.Entry<String,String> entry = attributeMap.entrySet().iterator().next();
			String connectionAttribute = entry.getKey();
			if(connectionAttribute.equals("p_id")) {
				hybrid.fetchData(dbMap, attributeMap, isMongoQuery);
				isHybrid = true;
			}			
			if(connectionAttribute.equals("d_id")) {
				isMongoQuery = false;
				hybrid.fetchData(dbMap, attributeMap, isMongoQuery);
				isHybrid = true;
			}
		}
		
		// if its a hybrid query it might have already been executed!
		if(!isHybrid) {
			// database name
			int mysqlCount = 0, mongoCount = 0;
			for(String mp : dbMap.values()) {
				if(mp.equals("MySQL"))
					mysqlCount++;
				else
					mongoCount++;
			}
					
			 // Assumption : We could perform only hybrid queries on p_id and d_id. 
			// Any attribute query following p_id/d_id would be ignored!
			// checking if we need to retrieve data from MySQL/ MongoDB
			if(mongoCount == 0)
				mysql.fetchData(dbMap,attributeMap);
			else if(mysqlCount == 0)
				mongo.fetchData(dbMap, attributeMap);
		}
		
		sc.close();
	}
	
	
	public static void main(String[] args) {

	}
}
