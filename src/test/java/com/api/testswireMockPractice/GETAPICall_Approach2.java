package com.api.testswireMockPractice;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class GETAPICall_Approach2 {

	
	@Test
	public void methodToMakeGETCall() {
		
		given()
		
		.when()
		.get("http://localhost:8080/viewFileContent").
		
		then()
		.statusCode(200)
		.log().all();
	}
}
