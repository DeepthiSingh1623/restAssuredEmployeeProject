package com.employeeApi.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeApi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_GetAllEmployees extends TestBase
{
	
	@BeforeClass
	void getAllEmployees() throws InterruptedException
	{
		//logger.info("******Started TC01-Get All Employees**********");
		System.out.println("******Started TC01-Get All Employees**********");
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		HttpRequest = RestAssured.given();
		response = HttpRequest.request(Method.GET,"/employees");
		
		Thread.sleep(2000);
		
	}
	
	@Test
	void CheckResponseBody()
	{
		//logger.info("*********Checking Response Body************");
		System.out.println("*********Checking Response Body************");
		String responseBody = response.getBody().asString();
		System.out.println("The Response Body is: "+responseBody);
		//logger.info("The REsponse Body is: "+responseBody);
		Assert.assertTrue(responseBody!=null);
		
		
	}
	
	@Test
	void CheckStatusCode()
	{
		//logger.info("*********checking Status Code ");
		System.out.println("*********checking Status Code ************");
		int StatusCode = response.getStatusCode();
		System.out.println("The status Code is :"+StatusCode);
		//logger.info("The status Code is :"+StatusCode);
	}
	

}
