package utility;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	public static WebDriver driver = null;
	private static XSSFSheet ExcelWSheet;
	
	/**
	 * @method WebDriver OpenBrowser
	 * @description This method will open the Browser.
	 * @param sBrowserName
	 * @return driver
	 * 
	 * @author Laxman.M
	 */
	public static WebDriver OpenBrowser(String sBrowserName) throws Exception {
		try {
			if (sBrowserName.equals("Mozilla")) {
				driver = new FirefoxDriver();
				UserActions.ImplicitlyWait(driver, Config.Implicit_Timeout);
				Log.info("New firefox driver instantiated");
				Log.info("Implicit wait set on the driver for "+Config.Implicit_Timeout+" seconds");
			}
			
			else if (sBrowserName.equals("Chrome")){
				System.setProperty("webdriver.chrome.driver", Config.Path_ChromeDriver);
				DesiredCapabilities capability = DesiredCapabilities.chrome();
				capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				driver = new ChromeDriver();
				Log.info("New chrome driver instantiated");
				Log.info("Implicit wait set on the driver for "+Config.Implicit_Timeout+" seconds");
			}
			else if (sBrowserName.equals("IE")){
				System.setProperty("webdriver.ie.driver", Config.Path_IEDriver);
				DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
				caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				caps.setCapability("EnableNativeEvents", false);
				caps.setCapability("ignoreZoomSetting", true);
				driver = new InternetExplorerDriver(caps);
				Log.info("New IE driver instantiated");
				Log.info("Implicit wait set on the driver for "+Config.Implicit_Timeout+" seconds");
			}
		} catch (Exception e) {
			Log.info("Exception in opening browser:"+e.getMessage()+" || Class: Utils | Method: OpenBrowser | Input: sBrowserName=" + sBrowserName);
		}
		return driver;
	}
	
	/**
	 * @method void TakeScreenshot
	 * @description This method will take a Screenshot.
	 * @param sTestCaseName
	 * 
	 * @author Laxman.M
	 */
	public static void TakeScreenshot(WebDriver driver, String sTestCaseName) throws Exception{
		try{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(Config.Path_ScreenShot + sTestCaseName +".jpg"));	
			Log.info("Screenshot created:"+Config.Path_ScreenShot + sTestCaseName +".jpg || Class: Utils | Method: TakeScreenshot | Input: sTestCaseName=" + sTestCaseName);
		} catch (Exception e){
			Log.info("Screenshot creation failed:"+e.getMessage()+" || Class: Utils | Method: TakeScreenshot | Input: sTestCaseName=" + sTestCaseName);
			throw new Exception();
		}
	}
	
	
	
	
	public static String generateInvoiceNumber(){
		Random rnd = new Random();
		int n = 100000000 + rnd.nextInt(900000000);
		String invnum = Integer.toString(n);
		Log.info("Generated Invoice Number: "+invnum);
		return invnum;
	}
	
	
	 public static String getTestCaseName(String sTestCase)throws Exception{
		 
	        String value = sTestCase;
	 
	        try{
	 
	            int posi = value.indexOf("@");
	 
	            value = value.substring(0, posi);
	 
	            posi = value.lastIndexOf(".");    
	 
	            value = value.substring(posi + 1);
	 
	            return value;
	 
	                }catch (Exception e){
	 
	            Log.error("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());
	 
	            throw (e);
	 
	        }

	 }
	 
	 
	 public static void mouseHoverAction(WebElement mainElement, String subElement){
			
		 Actions action = new Actions(driver);
         action.moveToElement(mainElement).perform();
         if(subElement.equals("Accessories")){
        	 action.moveToElement(driver.findElement(By.linkText("Accessories")));
        	 Log.info("Accessories link is found under Product Category");
         }
         if(subElement.equals("iMacs")){
        	 action.moveToElement(driver.findElement(By.linkText("iMacs")));
        	 Log.info("iMacs link is found under Product Category");
         }
         if(subElement.equals("iPads")){
        	 action.moveToElement(driver.findElement(By.linkText("iPads")));
        	 Log.info("iPads link is found under Product Category");
         }
         if(subElement.equals("iPhones")){
        	 action.moveToElement(driver.findElement(By.linkText("iPhones")));
        	 Log.info("iPhones link is found under Product Category");
         }
         action.click();
         action.perform();
         Log.info("Click action is performed on the selected Product Type");
	 }
	 
	 
	 
	 public static void waitForElement(WebElement element){
		 
		 WebDriverWait wait = new WebDriverWait(driver, 10);
	     wait.until(ExpectedConditions.elementToBeClickable(element));
	 }
	 
	 
	 
	 
	
}
