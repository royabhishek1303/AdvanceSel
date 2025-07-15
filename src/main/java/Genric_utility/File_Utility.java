package Genric_utility;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class File_Utility {

	
	public String getKeyAndValue(String key) throws Throwable {
		File file = new File("./src/test/resources/JsonData.json");
		ObjectMapper obj = new ObjectMapper();
		JsonNode data = obj.readTree(file);
		String BROWSER = data.get(key).asText();
		return BROWSER;
	}
}
