package com.api.tests.Authentication;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;


//Outdated OAuth1 JUST SYNTAX
public class OAuth1APICall {

	@Test
	public void OAuthOneMethod() {
		
		given()
		.header("Accept", "application/json")
		.auth().oauth("consumeKey", "consumerSecret", "accessToken", "secretToken")
		
		.when()
		.get("API url goes here")
		
		.then()
		.body("authenticated", equalTo(true))
		.statusCode(200)
		.log().all();
	}
}
