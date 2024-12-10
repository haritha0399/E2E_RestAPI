package com.api.tests.POSTCalls;

import java.util.HashMap;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class createUserPOSTapi {

	@Test
	public void createUser() {
		
		HashMap <String, String> requestBody = new HashMap<>();
		requestBody.put("name", "Restassured");
		requestBody.put("gender", "male");
		requestBody.put("email", "hell088@abc.com");
		requestBody.put("status", "active");
		
		Response response = given().
		header("Accept","application/json").
		header("Content-Type","application/json").
		header("Authorization", "Bearer c50af3b0ef5725c730da5847bfe8e5e11885dc878f9668a624af1062518a4fde").
		
		when().
		body(requestBody).
		post("https://gorest.co.in/public/v2/users");
		
//		then().
//		statusCode(201).
//		log().all();
		
		Assert.assertEquals(response.getStatusCode(), 201);
	}
}
