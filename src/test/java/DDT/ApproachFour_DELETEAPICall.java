package DDT;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

public class ApproachFour_DELETEAPICall {

	@Parameters ({"idToDelete"})
	@Test
	public void deleteUser(int idToDelete) {
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
