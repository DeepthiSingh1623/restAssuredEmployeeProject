package com.employeeApi.TestCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeApi.base.TestBase;
import com.employeeApi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC003_PostEmployeeRecord extends TestBase
{
	String empName = RestUtils.empName();
	String empSal = RestUtils.empSal();
	String empAge = RestUtils.emgAge();
	
	@BeforeClass
	public void createEmployeeRecord() throws InterruptedException
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		HttpRequest = RestAssured.given();
		
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("employee_name",empName);
		System.out.println(empName);
		jsonObj.put("employee_salary",empSal);
		System.out.println(empSal);
		jsonObj.put("employee_age",empAge);
		System.out.println(empAge);
		
		HttpRequest.header("Content-Type","application/json");
		
		HttpRequest.body(jsonObj.toJSONString());
		
		response = HttpRequest.request(Method.POST,"/create");
		
		Thread.sleep(10000);
		
	}
	
	@Test
	public void checkEmpCreatedRecord()
	{
		System.out.println("Checking Response Body");
		
		String ResponseBody = response.getBody().asString();
		
		System.out.println("The Response Body is "+ResponseBody);
		
		System.out.println(" The emp Name is "+empName);
		
		
		
		Assert.assertEquals(ResponseBody.contains(empName),true);
		Assert.assertEquals(ResponseBody.contains(empSal),true);
		Assert.assertEquals(ResponseBody.contains(empAge),true);
	}
	
	@Test
	public void checkStatusCode()
	{
		System.out.println("Checking Status Code");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

}
