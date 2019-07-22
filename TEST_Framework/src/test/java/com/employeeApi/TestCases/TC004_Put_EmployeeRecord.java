package com.employeeApi.TestCases;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeApi.base.TestBase;
import com.employeeApi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC004_Put_EmployeeRecord extends TestBase
{
	String eName = RestUtils.empName();
	String eSal = RestUtils.empSal();
	String eAge = RestUtils.emgAge();
	
	@BeforeClass
	public void updateEmployee() throws InterruptedException
	{
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		HttpRequest = RestAssured.given();
		
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("employee_name", eName);
		System.out.println(eName);
		
		jsonObj.put("employee_salary", eSal);
		System.out.println(eSal);
		jsonObj.put("employee_age", eAge);
		System.out.println(eAge);
		
		HttpRequest.header("Content-Type","application/json");
		
		HttpRequest.body(jsonObj.toJSONString());
		
		response = HttpRequest.request(Method.PUT,"/update/"+empID);
		
		Thread.sleep(5000);
		
	}
	
	@Test
	public void checkResponseBody()
	{
		System.out.println("********Verifying the updated Data*********");
		
		String responseBody = response.getBody().asString();
		System.out.println("The Response Body is "+responseBody);
		//Assert.assertEquals(responseBody.contains(eName), true);
		//Assert.assertEquals(responseBody.contains(eSal), true);
		//Assert.assertEquals(responseBody.contains(eAge), true);
	}
	
	

}
