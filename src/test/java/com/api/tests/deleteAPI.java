package com.api.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class deleteAPI {
	
	@Test
	public void deleteUserAPI() {
		given().
		header("Accept","application/json").
		header("Content-Type","application/json").
		header("Authorization", "Bearer c50af3b0ef5725c730da5847bfe8e5e11885dc878f9668a624af1062518a4fde").
		
		when().
		delete("https://gorest.co.in/public/v2/users/7566925").
		
		then()
		.statusCode(204)
		.log().all();
		
	}

}
