package common;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import constantes.Constantes;


public class DataPropertiesManagement2 {
	
	
	
	public Properties getProperties() throws IOException{	
		
		FileReader fileProperties = new FileReader(Constantes.RUTA_PROPERTIES);
		
		Properties properties = new Properties();
		properties.load(fileProperties);
		
		return properties;
		
		

	}
	
	
	
	
	
	

}
