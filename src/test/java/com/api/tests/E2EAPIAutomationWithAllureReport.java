package com.api.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.module.jsv.JsonSchemaValidator;

@Epic("API chaining EPIC")
@Feature("Feature is achieve the API chaining using Faker Library")
public class E2EAPIAutomationWithAllureReport {;

	
Faker fake = new Faker();

int extractedID;
	
//create the User

   @Story("Create UserStory")
   @Step("POST Test Case")
   @Description("This API creates a new user using Faker library")
   @Severity(SeverityLevel.BLOCKER)
	@Test (priority = 0)
	public void createUser() {
		
		HashMap <String, String> requestBody = new HashMap<>();
		requestBody.put("name", fake.name().fullName());
		requestBody.put("gender",  fake.demographic().sex());
		requestBody.put("email", fake.internet().emailAddress());
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
	
   @Story("Verify User is created user story")
   @Step("GET Test Case")
   @Description("This API verifies if a new user using Faker library is created")
   @Severity(SeverityLevel.NORMAL)
	@Test (priority = 1 , dependsOnMethods = {"createUser"})
	public void verifyIfTheUserIsCreated() {

		given()
		.header("Accept", "application/json")
		.header("Content-Type","application/json")
		.header("Authorization","Bearer c50af3b0ef5725c730da5847bfe8e5e11885dc878f9668a624af1062518a4fde" ).
		
		when()
		.get("https://gorest.co.in/public/v2/users").
		
		then().
		assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchemaValidationSyntaxForGET.json")).
		statusCode(200)
		.log().headers()
//		.body("gender", hasItems("male", "female"))
//		.body("status", hasItems("active", "inactive"))
//		.body("[2].name", equalTo("Shwet Tandon"))
		.body("id", hasItems(extractedID))
		.log().all();
	}
	
   @Story("User updated user story")
   @Step("PATCH Test Case")
   @Description("This API verifies if a new user using Faker library is updated")
   @Severity(SeverityLevel.CRITICAL)
	@Test (priority =2 , dependsOnMethods = {"createUser"})
	public void updateUserAPI() {
	
	 HashMap<String, String> requestBody = new HashMap<>();
		
		requestBody.put("name", fake.name().fullName());
		requestBody.put("email", fake.internet().emailAddress());
		requestBody.put("status", "inactive");
		
		given().
		header("Accept","application/json").
		header("Content-Type","application/json").
		header("Authorization", "Bearer c50af3b0ef5725c730da5847bfe8e5e11885dc878f9668a624af1062518a4fde").
		
		when()
		.body(requestBody)
		.patch("https://gorest.co.in/public/v2/users/"+extractedID).
		
		then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchemaValidatinSyntaxForPATCH.json"))
		.statusCode(200)
		.log().all();	
	
	}
	
   @Story("Verify User is updated user story")
   @Step("PATCH Test Case")
   @Description("This API verifies if a new user using Faker library is updated")
   @Severity(SeverityLevel.NORMAL)
	@Test (priority = 3 , dependsOnMethods = {"createUser"})
	public void verifyIfTheUserIsUpdated() {

		given()
		.header("Accept", "application/json")
		.header("Content-Type","application/json")
		.header("Authorization","Bearer c50af3b0ef5725c730da5847bfe8e5e11885dc878f9668a624af1062518a4fde" ).
		
		when()
		.get("https://gorest.co.in/public/v2/users").
		
		then()
		.statusCode(200)
		.log().headers()
//		.body("gender", hasItems("male", "female"))
		.body("status", hasItems("active", "inactive"))
//		.body("[2].name", equalTo("Shwet Tandon"))
		.body("id", hasItems(extractedID))
		.log().all();
	}
	
   @Story("User deleted user story")
   @Step("DELTE Test Case")
   @Description("This API verifies if a new user using Faker library is deleted")
   @Severity(SeverityLevel.NORMAL)
	@Test (priority = 4, dependsOnMethods = {"createUser"})
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
	
   @Story("Verify User is deleted user story")
   @Step("DELETE Test Case")
   @Description("This API verifies if a new user using Faker library is deleted")
   @Severity(SeverityLevel.NORMAL)
	@Test (priority = 5 , dependsOnMethods = {"createUser"})
	public void verifyIfTheUserIsDeleted() {

		given()
		.header("Accept", "application/json")
		.header("Content-Type","application/json")
		.header("Authorization","Bearer c50af3b0ef5725c730da5847bfe8e5e11885dc878f9668a624af1062518a4fde" ).
		
		when()
		.get("https://gorest.co.in/public/v2/users").
		
		then()
		.statusCode(200)
		.log().headers()
//		.body("gender", hasItems("male", "female"))
//		.body("status", hasItems("active", "inactive"))
//		.body("[2].name", equalTo("Shwet Tandon"))
//		.body("id", hasItems(extractedID))
		.log().all();
	}

}
