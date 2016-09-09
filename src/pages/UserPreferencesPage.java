package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utility.Config;
import utility.Log;
import utility.UserActions;
import utility.Utils;

public class UserPreferencesPage extends BaseClass {
	
	public static String pageName = "User Preferences Page";
	public static String pageTitle = "";
	
	public UserPreferencesPage(WebDriver driver) {
		super(driver);
	}
	
	//Page Objects
	@FindBy(name="ContractServices") static WebElement contractservicesDropdown;
	@FindBy(className="containerheader") static WebElement serviceLabel;
	
	static String topFrameName = "TOPFRAME";
	static String bottonFrameName = "BOTTOMFRAME";
	
	/**
	 * This method is used to navigate to Prescan Manual Invoices Module.
	 */
	public static void gotoPrescanManualInvoices(){
		UserActions.SwitchToFrameWithNameIndex(driver, topFrameName);
		UserActions.SelectDropdownWithValue(driver, contractservicesDropdown, "Service Dropdown", "701");
		UserActions.SwitchToMainWindow(driver);
		Log.info("Navigate to Prescan Manual Invoices Module");
	}
	
	
	
		/*//UserActions.SelectDropDownValue(driver, contractservices, "Preferences Dropdown", "  >Prescan Manual Invoices", pageName, "VisibleText");
		UserActions.SwitchToMainFrame(driver);
		UserActions.SwitchToFrameByName(driver, "BOTTOMFRAME");
		Assert.assertTrue(UserActions.VerifyLabelText(driver, servicelabel, "Service Label", "Prescan Manual Entry", pageName),"Prescan Manual Entry page did not load successfully");
		UserActions.SwitchToMainFrame(driver); */

	/*public static boolean verifyPreferencesPageLoaded(){
		UserActions.SwitchToFrameByName(driver, "TOPFRAME");
		WebElement contractservicesRef = UserActions.FindElement(driver, contractservicesDropdown, "Select Preferences Dropdown", "Preferences Page");
		boolean disB =  contractservicesRef.isDisplayed();
		UserActions.SwitchToMainFrame(driver);
		return disB;
	}*/
	
	/**
	 * @param service
	 */
	/*public static void gotoPrescanManualInvoices(){
		UserActions.SwitchToFrameByName(driver, "TOPFRAME");
		UserActions.SelectDropDownValue(driver, contractservices, "Preferences Dropdown", "  >Prescan Manual Invoices", pageName, "VisibleText");
		UserActions.SwitchToMainFrame(driver);
		UserActions.SwitchToFrameByName(driver, "BOTTOMFRAME");
		Assert.assertTrue(UserActions.VerifyLabelText(driver, servicelabel, "Service Label", "Prescan Manual Entry", pageName),"Prescan Manual Entry page did not load successfully");
		UserActions.SwitchToMainFrame(driver);
	}
	
	
	public static void gotoUserPreferencs(){
		UserActions.SwitchToFrameByName(driver, "TOPFRAME");
		UserActions.SelectDropDownValue(driver, contractservices, "Preferences Dropdown", "  >My Preferences", pageName, "VisibleText");
		UserActions.SwitchToMainFrame(driver);
		UserActions.SwitchToFrameByName(driver, "BOTTOMFRAME");
		Assert.assertTrue(UserActions.VerifyLabelText(driver, servicelabel, "Service Label", "User Preferences", pageName),"User Preferences page did not load successfully");
		UserActions.SwitchToMainFrame(driver);
	}
	
	public static void gotoPrescanEditInvoice(){
		UserActions.SwitchToFrameByName(driver, "TOPFRAME");
		UserActions.SelectDropDownValue(driver, contractservices, "Preferences Dropdown", "  >Prescan Edit Invoice", pageName, "VisibleText");
		UserActions.SwitchToMainFrame(driver);
		//SeleniumWrappers.SwitchToFrameByName(driver, "BOTTOMFRAME");
		//Assert.assertTrue(SeleniumWrappers.VerifyLabelText(driver, servicelabel, "Service Label", "Prescan Edit Invoice", pageName),"Prescan Edit Invoice page did not load successfully");
		//SeleniumWrappers.SwitchToMainFrame(driver);
	}
	*/
	
	
	

}
