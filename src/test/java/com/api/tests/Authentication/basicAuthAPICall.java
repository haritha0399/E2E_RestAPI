package com.api.tests.Authentication;

import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

import static org.hamcrest.Matchers.equalTo;

public class basicAuthAPICall {

	
	@Test
	public void basicAuth() {
		
		
		given()
		.header("Accept", "application/json")
		.auth().basic("username", "password")
		
		.when()
		.get("https://httpbin.org/basic-auth/username/password")
		
		.then()
		.body("authenticated", equalTo(true))
		.statusCode(200)
		.log().all();
		
	}

}
