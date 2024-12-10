package com.api.tests.SOAPTest;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class POSTAPICall {

	
	@SuppressWarnings("deprecation")
	@Test
	public void AddMethod() throws IOException {
		File file = new File("./src/test/resources/addRequestBodyForSOAP.xml");
		FileInputStream fileInputStream = new FileInputStream(file);
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
		
		
		given().
		header("Content-Type","text/xml; charset=utf-8").
		header("SOAPAction", "http://tempuri.org/Add")
		
		.when()
		.body(requestBody)
		.post("http://www.dneonline.com//calculator.asmx")
		
		.then()
		.statusCode(200)
		.body("//*:AddResult.text()", equalTo("20"))
		.log().all();
		
	}
	
	@Test
	public void subtractMethod() throws IOException {
		
		
		File file = new File("./src/test/resources/subtractRequestBodyForSOAP.xml");
		FileInputStream fileInputStream = new FileInputStream(file);
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
		
		given().
		header("Content-Type","text/xml; charset=utf-8").
		header("SOAPAction", "http://tempuri.org/Subtract")
		
		.when()
		.body(requestBody)
		.post("http://www.dneonline.com//calculator.asmx")
		
		.then()
		.statusCode(200)
		.body("//*:SubtractResult.text()", equalTo("15"))
		.log().all();
		
	}
	
	@Test
	public void multiplyMethod() throws IOException {
		
		
		File file = new File("./src/test/resources/multiplyRequestBodyForSOAP.xml");
		FileInputStream fileInputStream = new FileInputStream(file);
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
		
		given().
		header("Content-Type","text/xml; charset=utf-8").
		header("SOAPAction", "http://tempuri.org/Multiply")
		
		.when()
		.body(requestBody)
		.post("http://www.dneonline.com//calculator.asmx")
		
		.then()
		.statusCode(200)
		.body("//*:MultiplyResult.text()", equalTo("15"))
		.log().all();
		
		
	}
	
	@Test
	public void divideMethod() throws IOException {
		
		
		File file = new File("./src/test/resources/divideRequestBodyForSOAP.xml");
		FileInputStream fileInputStream = new FileInputStream(file);
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
		
		given().
		header("Content-Type","text/xml; charset=utf-8").
		header("SOAPAction", "http://tempuri.org/Divide")
		
		.when()
		.body(requestBody)
		.post("http://www.dneonline.com//calculator.asmx")
		
		.then()
		.statusCode(200)
		.body("//*:DivideResult.text()", equalTo("4"))
		.log().all();
		
		
		
	}
}
