package com.api.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class listUserGETAPI {

	@Test
	public void listUsersAPI() {

		given()
		.header("Accept", "application/json")
		.header("Content-Type","application/json")
		.header("Authorization","Bearer c50af3b0ef5725c730da5847bfe8e5e11885dc878f9668a624af1062518a4fde" );
		
		when()
		.get("https://gorest.co.in/public/v2/users").
		
		then()
		.statusCode(200)
//		.log().headers();	
		.body("gender", hasItems("male", "female"))
		.body("status", hasItems("active", "inactive"))
//		.body("[2].name", equalTo("Shwet Tandon"))
		.log().all();
	}
	
	

}
