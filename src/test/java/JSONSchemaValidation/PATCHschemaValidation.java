package JSONSchemaValidation;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.module.jsv.JsonSchemaValidator;

public class PATCHschemaValidation {

	Faker fake = new Faker();
	
	@Test
	public void updateUserAPI() {
	
	 JSONObject requestBody = new JSONObject();
		
	    requestBody.put("name", fake.name().fullName());
		requestBody.put("email", fake.internet().emailAddress());
		requestBody.put("status", "active");
		
		given().
		header("Accept","application/json").
		header("Content-Type","application/json").
		header("Authorization", "Bearer c50af3b0ef5725c730da5847bfe8e5e11885dc878f9668a624af1062518a4fde").
		
		when()
		.body(requestBody.toString())
		.patch("https://gorest.co.in/public/v2/users/7564026").
		
		then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchemaValidatinSyntaxForPATCH.json"))
		.statusCode(200)
		.log().all();	
	
	}
}
