package hqps;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jdom2.Element;

public class ElementToString {

		public static String getString(Element x) {
			
			String temp = x.toString();
			String pattern = "\\[[a-zA-z:\\s]+\\<([a-zA-Z_]+)/>]";
			
			// Creating Pattern object
		    Pattern p = Pattern.compile(pattern);

		    // Now creating matcher object.
		    Matcher m = p.matcher(temp);
		    
		    if (m.find()) {
		       return m.group(1);	// returning the group that contains the attribute name
		    }
		    return "";
		}
		
		
		public static LinkedHashSet<String> getJoiningAttributeCondition(String temp) {
			
			String pattern = "d_id=([0-9]+)";
			LinkedHashSet<String> ls = new LinkedHashSet<String>();
			// Creating Pattern object
		    Pattern p = Pattern.compile(pattern);

		    // Now creating matcher object.
		    Matcher m = p.matcher(temp);
		    
		    while (m.find()) {
		    	ls.add(m.group(1));
		    	//return m.group(1);		// returning the group that contains the attribute name
		    }
			//return "";
		    return ls;
		}
		
		public static String getPatientName(String temp) {
			
			String pattern = "pname=([a-zA-Z]+)";
			
			// Creating Pattern object
		    Pattern p = Pattern.compile(pattern);

		    // Now creating matcher object.
		    Matcher m = p.matcher(temp);
		    
		    if (m.find()) {
		       return m.group(1);	// returning the group that contains the attribute name
		    }
			return "";
		}
		
		public static void main(String[] args) {
//			String t = "Document{{_id=604a1f93baf25546b47c39a4, p_id=1, d_id=2, admission_date=March 2 2021, discharged=No, treatmentname=Open Heart Surgery}}\r\n" + 
//					"Document{{_id=606adc020f9e36282429c3d6, p_id=1, d_id=2, admission_date=November 2 2020, discharged=Yes, treatmentname=Angioplasty and Stent Placement}}\r\n" + 
//					"";
//			System.out.println(getJoiningAttributeCondition(t));
		}
		
}
