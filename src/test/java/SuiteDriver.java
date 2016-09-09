package test.java;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import moduleKeywords.ModuleUtils;
import pages.BaseClass;
import pages.LoginPage;
import pages.PrescanManualInvoicesPage;
import pages.UserPreferencesPage;
import utility.Config;
import utility.ExcelUtils;
import utility.Log;
import utility.UserActions;
import utility.Utils;

public class SuiteDriver {

	public WebDriver driver;
	protected String testName;
	protected String sTestCaseName;
	protected String sTestCaseDescription;
	protected int iTestCaseRow;
	public ExtentReports extent;
	public ExtentTest testModule;
	ExtentTest test;
	public String sExcelPath;
	public String dataFileName = "";
	
	@AfterSuite
	public void tearDownSuite(){
		extent.close();
	}

	@BeforeTest
	public void setUpTest(ITestContext test) throws Exception {
		//cleanup Files
		File extentreportFile = null;
		File logFile = null;
		
		extentreportFile = new File(Config.Path_ExtentReport);
		extentreportFile.delete();
		
		logFile = new File(Config.Path_logFile);
		logFile.delete();
		
		// Extent Report Configuration
		String extentReportFile = Config.Path_ExtentReport;
		extent = new ExtentReports(extentReportFile, false, NetworkMode.ONLINE);
		extent.loadConfig(new File(Config.Path_ExtentReportConfig));
		testName = test.getName();
		testModule = extent.startTest(testName); // **ExtentTest test =
													// extent.startTest("Test
													// Name", "Sample
													// description");

		DOMConfigurator.configure("log4j.xml");
		
		
		

		// Login to Test Application
		driver = Utils.OpenBrowser(Config.Browser_Name);
		new BaseClass(driver);
		UserActions.GoToURL(driver, Config.Test_Client_URL);
		String loginPageTitle = LoginPage.getTitle();
		Assert.assertEquals(loginPageTitle, "Client Portal Login | Veraction", "Login Page did not open successfully");
		testModule.log(LogStatus.PASS, "Navigated to Test Application: " + Config.Test_Client_URL);

		// Initialize Page Factory Objects
		PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, UserPreferencesPage.class);
		PageFactory.initElements(driver, PrescanManualInvoicesPage.class);
		PageFactory.initElements(driver, ModuleUtils.class);


		// Login to the Test Application
		LoginPage.login(); //**include Login Validation
		testModule.log(LogStatus.PASS, "Login Successful");
	}

	@AfterTest
	public void tearDownTest() {
		//Close the Browser
		driver.quit();

		// Extent Report Configuration
		extent.endTest(testModule);
		extent.flush();
	}

	@BeforeClass
	public void setUpClass() throws Exception {

	}

	@AfterClass
	public void tearDownClass() {

	}

	@BeforeMethod
	public void beforeTestCase(Method method) throws Exception {

		// Get test case name and description
		sTestCaseName = method.getName();
		sTestCaseDescription = method.getAnnotation(Test.class).description();

		// Start the test using the ExtentTest class object
		test = extent.startTest(sTestCaseName, sTestCaseDescription); // **Include
																		// category
																		// and
																		// author
																		// information

		// Log the test case
		Log.startTestCase(sTestCaseName);

		if (testName.equalsIgnoreCase("Prescan Manual Invoices")) {
			dataFileName = Config.File_PrescanManualInvoice_TestData;
		}


		String excelPath = Config.Path_TestData + dataFileName;
		ExcelUtils.setExcelFile(excelPath, "Sheet1");
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Config.Col_TestCaseName);
		sExcelPath = Config.Path_TestData + dataFileName;

		// Generate Random Invoice Numbers for Test Data
		String InvoiceNum1 = Utils.generateInvoiceNumber();
		ExcelUtils.setCellData(sExcelPath, InvoiceNum1, iTestCaseRow, ExcelUtils.getColContains(0, "I_sInvoiceNum1"));
		String InvoiceNum2 = Utils.generateInvoiceNumber();
		ExcelUtils.setCellData(sExcelPath, InvoiceNum2, iTestCaseRow, ExcelUtils.getColContains(0, "I_sInvoiceNum2"));

	}

	@AfterMethod
	public void afterTestCase() {
		testModule.appendChild(test);
		Log.endTestCase(sTestCaseName);
	}

}
