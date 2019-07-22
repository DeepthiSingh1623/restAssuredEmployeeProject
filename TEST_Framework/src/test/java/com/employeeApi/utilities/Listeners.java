package com.employeeApi.utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners extends TestListenerAdapter
{
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext testContext)
	{
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/myReport.html");//Specify location
		
		//Look and feel of the report
		htmlReporter.config().setDocumentTitle("Automation Report"); // Title of the report
		htmlReporter.config().setReportName("REST API Testing Report"); // Name of the report
		htmlReporter.config().setTheme(Theme.DARK);
		
		//Info on the report
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("USER", "DIPTI");
			
	}
	
	//Test Results on the report 
	public void onTestSuccess(ITestResult result)
	{
		test = extent.createTest(result.getName()); // Create new entry in the report
		test.log(Status.PASS,"Test Case PASSED IS "+result.getName()); 
	}
	
	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.FAIL,"Test Case FAILED IS "+result.getName()); // to add name in extent Report
		test.log(Status.FAIL,"Test Case FAILED IS "+result.getThrowable());// to add error/exception in extent report
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}

}
