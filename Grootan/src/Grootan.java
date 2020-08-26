import java.io.*;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.json.simple.parser.JSONParser;

class Grootan {
	public static void main(String[] args) {
		try {
//			String jsonstring = "{\"about\":\"Grootan\",\"created\":123324,\"id\":\"Grootan_123\",\"likes\":123,\"submitted\":[13123.00, 12321.00]}";
			if (args.length > 0) {
				
			String jsonstring = args[0];
			
			JSONObject receivedJson = (JSONObject) new JSONParser().parse(jsonstring);
			System.out.println(receivedJson);
			
			String classTemplate = "import java.util.list;\nClass POJO{\n";
			
			for(Iterator<?> iterator = receivedJson.keySet().iterator(); iterator.hasNext();) {
			    String key = (String) iterator.next();
//			    System.out.println(receivedJson.get(key).getClass());
			    String variableTemplate = "";
			    if(receivedJson.get(key) instanceof Integer) {
//			    	Integer.parseInt((String) receivedJson.get(key));
			    	variableTemplate = "\tprivate int " + key + ";\n";
			    }
			    else{
			    	variableTemplate = "\tprivate String " + key + ";\n";
			    }
			    
			    String capitalizedKey = key.substring(0, 1).toUpperCase() + key.substring(1);

			    String getterTemplate = "\tpublic get" + capitalizedKey + "(){\n\t\treturn " + key + ";\n\t}\n";
			    
			    String setterTemplate = "\tpublic set" + capitalizedKey + "(String " + key +"){\n\t\tthis." + key + "=" + key + ";\n\t}\n";
			    
			    classTemplate += variableTemplate + getterTemplate + setterTemplate;
			    
//			    System.out.println(receivedJson.get(key));
			}
			
			classTemplate += "}";
			
			System.out.println(classTemplate);
			
//			return classTemplate;
			}
			else {
				System.out.println("Enter an input");
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
//		return "Enter a valid JSON";
	}
}