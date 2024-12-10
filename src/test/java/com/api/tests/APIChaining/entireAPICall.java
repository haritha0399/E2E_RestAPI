package com.api.tests.APIChaining;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;

public class entireAPICall {
	
	int extractedID;
	
	@Test (priority = 1)
	public void createUser() {
		
		HashMap <String, String> requestBody = new HashMap<>();
		requestBody.put("name", "Restassured");
		requestBody.put("gender", "male");
		requestBody.put("email", "hell062@abc.com");
		requestBody.put("status", "active");
		
		extractedID = 
		given().
		header("Accept","application/json").
		header("Content-Type","application/json").
		header("Authorization", "Bearer c50af3b0ef5725c730da5847bfe8e5e11885dc878f9668a624af1062518a4fde").
		
		when().
		body(requestBody).
		post("https://gorest.co.in/public/v2/users").
		jsonPath().getInt("id");
		
//		then().
//		statusCode(201).
//		log().all();
	}
	
	
//	@Test
//	public void listUsersAPI() {
//
//		given()
//		.header("Accept", "application/json")
//		.header("Content-Type","application/json")
//		.header("Authorization","Bearer c50af3b0ef5725c730da5847bfe8e5e11885dc878f9668a624af1062518a4fde" );
//		
//		when()
//		.get("https://gorest.co.in/public/v2/users").
//		
//		then()
//		.statusCode(200)
//		.log().headers();	
//		.body("gender", hasItems("male", "female"))
//		.body("status", hasItems("active", "inactive"))
////		.body("[2].name", equalTo("Shwet Tandon"))
//		.log().all();
//	}
	
	
	@Test (priority =2 , dependsOnMethods = {"createUser"})
	public void updateUserAPI() {
	
	 HashMap<String, String> requestBody = new HashMap<>();
		
		requestBody.put("name", "Kitty");
		requestBody.put("email", "allasani.peddana@89ce.com");
		requestBody.put("status", "active");
		
		given().
		header("Accept","application/json").
		header("Content-Type","application/json").
		header("Authorization", "Bearer c50af3b0ef5725c730da5847bfe8e5e11885dc878f9668a624af1062518a4fde").
		
		when()
		.body(requestBody)
		.patch("https://gorest.co.in/public/v2/users/"+extractedID).
		
		then()
		.statusCode(200)
		.log().all();	
	
	}
	
	@Test (priority = 3)
	public void deleteUserAPI() {
		given().
		header("Accept","application/json").
		header("Content-Type","application/json").
		header("Authorization", "Bearer c50af3b0ef5725c730da5847bfe8e5e11885dc878f9668a624af1062518a4fde").
		
		when().
		delete("https://gorest.co.in/public/v2/users/"+extractedID).
		
		then()
		.statusCode(204)
		.log().all();
		
	}

	
	
}

