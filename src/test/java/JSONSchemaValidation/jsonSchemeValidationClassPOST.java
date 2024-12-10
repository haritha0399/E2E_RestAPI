package JSONSchemaValidation;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class jsonSchemeValidationClassPOST {

	Faker fake = new Faker();
	@Test
	public void createUser() {
		
		
		HashMap <String, String> requestBody = new HashMap<>();
		requestBody.put("name", fake.name().fullName());
		requestBody.put("gender", fake.demographic().sex());
		requestBody.put("email", fake.internet().emailAddress());
		requestBody.put("status", "active");
		
		given().
		header("Accept","application/json").
		header("Content-Type","application/json").
		header("Authorization", "Bearer c50af3b0ef5725c730da5847bfe8e5e11885dc878f9668a624af1062518a4fde").
		
		when().
		body(requestBody).
		post("https://gorest.co.in/public/v2/users").
		
		then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonschemeValidationSyntaxForPost.json")).
		statusCode(201).
		log().all();
		}
}
