package DDT;

import org.testng.annotations.DataProvider;

public class testDataForDDT {

	@DataProvider (name = "createUserDDT")
	public Object[][] createUserDDT(){
		
		return new Object[][] {
			{"Haritha", "haritha@restassured.com", "female","active"},
			{"Vaishu", "vaishu@restassured.com", "female","inactive"},
			{"Vignesh", "vignesh@restassured.com", "male","active"},
			{"Vishnu", "vishnu@restassured.com", "male","inactive"}
		};
	}
	
	@DataProvider(name ="deleteUserDDT")
	public Object[] deleteUserDDT() {
		return new Object[] {
				 7576785, 7576787, 7576788, 7576789
		};
	}
}
