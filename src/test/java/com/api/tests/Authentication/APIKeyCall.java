package com.api.tests.Authentication;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class APIKeyCall {
	
	@Test
	public void apiLeyCallMethod1() {
		
			
			
			given()
			
			
			.when()
			.get("http://api.openweathermap.org/geo/1.0/direct?q=Chennai&appid=25245aa6b75dc2c6604ee1d6e8efd64e")
			
			.then()
		
			.statusCode(200)
			.log().all();
			
		}
	

	@Test
	public void apiLeyCallMethod2() {
			given()
			.pathParam("MyPath", "geo/1.0/direct")
			.queryParam("q","hyderabad" )
			.queryParam("appid", "25245aa6b75dc2c6604ee1d6e8efd64e")
			
			.when()
			.get("http://api.openweathermap.org/{MyPath}")
			
			.then()
		
			.statusCode(200)
			.log().all();
			
		}
}
