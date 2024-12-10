package com.api.testswireMockPractice;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

public class GETAPICall {
	
	@Test
	public void methodToMakeGETCall() {
		
		given()
		
		.when()
		.get("http://localhost:8080/allCourses").
		
		then()
		.statusCode(200)
		.log().all();
	}

}
