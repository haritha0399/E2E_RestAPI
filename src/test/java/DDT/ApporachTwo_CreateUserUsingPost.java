package DDT;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ApporachTwo_CreateUserUsingPost {
	
	@DataProvider (name = "createUserDDT")
	public Object[] DDT() {
		
		return new Object[][] {
			{"Haritha1", "haritha1@ciec.com", "female", "active"},
			{"Vaishnavi1", "vaishu1@ciec.com", "female", "active"},
			{"Kavitha1", "kavitha1@ciec.com", "male", "inactive"},
			{"Navane1", "navan1@ciec.com", "male", "active"},
		};
		
	}
	
	@Test (dataProvider = "createUserDDT" )
	public void createUserPostAPIMethodDDTUsingApproach2(String name, String email,
			String gender, String status) {
		
		JSONObject requestBody = new JSONObject();
		requestBody.put("name", name);
		requestBody.put("email", email);
		requestBody.put("gender", gender);
		requestBody.put("status", status);
		
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
