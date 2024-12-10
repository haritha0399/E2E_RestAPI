package com.api.tests.Authentication;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class OAuth2APICall {

	@Test
	public void OAuthOneMethod() {
		
		given()
		.header("Accept", "application/json")
		.auth().oauth2("enter your token")
		
		.when()
		.get("https://api.github.com/user/repos")
		
		.then()
		.statusCode(200)
		.log().all();
}}
