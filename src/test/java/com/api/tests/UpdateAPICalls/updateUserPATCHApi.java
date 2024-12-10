package com.api.tests.UpdateAPICalls;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class updateUserPATCHApi {

	@Test
	public void updateUserAPI() {
	
	 HashMap<String, String> requestBody = new HashMap<>();
		
		requestBody.put("name", "Allasani Peddana correction3");
		requestBody.put("email", "allasani.peddana@19ce.com");
		requestBody.put("status", "inactive");
		
		given().
		header("Accept","application/json").
		header("Content-Type","application/json").
		header("Authorization", "Bearer c50af3b0ef5725c730da5847bfe8e5e11885dc878f9668a624af1062518a4fde").
		
		when()
		.body(requestBody)
		.patch("https://gorest.co.in/public/v2/users/7564190").
		
		then()
		.statusCode(200)
		.log().all();	
	
	}
}
