package com.api.tests.Authentication;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class BearerTokenAPICall {

	
	@Test
	public void bearerTokenMethod() {
		given()
		.header("Accept", "application/json")
		.header("Authorization", "Bearer 1234")
		
		.when()
		.get("https://httpbin.org/bearer")
		
		.then()
		.body("authenticated", equalTo(true))
		.statusCode(200)
		.log().all();
	}
}
