package playAround;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

import pages.BaseClass;
import utility.Config;
import utility.UserActions;
import utility.Utils;

public class PlayAround_WebDriver {
	public WebDriver driver;

	@Test
	public void Test() throws Exception{
	/*driver = Utils.OpenBrowser("Chrome");
	new BaseClass(driver);
	UserActions.GoToURL(driver, "http://only-testing-blog.blogspot.in/2014/01/textbox.html");*/
		
	Runtime.getRuntime().exec("E:\\automation\\veraction_automation\\resources\\UploadFile.exe");
	}
}
