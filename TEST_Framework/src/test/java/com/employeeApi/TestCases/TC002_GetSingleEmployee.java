package com.employeeApi.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeApi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC002_GetSingleEmployee extends TestBase
{
	
	@BeforeClass
	public void getSingleRecord() throws InterruptedException
	{
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		
		HttpRequest = RestAssured.given();
		
		response = HttpRequest.request(Method.GET,"/employee/"+empID);
		
		System.out.println("The Employee Record is "+empID);
		
		Thread.sleep(2000);
		
			
	}
	
	@Test
	public void CheckResponseBody()
	{
		String ResponseBody = response.getBody().asString();
		
		System.out.println("The Response Body is "+ResponseBody);
		
		Assert.assertEquals(ResponseBody.contains(empID),true);
	}
	
	@Test
	public void checkStatusCode()
	{
		int StatusCode = response.getStatusCode();
		
		System.out.println("The Status code is "+StatusCode);
		
		Assert.assertEquals(StatusCode, 200);
	}

}
