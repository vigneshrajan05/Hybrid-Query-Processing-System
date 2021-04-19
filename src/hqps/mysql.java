package hqps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.*;


import com.mysql.cj.conf.ConnectionUrlParser.Pair;

public class mysql {
	public static void fetchData(LinkedHashMap<Pair<String,String>, String> dbMap, LinkedHashMap<String, String> attributeMap) {
				
		int n = dbMap.size();
		String attribute = "", tableName = "", condition = "";
		ArrayList<String> attributeList = new ArrayList<String>();
		String query = "";
		if(n == 1) {
			// One attribute from one table
			for(Pair<String, String> key : dbMap.keySet()) {
				tableName = key.right;
				attribute = key.left;
				Map.Entry<String,String> entry = attributeMap.entrySet().iterator().next();
				condition = entry.getValue();
				
			}
			query = "SELECT * FROM " + tableName + " WHERE " + attribute +" = \""+ condition + "\" ";
			//System.out.println(query);
		}
			
		else if(n > 1) {
			LinkedHashSet<String> tables = new LinkedHashSet<String>();
			for(Pair<String, String> key : dbMap.keySet()) {
				tables.add(key.right);
				attributeList.add(key.left);
			}
			
			// one table many conditional attributes
			if(tables.size() == 1) {
				// no of tables = 1
				
				Iterator<String> it = tables.iterator();
				tableName = it.next();
				query = "SELECT * FROM "+ tableName +" WHERE ";
				for(int i = 0;i < attributeList.size();i++) {
					String temp = attributeList.get(i) + "=\"" + attributeMap.get(attributeList.get(i))+"\"";
					if(i != attributeList.size() - 1)
						temp += " and ";
					
					query += temp;
				}
				//System.out.println(query);
			}
			//many tables many attributes
			else if(tables.size()==2) {
				// number of tables >1
				System.out.println(tables);
				List<String> pat1 = Arrays.asList("doctor","treatment_history");
				List<String> pat2 = Arrays.asList("staff","treatment_history");
				

                if(tables.containsAll(pat1))
				{
					System.out.println("Can perform the query");
//					query="SELECT * FROM "+pat1.get(0)+" WHERE d_id in(SELECT did FROM "+pat1.get(1)+" WHERE "+attributeList.get(1)+"="+attributeMap.get(attributeList.get(1))+")";
					query= "SELECT * FROM "+pat1.get(0)+" "+pat1.get(0).charAt(0)+","+pat1.get(1)+" "+pat1.get(1).charAt(0)+" WHERE "+pat1.get(0).charAt(0)+"."+attributeList.get(0)+"="+pat1.get(1).charAt(0)+"."+attributeList.get(1)+" AND "+attributeList.get(0)+"="+attributeMap.get(attributeList.get(0));
					System.out.println(query);
				}
                else if(tables.containsAll(pat2))
                {
					System.out.println("Can perform the query");
//                	query="SELECT * FROM "+pat2.get(0)+" WHERE s_id in(SELECT sid FROM "+pat2.get(1)+" WHERE sid ="+attributeMap.get(attributeList.get(1))+")";
					query= "SELECT * FROM "+pat2.get(0)+" "+pat2.get(0).charAt(0)+","+pat2.get(1)+" "+pat2.get(1).charAt(0)+" WHERE "+pat2.get(0).charAt(0)+"."+attributeList.get(0)+"="+pat2.get(1).charAt(0)+"."+attributeList.get(1)+" AND "+attributeList.get(0)+"="+attributeMap.get(attributeList.get(0));
					System.out.println(query);
				}
                else
                {
                	System.out.println("Cannot perform the query");

                }
				
			}
			  else if(tables.size()==3)
              {
				List<String> pat3=Arrays.asList("treatment_history","doctor","staff");
//				query= "SELECT * FROM "+pat3.get(0)+" "+pat3.get(0).charAt(0)+","+pat3.get(1)+" "+pat3.get(1).charAt(0)+" WHERE "+pat3.get(0).charAt(0)+"."+attributeList.get(0)+"="+pat3.get(1).charAt(0)+"."+attributeList.get(1);
				query= "SELECT pid,d_id,name,gender,specialization,staff_name FROM "+pat3.get(0)+" LEFT OUTER JOIN "+pat3.get(1)+" ON "+pat3.get(0)+".did="+pat3.get(1)+"."+attributeList.get(1)+" LEFT OUTER JOIN "+pat3.get(2)+" ON "+pat3.get(0)+".sid="+pat3.get(2)+"."+attributeList.get(2);
				System.out.println(query);

              }
			  else
			  {
				  System.out.println("Invalid Selection");
			  }
		}
		
		
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
			for(int i = 1;i <= columnCount;i++) {
				 columnNames.add(rsmd.getColumnName(i));
			 }
			
			
			
			// printing the col names
			
			String colNames="";
			for(var col : columnNames) {
				System.out.print(col + "\t\t");
				colNames+=col + "\t\t";
			}
			SecondFrame.getFrames();
			System.out.println();
			String temp="";
			while(rs.next()) {
				for(var col : columnNames) {
					var record = rs.getString(col);
					System.out.print(record + "\t\t ");
					temp+=record + "\t\t ";
				}
				temp+="\n";
				
				System.out.println();
				
			}
			SecondFrame s=new SecondFrame(colNames,temp);
			s.setVisible(true);
			con.close();
		}
		
		catch(Exception e) {
			System.out.println(e.getMessage());
		}	
	}
}



