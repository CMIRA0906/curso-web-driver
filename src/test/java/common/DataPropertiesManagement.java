package common;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataPropertiesManagement {
	
	
	public Properties getProperties() throws IOException{
		
		FileReader fileProperties = new FileReader("src/test/resources/application.properties");
		
		Properties properties = new Properties();
		properties.load(fileProperties);
		
		return new Properties();
		
		
	}
	


}
