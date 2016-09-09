package moduleKeywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.Config;
import utility.Log;
import utility.UserActions;

public class ModuleUtils {
	
	@FindBy(className="containerlabel") static WebElement moduleHeader;

	static String topFrameName = "TOPFRAME";
	static String bottonFrameName = "BOTTOMFRAME";
	
	public static boolean verifyModuleHeader(WebDriver driver, String expLabel){
		UserActions.SwitchToFrameByName(driver, bottonFrameName);
		boolean isPresent =  UserActions.VerifyLabelText(driver, moduleHeader, "Module Header", expLabel);
		UserActions.SwitchToMainWindow(driver);
		return isPresent;
	}

}
