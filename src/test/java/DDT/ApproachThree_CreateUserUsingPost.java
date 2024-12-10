package DDT;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class ApproachThree_CreateUserUsingPost extends testDataForDDT {

	@Test(dataProvider = "deleteUserDDT")
	public void createUserPostAPIDDT(Object idToDelete) {
		
		
		given().
		header("Accept","application/json").
		header("Content-Type","application/json").
		header("Authorization", "Bearer c50af3b0ef5725c730da5847bfe8e5e11885dc878f9668a624af1062518a4fde").
		
		when().
		post("https://gorest.co.in/public/v2/"+idToDelete).
		
		then().
		statusCode(204).
		log().all();
	}
	
}
