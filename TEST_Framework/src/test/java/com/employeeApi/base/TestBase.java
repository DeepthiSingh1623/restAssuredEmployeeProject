package com.employeeApi.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase
{
	
	public static RequestSpecification HttpRequest;
	public static Response response;
	public String empID ="25115";
	
	
	//public Logger logger;
	
	@BeforeClass
	public void setup()
	{
		//configure logs to generate the LOGS
		//logger = logger.getLogger("EmployeesRestAPI"); // added Logger
		//PropertyConfigurator.configure("Log4j.properties"); //Added Logger
		//logger.setLevel(Level.DEBUG);
	}
	
	
}

