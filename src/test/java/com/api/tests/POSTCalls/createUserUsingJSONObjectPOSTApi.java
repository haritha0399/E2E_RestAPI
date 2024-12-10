package com.api.tests.POSTCalls;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class createUserUsingJSONObjectPOSTApi {

	@Test
	public void postViaJSONObject() {
		
	JSONObject requestBody = new JSONObject();
	
	requestBody.put("name","xyz");
	requestBody.put("email","abc@1243.com");
	requestBody.put("gender", "male");
	requestBody.put("status","active");
	
	given().
	header("Accept","application/json").
	header("Content-Type","application/json").
	header("Authorization", "Bearer c50af3b0ef5725c730da5847bfe8e5e11885dc878f9668a624af1062518a4fde").
	
	when().
	body(requestBody.toString()).
	post("https://gorest.co.in/public/v2/users").
	
	then().
	statusCode(201).
	log().all();
	}
}
