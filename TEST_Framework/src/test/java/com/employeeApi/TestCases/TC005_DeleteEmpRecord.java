package com.employeeApi.TestCases;

import org.apache.http.HttpRequest;
import org.testng.annotations.AfterClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeApi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC005_DeleteEmpRecord extends TestBase
{
	
	@BeforeClass
	public void deleteEmployee() throws InterruptedException
	{
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		
		HttpRequest = RestAssured.given();
		
		response = HttpRequest.request(Method.GET,"/employees");
		
		JsonPath jsonPathEvalutor = response.jsonPath();
		
		String EmployeeID = jsonPathEvalutor.get("[0].id");
		
		System.out.println("The Employee ID is "+EmployeeID);
		
		response = HttpRequest.request(Method.DELETE,"/delete/"+EmployeeID);
		
		Thread.sleep(5000);
						
	}
	
	@Test
	public void checkResponseBody()
	{
		String ResponseBody = response.getBody().asString();
		
		System.out.println("The Response Body is "+ResponseBody);
		
		Assert.assertEquals(ResponseBody.contains("successfully! deleted Records"), true);
	}
	
		
	@AfterClass
	public void tearDown()
	{
		System.out.println("The Test 05 is completed successfully");
	}

}
