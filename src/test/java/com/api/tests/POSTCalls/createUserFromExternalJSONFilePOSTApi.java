package com.api.tests.POSTCalls;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class createUserFromExternalJSONFilePOSTApi {
	
	@Test
	public void postAPIUsingExternalFile() throws FileNotFoundException {

	File file = new File(".\\requestBody.json"); //file location
	FileReader fr = new FileReader(file); // read the file
	JSONTokener jt = new JSONTokener(fr); //break the contents ie. name = haritha
	
	
	JSONObject requestBody = new JSONObject(jt); // pass the tokens to the json object
	
	given().
	header("Accept","application/json").
	header("Content-Type","application/json").
	header("Authorization", "Bearer c50af3b0ef5725c730da5847bfe8e5e11885dc878f9668a624af1062518a4fde").
	
	when().
	body(requestBody.toString()). //passing jsonObject as string
	post("https://gorest.co.in/public/v2/users").
	
	then().
	statusCode(201).
	log().all();
}}
