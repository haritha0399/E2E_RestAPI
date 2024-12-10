package com.api.tests.Authentication;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class digestAutherizationAPICall {

	@Test
	public void digestAuth() {
		
		given()
		.header("Accept", "application/json")
		.auth().digest("user", "passwd")
		
		.when()
		.get("https://httpbin.org/digest-auth/auth/user/passwd")
		
		.then()
		.body("authenticated", equalTo(true))
		.statusCode(200)
		.log().all();
		
	}
	
	@Test
	public void digestAuth2() {
		
		given()
		.header("Accept", "application/json")
		.auth().digest("user", "passwd")
		
		.when()
		.get("https://httpbin.org/digest-auth/auth/user/passwd/MD5")
		
		.then()
		.body("authenticated", equalTo(true))
		.statusCode(200)
		.log().all();
		
	}
	
	@Test
	public void digestAuth3() {
		
		given()
		.header("Accept", "application/json")
		.auth().digest("user", "passwd")
		
		.when()
		.get("https://httpbin.org/digest-auth/auth/user/passwd/MD5/never")
		
		.then()
		.body("authenticated", equalTo(true))
		.statusCode(200)
		.log().all();
		
	}
	
	
}
