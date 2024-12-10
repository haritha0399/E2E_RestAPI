package DDT;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class createDELETEAPIDDT {

	@DataProvider(name  = "deleteUsersAPI")
	public Object DDT(){
		Object[] requestBody = new Object[4];
		
		requestBody[0] = "7575664";
		requestBody[1] = "7575665";
		requestBody[2] = "7575666";
		requestBody[3] = "7575667";
		
		return requestBody;
		
	}
	
	@Test (dataProvider = "deleteUsersAPI")
	public void deleteUserUsingDDTestingAutomation(Object ID) {
		
	
		
		given().
		header("Accept","application/json").
		header("Content-Type","application/json").
		header("Authorization", "Bearer c50af3b0ef5725c730da5847bfe8e5e11885dc878f9668a624af1062518a4fde").
		
		when().
		delete("https://gorest.co.in/public/v2/users/"+ID).
		
		then()
		.statusCode(204)
		.log().all();
		
	}
}
