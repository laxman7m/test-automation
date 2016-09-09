package playAround;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.UserActions;

public class PlayAround_extentReport {

	@FindBy(id = "selenium_commands")
	WebElement multiselect;
	@FindBy(id = "button1")
	WebElement buttn;
	@FindBy(xpath = "//*[@id='content']/p[11]/button")
	WebElement butn;
	
	ExtentReports extent;
	ExtentTest parent;
	ExtentTest child;
	
	@BeforeSuite
	public void beforeClass(ITestContext arg0){
		
	}
	
	@AfterSuite
	public void afterSuite(){

	}
	
	@BeforeTest
	public void beforeTest(ITestContext arg0){
		String extentReportFile = System.getProperty("user.dir") + "\\extentReportFile.html";
		extent = new ExtentReports(extentReportFile, false);
		String testName = arg0.getName();
		parent = extent.startTest(testName);
	}
	
	@AfterTest
	public void afterTest(){
		extent.endTest(parent);
		extent.flush();
		
	}
	
	@BeforeMethod
	public void beforeMethod(Method method){
		child = extent.startTest(method.getName());
	}
	
	@AfterMethod
	public void afterMethod(){
		parent.appendChild(child);
	}
	

	
	@Test
	public void Test() throws InterruptedException {
		
		child.log(LogStatus.INFO, "Test Step");
		
		/*String extentReportFile = System.getProperty("user.dir") + "\\extentReportFile.html";
		
		
		// Create object of extent report and specify the report file path.
		ExtentReports extent = new ExtentReports(extentReportFile, false);

		// Start the test using the ExtentTest class object.
		ExtentTest parent = extent.startTest("Parent");
		
		ExtentTest child1 = extent.startTest("Child1");
		child1.log(LogStatus.INFO, "Info");

		ExtentTest child2 = extent.startTest("Child1");
		child2.log(LogStatus.INFO, "Info");


		parent.appendChild(child1);
		parent.appendChild(child2);
		    
		extent.endTest(parent);
		
		
		// Start the test using the ExtentTest class object.
				ExtentTest parent1 = extent.startTest("Parent1");
				
				ExtentTest child3 = extent.startTest("Child3");
				child3.log(LogStatus.INFO, "Info");

				ExtentTest child4 = extent.startTest("Child4");
				child4.log(LogStatus.FAIL, "Info");


				parent1.appendChild(child3);
				parent1.appendChild(child4);
				    
				extent.endTest(parent);
		
		// writing everything to document. */
		//extent.flush();

	}

}
