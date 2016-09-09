package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Config;
import utility.Log;
import utility.UserActions;

public class LoginPage extends BaseClass {

	// Page Objects
	@FindBy(id = "clientCode")
	static WebElement clientcodeTxt;
	@FindBy(id = "username")
	static WebElement usernameTxt;
	@FindBy(id = "password")
	static WebElement passwordTxt;
	@FindBy(xpath = "//button[@type='button']") //ot.client @FindBy(xpath = "//button[@type='submit']")
	static WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// set clientcode in textbox
	public static void setClientCode(String sClientCode) {
		UserActions.SendKeys(driver, clientcodeTxt, sClientCode, "ClientCode Text Box");
	}

	// set username in textbox
	public static void setUserName(String sUsername) {
		UserActions.SendKeys(driver, usernameTxt, sUsername, "Username Text Box");
	}

	// set password in textbox
	public static void setPassword(String sPassword) {
		UserActions.SendKeys(driver, passwordTxt, sPassword, "Password Text Box");
	}

	// click on login button
	public static void clickLogin() {
		UserActions.Click(driver, loginBtn, "Login Button");
	}

	// get login page title
	public static String getTitle() {
		String pageTitle = UserActions.GetPageTitle(driver);
		return pageTitle;
	}

	/**
	 * This method is used to login to the application.
	 */
	public static void login() {
		LoginPage.setClientCode(Config.Test_Client_ClientCode);
		LoginPage.setUserName(Config.Test_Client_Username);
		LoginPage.setPassword(Config.Test_Client_Password);
		LoginPage.clickLogin();
		Log.info("Login to the Test Application");
	}
}
