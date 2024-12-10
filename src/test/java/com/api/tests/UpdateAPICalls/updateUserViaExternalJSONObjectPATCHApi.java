package com.api.tests.UpdateAPICalls;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class updateUserViaExternalJSONObjectPATCHApi {

	@Test
	public void updateUserAPI() throws FileNotFoundException {
	
		File file = new File(".\\patchRequestBody.json"); //file location
		FileReader fr = new FileReader(file); // read the file
		JSONTokener jt = new JSONTokener(fr); //break the contents ie. name = haritha
		
		
		JSONObject requestBody = new JSONObject(jt); // pass the tokens to the j
		
//		requestBody.put("name", "Allasani Peddana correction3");
//		requestBody.put("email", "allasani.peddana@18ce.com");
//		requestBody.put("status", "active");
		
		given().
		header("Accept","application/json").
		header("Content-Type","application/json").
		header("Authorization", "Bearer c50af3b0ef5725c730da5847bfe8e5e11885dc878f9668a624af1062518a4fde").
		
		when()
		.body(requestBody.toString())
		.patch("https://gorest.co.in/public/v2/users/7564183").
		
		then()
		.statusCode(200)
		.log().all();	
	
	}
}
