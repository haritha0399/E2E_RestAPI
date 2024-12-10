package DDT;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class createUserPOSTAPIDDT {

	@DataProvider(name  = "createUserDDT")
	public Object[][] DDT(){
		Object[][] requestBody = new Object[4][4];
		
		requestBody[0][0] = "Mounika11";
		requestBody[0][1] = "mounika11@ulearn.com";
		requestBody[0][2] = "female";
		requestBody[0][3] = "active";
		
		requestBody[1][0] = "Harry1";
		requestBody[1][1] = "harry11@ulearn.com";
		requestBody[1][2] = "female";
		requestBody[1][3] = "inactive";
		
		requestBody[2][0] = "Aravindh11";
		requestBody[2][1] = "aravindh11@ulearn.com";
		requestBody[2][2] = "male";
		requestBody[2][3] = "active";
		
		requestBody[3][0] = "Ambrish11";
		requestBody[3][1] = "ambrish1@ulearn.com";
		requestBody[3][2] = "male";
		requestBody[3][3] = "active";
		
		return requestBody;
	}
	
	@Test(dataProvider = "createUserDDT")
	public void createUserPostAPIdataDrivenAutomationTest(String name,String email, String gender, String status)
	{
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
