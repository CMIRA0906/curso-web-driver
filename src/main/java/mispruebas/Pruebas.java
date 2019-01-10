package mispruebas;

import io.restassured.RestAssured;

public class Pruebas {

	public Pruebas() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		//Validar estado de la aplicacion
		System.out.println(RestAssured.given().get("http://www.google.com").getStatusCode());
		
		System.out.println(RestAssured.given().get("https://restcountries.eu/rest/v2/alpha?codes=col;no;ee")
				.getBody().jsonPath().getString("translations"));
		
		System.out.println(RestAssured.given().get("https://restcountries.eu/rest/v2/alpha?codes=col;no;ee")
		.getBody().path("currencies", "code"));
		
		System.out.println(RestAssured.given().get("https://restcountries.eu/rest/v2/alpha?codes=col;no;ee")
				.getSessionId());
		
		
		
		System.out.println(RestAssured.given().get("https://restcountries.eu/rest/v2/alpha?codes=col;no;ee")
				.jsonPath().getJsonObject("currencies"));
		
		System.out.println(RestAssured.given().get("https://restcountries.eu/rest/v2/alpha?codes=col;no;ee")
				.jsonPath().getJsonObject("currencies"));
		
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}
