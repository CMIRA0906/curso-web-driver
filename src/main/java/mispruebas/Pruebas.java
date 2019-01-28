package mispruebas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.RestAssured;

public class Pruebas {

	public static final Logger LOGGER = LogManager.getLogger(Pruebas.class);

	public static void main(String[] args) {
		
	
		LOGGER.info(RestAssured.given().get("http://www.google.com").getStatusCode());
		
		LOGGER.info(RestAssured.given().get("https://restcountries.eu/rest/v2/alpha?codes=col;no;ee")
				.getBody().jsonPath().getString("translations"));
		
		
		


	}

}
