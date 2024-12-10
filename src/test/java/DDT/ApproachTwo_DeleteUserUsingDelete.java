package DDT;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ApproachTwo_DeleteUserUsingDelete {

	@DataProvider (name= "deleteUserDDT")
	public Object[] DDT() {
		return new Object[] {
				7576550, 7576551, 7576552, 7576553
		};
	}
	
	
	@Test(dataProvider = "deleteUserDDT")
	public void deleteUser(Object idToDelete) {
		
		System.out.println("ID to be deleted "+idToDelete);
		
		given().
		header("Accept","application/json").
		header("Content-Type","application/json").
		header("Authorization", "Bearer c50af3b0ef5725c730da5847bfe8e5e11885dc878f9668a624af1062518a4fde").
		
		when().
		delete("https://gorest.co.in/public/v2/"+idToDelete).
		
		then().
		statusCode(204).
		log().all();
	}
}
