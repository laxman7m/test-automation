package utility;

import pages.BaseClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

/**
 * @author Laxman.M
 * @creationdate 19Aug2016
 * @description This class will contain the wrapper methods for selenium core
 *              actions.
 *
 */
public class UserActions {

	static SoftAssert s_assert = new SoftAssert();

	/************************ BROWSER COMMANDS ***************************/
	/*********************************************************************/

	/**
	 * @method void GoToURL
	 * @description This method loads a new web page in the current browser
	 *              window. Accepts string as a parameter and returns nothing.
	 * @param driver
	 * @param url
	 * 
	 * @author Laxman.M
	 */
	public static void GoToURL(WebDriver driver, String url) {
		driver.get(url);
		Log.info("Web Page Opened || Class: UserActions | Method: GoToURL | Input: Url=" + url);
	}

	/**
	 * @method String GetPageTitle
	 * @description This method fetches the title of the current page. Accepts
	 *              nothing as a parameter and returns a string value.
	 * @param driver
	 * @return pageTitle
	 * 
	 * @author Laxman.M
	 */
	public static String GetPageTitle(WebDriver driver) {
		String pageTitle = driver.getTitle();
		Log.info("Page Title: " + pageTitle + " || Class: UserActions | Method: GetPageTitle | Input: null");
		return pageTitle;
	}

	/**
	 * @method String GetCurrentURL
	 * @description This method fetches the string representing the current url
	 *              which is opened in the browser. Accepts nothing as a
	 *              parameter and returns a string value.
	 * @param driver
	 * @return currentURL
	 * 
	 * @author Laxman.M
	 */
	public static String GetCurrentURL(WebDriver driver) {
		String currentURL = driver.getCurrentUrl();
		Log.info("Current URL: " + currentURL + " || Class: UserActions | Method: GetCurrentURL | Input: null");
		return currentURL;
	}

	/**
	 * @method String GetPageSource
	 * @description This method returns the source code of the page. Accepts
	 *              nothing as a parameter and returns a string value.
	 * @param driver
	 * @return pageSource
	 * 
	 * @author Laxman.M
	 */
	public static String GetPageSource(WebDriver driver) {
		String pageSource = driver.getPageSource();
		Log.info("Page Source: " + pageSource + " || Class: UserActions | Method: GetPageSource | Input: null");
		return pageSource;
	}

	/**
	 * @method void Close
	 * @description This method closes the current window the webdriver is
	 *              currently controlling. Accepts nothing as a parameter and
	 *              returns nothing.
	 * @param driver
	 * @return null
	 * 
	 * @author Laxman.M
	 */
	public static void Close(WebDriver driver) {
		driver.close();
		Log.info("Closed Driver Instance || Class: UserActions | Method: Close | Input: null");
	}

	/**
	 * @method void Quit
	 * @description This method closes all windows opened by the webdriver.
	 *              Accepts nothing as a parameter and returns nothing.
	 * @param driver
	 * @return null
	 * 
	 * @author Laxman.M
	 */
	public static void Quit(WebDriver driver) {
		driver.quit();
		Log.info("Quit Driver Instance || Class: UserActions | Method: Quit | Input: null");
	}

	/******************* BROWSER NAVIGATION COMMANDS *********************/
	/*********************************************************************/

	/**
	 * @method void OpenWebPage
	 * @description This method loads a new web page in the current browser
	 *              window. Accepts string as a parameter and returns nothing.
	 * @param driver
	 * @param url
	 * 
	 * @author Laxman.M
	 */
	public static void OpenWebPage(WebDriver driver, String url) {
		driver.navigate().to(url);
		Log.info("New Web Page Opened || Class: UserActions | Method: OpenWebPage | Input: Url=" + url);
	}

	/**
	 * @method void Forward
	 * @description This method does the same operation as clicking on the
	 *              forward button of any browser. It neither accepts nor
	 *              returns anything.
	 * @param driver
	 * 
	 * @author Laxman.M
	 */
	public static void Forward(WebDriver driver) {
		driver.navigate().forward();
		Log.info("Forwared by one page on the Browser's History || Class: UserActions | Method: Forward | Input: null");
	}

	/**
	 * @method void Back
	 * @description This method does the same operation as clicking on the back
	 *              button of any browser. It neither accepts nor returns
	 *              anything.
	 * @param driver
	 * 
	 * @author Laxman.M
	 */
	public static void Back(WebDriver driver) {
		driver.navigate().back();
		Log.info("Back by one page on the Browser's History || Class: UserActions | Method: Back | Input: null");
	}

	/**
	 * @method void Refresh
	 * @description This method does the same operation as clicking on the
	 *              refresh button of any browser. It neither accepts nor
	 *              returns anything.
	 * @param driver
	 * 
	 * @author Laxman.M
	 */
	public static void Refresh(WebDriver driver) {
		driver.navigate().refresh();
		Log.info("Refresh the Web Page || Class: UserActions | Method: Refresh | Input: null");
	}

	/************************* WEBELEMENT COMMANDS ***********************/
	/*********************************************************************/

	/**
	 * @method void Clear
	 * @description If the element is a text entry element, this will clear the
	 *              value. This method accepts nothing as a parameter and
	 *              returns nothing.
	 * @param driver
	 * @param element
	 * @param elementName
	 * 
	 * @author Laxman.M
	 */
	public static void Clear(WebDriver driver, WebElement element, String elementName) {
		element.clear();
		Log.info("Clear text from " + elementName + " || Class: UserActions | Method: Clear | Input: elementName"
				+ elementName);
	}

	/**
	 * @method void SendKeys
	 * @description This simulates typing into an element, which may set its
	 *              value. This method accepts charsequence as a parameter and
	 *              returns nothing.
	 * @param driver
	 * @param element
	 * @param strInput
	 * @param elementName
	 * 
	 * @author Laxman.M
	 */
	public static void SendKeys(WebDriver driver, WebElement element, String strInput, String elementName) {
		element.sendKeys(strInput);
		Log.info(
				strInput + " entered in " + elementName + " || Class: UserActions | Method: SendKeys | Input: strInput="
						+ strInput + " & elementName=" + elementName);
	}

	/**
	 * @method void Click
	 * @description This simulates the clicking on any element. Accepts nothing
	 *              as a parameter and returns nothing.
	 * @param driver
	 * @param element
	 * @param elementName
	 * 
	 * @author Laxman.M
	 */
	public static void Click(WebDriver driver, WebElement element, String elementName) {
		element.click();
		Log.info("Clicked on " + elementName + " || Class: UserActions | Method: Click | Input: elementName="
				+ elementName);
	}

	/**
	 * @method boolean IsDisplayed
	 * @description This method determines if an element is currently being
	 *              displayed or not. This accepts nothing as a parameter but
	 *              returns boolean(true/false). This refers the property of the
	 *              element, sometimes the element is present on the page but
	 *              the property of the element is set to hidden, in that case
	 *              this will return false.
	 * @param driver
	 * @param element
	 * @param elementName
	 * @return booleanIsDisplayed
	 * 
	 * @author Laxman.M
	 */
	public static boolean IsDisplayed(WebDriver driver, WebElement element, String elementName) {
		boolean booleanIsDisplayed = element.isDisplayed();
		if (booleanIsDisplayed) {
			Log.info("Output: isDisplayed=" + booleanIsDisplayed
					+ "|| Class: UserActions | Method: IsDisplayed | Input: elementName=" + elementName);
			return true;
		} else {
			Log.info("Output: isDisplayed=" + booleanIsDisplayed
					+ "|| Class: UserActions | Method: IsDisplayed | Input: elementName=" + elementName);
			return false;
		}

	}

	/**
	 * @method boolean IsEnabled
	 * @description This determines if the element currently is Enabled or not?
	 *              This accepts nothing as a parameter but returns boolean
	 *              value(true/false).
	 * @param driver
	 * @param element
	 * @param elementName
	 * @return booleanIsEnabled
	 * 
	 * @author Laxman.M
	 */
	public static boolean IsEnabled(WebDriver driver, WebElement element, String elementName) {
		boolean booleanIsEnabled = element.isEnabled();
		if (booleanIsEnabled) {
			Log.info("Output: isEnabled=" + booleanIsEnabled
					+ "|| Class: UserActions | Method: IsEnabled | Input: elementName=" + elementName);
			return true;
		} else {
			Log.info("Output: isEnabled=" + booleanIsEnabled
					+ "|| Class: UserActions | Method: isEnabled | Input: elementName=" + elementName);
			return false;
		}
	}

	/**
	 * @method boolean IsSelected
	 * @description This determines whether or not this element is selected or
	 *              not. This accepts nothing as a parameter but returns boolean
	 *              value(true/false).
	 * @param driver
	 * @param element
	 * @param elementName
	 * @return booleanIsSelected
	 * 
	 * @author Laxman.M
	 */
	public static boolean IsSelected(WebDriver driver, WebElement element, String elementName) {
		boolean booleanIsSelected = element.isSelected();
		if (booleanIsSelected) {
			Log.info("Output: IsSelected=" + booleanIsSelected
					+ "|| Class: UserActions | Method: IsSelected | Input: elementName=" + elementName);
			return true;
		} else {
			Log.info("Output: IsSelected=" + booleanIsSelected
					+ "|| Class: UserActions | Method: IsSelected | Input: elementName=" + elementName);
			return false;
		}
	}

	/**
	 * @method void Submit
	 * @description This method works well/better than the click() if the
	 *              current element is a form, or an element within a form. This
	 *              accepts nothing as a parameter and returns nothting.
	 * @param driver
	 * @param element
	 * @param elementName
	 * @return null
	 * 
	 * @author Laxman.M
	 */
	public static void Submit(WebDriver driver, WebElement element, String elementName) {
		element.submit();
		Log.info("Click Submit on " + elementName + " || Class: UserActions | Method: Submit | Input: elementName="
				+ elementName);
	}

	/**
	 * @method String GetText
	 * @description This method will fetch the visible(i.e. not hidden by CSS)
	 *              innerText of the element. This accepts nothing as a
	 *              parameter but returns a String value.
	 * @param driver
	 * @param element
	 * @param elementName
	 * @return innerText
	 * 
	 * @author Laxman.M
	 */
	public static String GetText(WebDriver driver, WebElement element, String elementName) {
		String innerText = element.getText();
		Log.info("Output: innerText=" + innerText + "|| Class: UserActions | Method: GetText | Input: elementName="
				+ elementName);
		return innerText;
	}

	/**
	 * @method String GetTagName
	 * @description This method gets the tag name of this element. This accepts
	 *              nothing as a parameter and returns a string value.
	 * @param driver
	 * @param element
	 * @param elementName
	 * @return tagName
	 * 
	 * @author Laxman.M
	 */
	public static String GetTagName(WebDriver driver, WebElement element, String elementName) {
		String tagName = element.getTagName();
		Log.info("Output: tagName=" + tagName + "|| Class: UserActions | Method: GetTagName | Input: elementName="
				+ elementName);
		return tagName;
	}

	/**
	 * @method String GetCSSValue
	 * @description This method fetch css property value of the given element.
	 *              This accepts property name as parameter and returns a string
	 *              value.
	 * @param driver
	 * @param element
	 * @param elementName
	 * @param propertyName
	 * @return cssValue
	 * 
	 * @author Laxman.M
	 */
	public static String GetCSSValue(WebDriver driver, WebElement element, String elementName, String propertyName) {
		String cssValue = element.getCssValue(propertyName);
		Log.info("Output: cssValue=" + cssValue + "|| Class: UserActions | Method: GetCSSValue | Input: elementName="
				+ elementName + " & propertyName=" + propertyName);
		return cssValue;
	}

	/**
	 * @method String GetAttribute
	 * @description This method fetch css property value of the given element.
	 *              This accepts property name as parameter and returns a string
	 *              value.
	 * @param driver
	 * @param element
	 * @param elementName
	 * @param propertyName
	 * @return attributeValue
	 * 
	 * @author Laxman.M
	 */
	public static String GetAttribute(WebDriver driver, WebElement element, String elementName, String propertyName) {
		String attributeValue = element.getAttribute(propertyName);
		Log.info("Output: attributeValue=" + attributeValue
				+ "|| Class: UserActions | Method: GetAttribute | Input: elementName=" + elementName
				+ " & propertyName=" + propertyName);
		return attributeValue;
	}

	/**
	 * @method HashMap<String,Integer> GetSize
	 * @description This method fetch the width and height of the rendered
	 *              element. This accepts nothing as a parameter and returns the
	 *              Dimension oject.
	 * @param driver
	 * @param element
	 * @param elementName
	 * @return sizeWidthHeighPair
	 * 
	 * @author Laxman.M
	 */
	public static HashMap<String, Integer> GetSize(WebDriver driver, WebElement element, String elementName) {
		Dimension sizeWidthHeight = element.getSize();
		HashMap<String, Integer> sizeWidthHeighPair = new HashMap<String, Integer>();
		sizeWidthHeighPair.put("Width", sizeWidthHeight.width);
		sizeWidthHeighPair.put("Height", sizeWidthHeight.height);
		Log.info("Output: Size=" + sizeWidthHeighPair + "|| Class: UserActions | Method: GetSize | Input: elementName="
				+ elementName);
		return sizeWidthHeighPair;
	}

	/**
	 * @method HashMap<String,Integer> GetLocation
	 * @description This method locate the location of the element on the page.
	 *              This accepts nothing as a parameter but returns the point
	 *              object.
	 * @param driver
	 * @param element
	 * @param elementName
	 * @return sizeWidthHeighPair
	 * 
	 * @author Laxman.M
	 */
	public static HashMap<String, Integer> GetLocation(WebDriver driver, WebElement element, String elementName) {
		Point locationXY = element.getLocation();
		HashMap<String, Integer> locationXYPair = new HashMap<String, Integer>();
		locationXYPair.put("Xcoordinate", locationXY.x);
		locationXYPair.put("Ycoordinate", locationXY.y);
		Log.info("Output: Location=" + locationXYPair
				+ "|| Class: UserActions | Method: GetLocation | Input: elementName=" + elementName);
		return locationXYPair;
	}

	/**************** CHECKBOX AND RADIO BUTTON COMMANDS *****************/
	/*********************************************************************/

	/**
	 * @method void SelectCheckbox
	 * @description This method will select a checkbox.
	 * @param driver
	 * @param element
	 * @param elementName
	 * 
	 * @author Laxman.M
	 */
	public static void SelectCheckbox(WebDriver driver, WebElement element, String elementName) {
		if (!(UserActions.IsSelected(driver, element, "checkbox"))) {
			UserActions.Click(driver, element, "Checkbox");
		} else {
			Log.info(elementName
					+ " is already selected || Class: UserActions | Method: SelectCheckbox | Input: elementName="
					+ elementName);
		}
	}

	/**
	 * @method void DeselectCheckbox
	 * @description This method will unselect a checkbox.
	 * @param driver
	 * @param element
	 * @param elementName
	 * 
	 * @author Laxman.M
	 */
	public static void DeselectCheckbox(WebDriver driver, WebElement element, String elementName) {
		if (UserActions.IsSelected(driver, element, "checkbox")) {
			UserActions.Click(driver, element, "Checkbox");
		} else {
			Log.info(elementName
					+ " is already unselected || Class: UserActions | Method: DeselectCheckbox | Input: elementName="
					+ elementName);
		}
	}

	/**
	 * @method void SelectRadiobuttonWithValue
	 * @description This method will select radio button with specific value.
	 * @param driver
	 * @param element
	 * @param elementName
	 * @param value
	 * 
	 * @author Laxman.M
	 */
	public static void SelectRadiobuttonWithValue(WebDriver driver, List<WebElement> elements, String elementName,
			String value) {
		int size = elements.size();
		for (int i = 0; i < size; i++) {
			String sValue = UserActions.GetAttribute(driver, elements.get(i), elementName, value);
			if (sValue.equalsIgnoreCase(value)) {
				UserActions.Click(driver, elements.get(i), elementName);
				Log.info("Selected radio button with value " + value
						+ " || Class: UserActions | Method: SelectRadiobuttonWithValue | Input: elementName="
						+ elementName + " & value=" + value);
				break;
			}
		}
	}

	/****** DROPDOWN AND MULTIPLE SELECT OPERATIONS COMMANDS *************/
	/*********************************************************************/

	/**
	 * @method void SelectDropdownWithVisibleText
	 * @description This method will select dropdown value with specific visible
	 *              text.
	 * @param driver
	 * @param element
	 * @param elementName
	 * @param visibleText
	 * 
	 * @author Laxman.M
	 */
	public static void SelectDropdownWithVisibleText(WebDriver driver, WebElement element, String elementName,
			String visibleText) {
		Select oSelect = new Select(element);
		oSelect.selectByVisibleText(visibleText);
		Log.info("Selected dropdown with value " + visibleText
				+ " || Class: UserActions | Method: SelectDropdownWithVisibleText | Input: elementName=" + elementName
				+ " & visibleText=" + visibleText);
	}

	/**
	 * @method void SelectDropdownWithIndex
	 * @description This method will select dropdown value at specific index.
	 * @param driver
	 * @param element
	 * @param elementName
	 * @param index
	 * 
	 * @author Laxman.M
	 */
	public static void SelectDropdownWithIndex(WebDriver driver, WebElement element, String elementName, int index) {
		Select oSelect = new Select(element);
		oSelect.selectByIndex(index);
		Log.info("Selected dropdown value at index " + index
				+ " || Class: UserActions | Method: SelectDropdownWithIndex | Input: elementName=" + elementName
				+ " & index=" + index);
	}

	/**
	 * @method void SelectDropdownWithValue
	 * @description This method will select dropdown with specific value.
	 * @param driver
	 * @param element
	 * @param elementName
	 * @param value
	 * 
	 * @author Laxman.M
	 */
	public static void SelectDropdownWithValue(WebDriver driver, WebElement element, String elementName, String value) {
		Select oSelect = new Select(element);
		oSelect.selectByValue(value);
		Log.info("Selected dropdown with value " + value
				+ " || Class: UserActions | Method: SelectDropdownWithValue | Input: elementName=" + elementName
				+ " & value=" + value);
	}

	/**
	 * @method List<WebElement> GetDropdownList
	 * @description This method will return all the options belonging to the
	 *              select tag. It takes no parameter and returns
	 *              List<WebElement>.
	 * @param driver
	 * @param element
	 * @param elementName
	 * @return dropdownElements
	 * 
	 * @author Laxman.M
	 */
	public static List<WebElement> GetDropdownList(WebDriver driver, WebElement element, String elementName) {
		Select oSelect = new Select(element);
		List<WebElement> dropdownElements = oSelect.getOptions();
		Log.info("Output: dropdownElements=" + dropdownElements
				+ " || Class: UserActions | Method: GetDropdownList | Input: elementName=" + elementName);
		return dropdownElements;
	}

	/**
	 * @method int GetDropdownCount
	 * @description This method will return number of options in dropdown.
	 * @param driver
	 * @param element
	 * @param elementName
	 * @return dropdownCount
	 * 
	 * @author Laxman.M
	 */
	public static int GetDropdownCount(WebDriver driver, WebElement element, String elementName) {
		List<WebElement> dropdownElements = UserActions.GetDropdownList(driver, element, elementName);
		int dropdownCount = dropdownElements.size();
		Log.info("Output: dropdownCount=" + dropdownCount
				+ " || Class: UserActions | Method: GetDropdownCount | Input: elementName=" + elementName);
		return dropdownCount;
	}

	/**
	 * @method List<String> GetDropdownValues
	 * @description This method will return the list of all values in dropdown.
	 * @param driver
	 * @param element
	 * @param elementName
	 * @return dropdownValues
	 * 
	 * @author Laxman.M
	 */
	public static List<String> GetDropdownValues(WebDriver driver, WebElement element, String elementName) {
		List<WebElement> dropdownElements = UserActions.GetDropdownList(driver, element, elementName);

		ArrayList<String> dropdownValues = new ArrayList<String>();
		for (int i = 0; i < dropdownElements.size(); i++) {
			dropdownValues.add(dropdownElements.get(i).getText());
		}
		Log.info("Output: dropdownValues=" + dropdownValues
				+ " || Class: UserActions | Method: GetDropdownValues | Input: elementName=" + elementName);
		return dropdownValues;
	}

	/**
	 * @method void DeselectAll
	 * @description This method will clear all selected entries in the dropdown.
	 * @param driver
	 * @param element
	 * @param elementName
	 * 
	 * @author Laxman.M
	 */
	public static void DeselectAll(WebDriver driver, WebElement element, String elementName) {
		Select oSelect = new Select(element);
		oSelect.deselectAll();
		Log.info("Deselected entire dropdown || Class: UserActions | Method: DeselectAll | Input: elementName="
				+ elementName);
	}

	/**
	 * @method void DeselectByIndex
	 * @description This method will deselect the value at specified index.
	 * @param driver
	 * @param element
	 * @param elementName
	 * @param index
	 * 
	 * @author Laxman.M
	 */
	public static void DeselectByIndex(WebDriver driver, WebElement element, String elementName, int index) {
		Select oSelect = new Select(element);
		oSelect.deselectByIndex(index);
		Log.info("Deselected dropdown value at index " + index
				+ " || Class: UserActions | Method: DeselectByIndex | Input: elementName=" + elementName + " & index="
				+ index);
	}

	/**
	 * @method void DeselectByValue
	 * @description This method will deselect the dropdown at specified value .
	 * @param driver
	 * @param element
	 * @param elementName
	 * @param value
	 * 
	 * @author Laxman.M
	 */
	public static void DeselectByValue(WebDriver driver, WebElement element, String elementName, String value) {
		Select oSelect = new Select(element);
		oSelect.deselectByValue(value);
		Log.info("Deselected dropdown with value " + value
				+ " || Class: UserActions | Method: DeselectByValue | Input: elementName=" + elementName + " & value="
				+ value);
	}

	/**
	 * @method void DeselectByVisibleText
	 * @description This method will deselect the dropdown at specified value.
	 * @param driver
	 * @param element
	 * @param elementName
	 * @param visibleText
	 * 
	 * @author Laxman.M
	 */
	public static void DeselectByVisibleText(WebDriver driver, WebElement element, String elementName,
			String visibleText) {
		Select oSelect = new Select(element);
		oSelect.deselectByVisibleText(visibleText);
		Log.info("Deselected dropdown with text " + visibleText
				+ " || Class: UserActions | Method: DeselectByVisibleText | Input: elementName=" + elementName
				+ " & visibleText=" + visibleText);
	}

	/**
	 * @method boolean IsMultipleSelect
	 * @description This method tells whether the select element supports
	 *              multiple selecting options at the same time or not. This
	 *              accepts nothing and returns boolean(true/false).
	 * @param driver
	 * @param element
	 * @param elementName
	 * 
	 * @author Laxman.M
	 */
	public static boolean IsMultipleSelect(WebDriver driver, WebElement element, String elementName) {
		Select oSelect = new Select(element);
		boolean isMultipleSelect = oSelect.isMultiple();
		Log.info("Output: isMultipleSelect=" + isMultipleSelect
				+ " || Class: UserActions | Method: IsMultipleSelect | Input: elementName=" + elementName);
		return isMultipleSelect;
	}

	/*********************** WEBDRIVER WAIT COMMANDS *********************/
	/*********************************************************************/

	/**
	 * @method void ImplicitlyWait
	 * @description This method will wait for certain amount of time before
	 *              throwing exception that it cannot find the element on the
	 *              page.
	 * @param driver
	 * @param timeoutSec
	 * 
	 * @author Laxman.M
	 */
	public static void ImplicitlyWait(WebDriver driver, int timeoutSec) {
		driver.manage().timeouts().implicitlyWait(timeoutSec, TimeUnit.SECONDS);
		Log.info("Implicit wait applied on the driver for " + timeoutSec
				+ " seconds || Class: UserActions | Method: ImplicitlyWait | Input: timeoutSec=" + timeoutSec);
	}
	
	/**
	 * @method void WaitForElementPresent
	 * @description This method will wait for element to be clickable for certain amount of time before
	 *              throwing exception that it cannot find the element on the
	 *              page.
	 * @param driver
	 * @param elementName
	 * @param timeoutSec
	 * 
	 * @author Laxman.M
	 */
	public static void WaitForElementPresent(WebDriver driver, WebElement element, String elementName, int timeoutSec){
		WebDriverWait wait = new WebDriverWait(driver, timeoutSec);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Log.info("Explicit wait on "+elementName+"for " +timeoutSec
				+ " seconds || Class: UserActions | Method: WaitForElementPresent | Input: elementName="+elementName+"timeoutSec=" + timeoutSec);
	}
	
	/**
	 * @method void WaitForTextPresent
	 * @description This method will wait for text to be present on the element for certain amount of time before
	 *              throwing exception that it cannot find the element on the
	 *              page.
	 * @param driver
	 * @param expText
	 * @param elementName
	 * @param timeoutSec
	 * 
	 * @author Laxman.M
	 */
	public static void WaitForTextPresent(WebDriver driver, By by, String elementName, int timeoutSec, String expText){
		WebDriverWait wait = new WebDriverWait(driver, timeoutSec);
		Log.info(driver.findElement(by).getText());
		wait.until(ExpectedConditions.textToBePresentInElementLocated(by, expText));
		Log.info("Explicit wait for "+expText+" text on "+elementName+"for " +timeoutSec
				+ " seconds || Class: UserActions | Method: WaitForTextPresent | Input: expText="+expText+" & elementName="+elementName+" & timeoutSec=" + timeoutSec);
	}
	
	/**
	 * @method void WaitForAlertPresent
	 * @description This method will wait for alert to be present for certain amount of time before
	 *              throwing exception.
	 * @param driver
	 * @param timeoutSec
	 * 
	 * @author Laxman.M
	 */
	public static void WaitForAlertPresent(WebDriver driver, int timeoutSec){
		WebDriverWait wait = new WebDriverWait(driver, timeoutSec);
		wait.until(ExpectedConditions.alertIsPresent());
		Log.info("Explicit wait for Alert for " +timeoutSec
				+ " seconds || Class: UserActions | Method: WaitForAlertPresent | Input: timeoutSec=" + timeoutSec);
	}
	
	/**
	 * @method void WaitForElementVisible
	 * @description This method will wait for element to be visible for certain amount of time before
	 *              throwing exception that it cannot find the element on the
	 *              page.
	 * @param driver
	 * @param elementName
	 * @param timeoutSec
	 * 
	 * @author Laxman.M
	 */
	public static void WaitForElementVisible(WebDriver driver, By by, String elementName, int timeoutSec){
		WebDriverWait wait = new WebDriverWait(driver, timeoutSec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		Log.info("Explicit wait for visible on "+elementName+"for " +timeoutSec
				+ " seconds || Class: UserActions | Method: WaitForElementVisible | Input: elementName="+elementName+"timeoutSec=" + timeoutSec);
	}
	
	/**
	 * @method void WaitForElementInvisible
	 * @description This method will wait for element to be invisible/hidden for certain amount of time before
	 *              throwing exception that it cannot find the element on the
	 *              page.
	 * @param driver
	 * @param elementName
	 * @param timeoutSec
	 * 
	 * @author Laxman.M
	 */
	public static void WaitForElementInvisible(WebDriver driver, By by, String elementName, int timeoutSec){
		WebDriverWait wait = new WebDriverWait(driver, timeoutSec);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		Log.info("Explicit wait for invisible on "+elementName+"for " +timeoutSec
				+ " seconds || Class: UserActions | Method: WaitForElementInvisible | Input: elementName="+elementName+"timeoutSec=" + timeoutSec);
	}
	
	
	/*
	 * public static void FluentWait(WebDriver driver, int timeoutSec, int
	 * pollInterval){
	 * 
	 * }
	 */

	/*
	 * public static void ExpectedConditions(){
	 * 
	 * }
	 */

	/**
	 * @method void SetPageLoadTimeOut
	 * @description This method sets the amount of time for a page load to
	 *              complete before throwing an error. If the timeout is
	 *              negative, then page loads can be indefinite.
	 * @param driver
	 * @param timeoutSec
	 * 
	 * @author Laxman.M
	 */
	public static void SetPageLoadTimeOut(WebDriver driver, int timeoutSec) {
		driver.manage().timeouts().pageLoadTimeout(timeoutSec, TimeUnit.SECONDS);
		Log.info("Page load timeout set to " + timeoutSec
				+ " seconds || Class: UserActions | Method: SetPageLoadTimeOut | Input: timeoutSec=" + timeoutSec);
	}

	/**
	 * @method void SetScriptTimeout
	 * @description This method sets the amount of time to wait for an
	 *              asynchronous script to finish execution before throwing an
	 *              error. If the timeout is negative, then the script will be
	 *              allowed to run indefinitely.
	 * @param driver
	 * @param timeoutSec
	 * 
	 * @author Laxman.M
	 */
	public static void SetScriptTimeout(WebDriver driver, int timeoutSec) {
		driver.manage().timeouts().setScriptTimeout(timeoutSec, TimeUnit.SECONDS);
		Log.info("Asynchronous script execution timeout set to " + timeoutSec
				+ " seconds || Class: UserActions | Method: SetScriptTimeout | Input: timeoutSec=" + timeoutSec);
	}

	/**************************** SWITCH COMMANDS ************************/
	/*********************************************************************/

	/**
	 * @method String GetWindowHandle
	 * @description This method will return the window handle of current window.
	 *              It returns a string of alphanumeric window handle.
	 * @param driver
	 * @return windowHandle
	 * 
	 * @author Laxman.M
	 */
	public static String GetWindowHandle(WebDriver driver) {
		String windowHandle = driver.getWindowHandle();
		Log.info("Output: windowHandle=" + windowHandle
				+ " || Class: UserActions | Method: GetWindowHandle | Input: null");
		return windowHandle;
	}

	/**
	 * @method Set<String> GetWindowHandles
	 * @description This method will return window handle of all the current
	 *              windows.
	 * @param driver
	 * @return GetWindowHandles
	 * 
	 * @author Laxman.M
	 */
	public static Set<String> GetWindowHandles(WebDriver driver) {
		Set<String> windowHandles = driver.getWindowHandles();
		Log.info("Output: windowHandles=" + windowHandles
				+ " || Class: UserActions | Method: GetWindowHandles | Input: null");
		return windowHandles;
	}

	/**
	 * @method void SwitchToMainWindow
	 * @description This method will switch the reference to main window.
	 * @param driver
	 * 
	 * @author Laxman.M
	 */
	public static void SwitchToMainWindow(WebDriver driver) {
		driver.switchTo().defaultContent();
		Log.info(
				"Browser reference switched to main window || Class: UserActions | Method: SwitchToMainWindow | Input: null");
	}

	/**
	 * @method void SwitchToWindow
	 * @description This method will switch the reference to window with
	 *              specified handle.
	 * @param driver
	 * @param windowHandle
	 * @return GetWindowHandles
	 * 
	 * @author Laxman.M
	 */
	public static void SwitchToWindow(WebDriver driver, String windowHandle) {
		driver.switchTo().window(windowHandle);
		Log.info("Browser reference switched to window with handle:" + windowHandle
				+ " || Class: UserActions | Method: SwitchToWindow | Input: windowHandle=" + windowHandle);
	}

	/**
	 * @method void SwitchToFrameWithNameIndex
	 * @description This method will switch the reference to frame with
	 *              specified frame name.
	 * @param driver
	 * @param frameName
	 * 
	 * @author Laxman.M
	 */
	public static void SwitchToFrameWithNameIndex(WebDriver driver, String frameNameIndex) {
		driver.switchTo().frame(frameNameIndex);
		Log.info("Browser reference switched to frame with name/index:" + frameNameIndex
				+ " || Class: UserActions | Method: SwitchToFrameWithNameIndex | Input: frameNameIndex="
				+ frameNameIndex);
	}

	/**
	 * @method void SwitchToFrameWithHandle
	 * @description This method will switch the reference to frame with
	 *              specified frame element.
	 * @param driver
	 * @param frameElement
	 * 
	 * @author Laxman.M
	 */
	public static void SwitchToFrameWithHandle(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
		Log.info("Browser reference switched to frame :" + frameElement
				+ " || Class: UserActions | Method: SwitchToFrameWithHandle | Input: frameElement=" + frameElement);
	}

	/**
	 * @method Alert SwitchToAlert
	 * @description This method will switch the reference to alert window.
	 * @param driver
	 * @return handle
	 * 
	 * @author Laxman.M
	 */
	public static Alert SwitchToAlert(WebDriver driver) {
		Alert handle = driver.switchTo().alert();
		Log.info("Output: handle=" + handle + " || Class: UserActions | Method: SwitchToAlert | Input: null");
		return handle;
	}

	/****************** ALERTS and POPUP WINDOW COMMANDS *****************/
	/*********************************************************************/

	/**
	 * @method String GetAlertText
	 * @description This method will return the text of the alert.
	 * @param driver
	 * @param alertHandle
	 * @return alertText
	 * 
	 * @author Laxman.M
	 */
	public static String GetAlertText(WebDriver driver, Alert alertHandle) {
		String alertText = alertHandle.getText();
		Log.info("Output: alertText=" + alertText + " || Class: UserActions | Method: GetAlertText | Input: alertHandle"
				+ alertHandle);
		return alertText;
	}

	/**
	 * @method void AcceptAlert
	 * @description This method will accept the alert.
	 * @param driver
	 * @param alertHandle
	 * 
	 * @author Laxman.M
	 */
	public static void AcceptAlert(WebDriver driver, Alert alertHandle) {
		alertHandle.accept();
		Log.info("Alert Accepted || Class: UserActions | Method: AcceptAlert | Input: alertHandle" + alertHandle);
	}

	/**
	 * @method void DismissAlert
	 * @description This method will dismiss the alert.
	 * @param driver
	 * @param alertHandle
	 * 
	 * @author Laxman.M
	 */
	public static void DismissAlert(WebDriver driver, Alert alertHandle) {
		alertHandle.dismiss();
		Log.info("Alert Dismissed || Class: UserActions | Method: DismissAlert | Input: alertHandle" + alertHandle);
	}

	/**
	 * @method void SendKeysAlert
	 * @description This method will input text on the alert.
	 * @param driver
	 * @param alertHandle
	 * @param inputText
	 * 
	 * @author Laxman.M
	 */
	public static void SendKeysAlert(WebDriver driver, Alert alertHandle, String inputText) {
		alertHandle.sendKeys(inputText);
		Log.info("Text input on Alert" + inputText
				+ " || Class: UserActions | Method: SendKeysAlert | Input: alertHandle" + alertHandle + " & inputText="
				+ inputText);
	}
	
	
	/***********************VERIFICATION METHODS *************************/
	/*********************************************************************/
	public static boolean VerifyLabelText(WebDriver driver, WebElement element, String elementName, String expectedText) {
		Log.info("Expected: " + expectedText + "||Actual: "+element.getText()+" || Class: UserActions | Method: VerifyLabelText | Input: elementName=" + elementName+"& expectedText="+expectedText);
		return element.getText().contains(expectedText);
	}
	
	
	public static String GetLabelText(WebDriver driver, WebElement element) {
		String labelText = element.getText();
		Log.info("Output: labelText" + labelText + " || Class: UserActions | Method: GetLabelText | Input: null");
		return labelText;
	}
	
	
	/******************ITEMS TO BE PHASED OFF *****************/
	/*********************************************************************/
	public static void SwitchToFrameByName(WebDriver driver, String frameName) {
		driver.switchTo().frame(frameName);
		Log.info("Browser reference switch to frame by Name :" + frameName);
	}

	public static void SwitchToMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
		Log.info("Browser reference switch to Main frame");
	}

	/**
	 * @method VerifyPageTitle
	 * @description This method verifies the title of the page. Returns boolean
	 *              true/false.
	 * @param driver
	 * @param pageTitle
	 * @param pageName
	 * @return
	 * 
	 * @author Laxman
	 */
	public static boolean VerifyPageTitle(WebDriver driver, String pageTitle, String pageName) {
		String actualPageTitle = GetPageTitle(driver);
		Log.info("Expected: " + pageTitle + "||Actual: " + actualPageTitle);
		return actualPageTitle.contains(pageTitle);
	}

	/**
	 * @author Laxman
	 * @description This method is a wrapper method for findElement() method in
	 *              selenium
	 * 
	 * @param driver
	 * @param by
	 * @param elementName
	 * @param pageName
	 * @return
	 */
	public static WebElement FindElement(WebDriver driver, By by, String elementName, String pageName) {
		WebElement element = driver.findElement(by);

		try {
			element = driver.findElement(by);
			Log.info(elementName + " is found on the " + pageName);
		} catch (Exception e) {
			Log.error(elementName + " is not found on the " + pageName);
			throw (e);
		}
		return element;
	}

	public static WebElement FindElement(WebDriver driver, By refBy, By by, String elementName, String pageName) {
		WebElement refByEle = driver.findElement(refBy);

		WebElement element;
		try {
			element = refByEle.findElement(by);
			Log.info(elementName + " is found on the " + pageName);
		} catch (Exception e) {
			Log.error(elementName + " is not found on the " + pageName);
			throw (e);
		}
		return element;
	}

	public static List<WebElement> FindElements(WebDriver driver, By by, String elementName, String pageName) {
		List<WebElement> element = driver.findElements(by);

		try {
			element = driver.findElements(by);
			Log.info(elementName + " is found on the " + pageName);
		} catch (Exception e) {
			Log.error(elementName + " is not found on the " + pageName);
			throw (e);
		}
		return element;
	}

	/**
	 * @author Laxman
	 * @description This method is a wrapper method for sendKeys() method in
	 *              selenium
	 * @param driver
	 * @param by
	 * @param textInput
	 * @param elementName
	 * @param pageName
	 */
	public static void TextBoxInput(WebDriver driver, By by, String textInput, String elementName, String pageName) {

		FindElement(driver, by, elementName, pageName).sendKeys(textInput);
		Log.info(textInput + " is entered in " + elementName);

	}

	/**
	 * @author Laxman
	 * @description This method is a wrapper method for click() action in
	 *              selenium
	 * @param driver
	 * @param by
	 * @param elementName
	 * @param pageName
	 */
	public static void MouseClick(WebDriver driver, By by, String elementName, String pageName) {
		try {
			(new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(by));
			FindElement(driver, by, elementName, pageName).click();
			Log.info("Click action is performed on " + elementName);
		} catch (StaleElementReferenceException sere) {
			// simply retry finding the element in the refreshed DOM
			FindElement(driver, by, elementName, pageName).click();
			Log.info("Click action is performed on " + elementName);
		} catch (TimeoutException toe) {
			Log.error(elementName + " was not clickable after 10 seconds");
		}
	}

	public static void SelectDropDownValue(WebDriver driver, By by, String elementName, String dropdownValue,
			String pageName, String selectType) {
		if (selectType == "VisibleText") {
			WebElement elementRef = UserActions.FindElement(driver, by, elementName, pageName);
			Select oelementSelectRef = new Select(elementRef);
			oelementSelectRef.selectByVisibleText(dropdownValue);
			Log.info(elementName + " with value " + dropdownValue + " selected");
		}
	}

	public static boolean VerifyDropdownValueSelected(WebDriver driver, By by, String elementName,
			String expectedDropdownValue, String pageName) {
		WebElement elementRef = UserActions.FindElement(driver, by, elementName, pageName);
		Select oelementSelectRef = new Select(elementRef);
		String ActualValue = oelementSelectRef.getFirstSelectedOption().getText();
		Log.info("Expected: " + expectedDropdownValue + "||Actual: " + ActualValue);
		if (ActualValue == expectedDropdownValue) {
			return true;
		} else {
			return false;
		}
	}

	public static void SelectRadioButtonByValue(WebDriver driver, By by, String elementName, String radioBtnValue,
			String pageName, String selectType) {
		// Find the checkbox or radio button element by Name
		List<WebElement> oRadioBtn = UserActions.FindElements(driver, by, elementName, pageName);
		// This will tell you the number of checkboxes are present
		int iSize = oRadioBtn.size();
		Log.info("The number of radio buttons :" + iSize);
		// Start the loop from first checkbox to last checkboxe
		for (int i = 0; i < iSize; i++) {
			// Store the checkbox name to the string variable, using 'Value'
			// attribute
			String sValue = ((WebElement) oRadioBtn.get(i)).getAttribute("value");
			// Select the checkbox it the value of the checkbox is same what you
			// are looking for
			if (sValue.equalsIgnoreCase(radioBtnValue)) {
				((WebElement) oRadioBtn.get(i)).click();
				// This will take the execution out of for loop
				break;
			}
		}
	}

	public static String GetLabelText(WebDriver driver, By by, String elementName, String pageName) {
		String batchid = UserActions.FindElement(driver, by, elementName, pageName).getText();
		Log.info("Batch ID: " + batchid);
		return batchid;
	}

	

	public static void AlertConfirm(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		Log.info("Pop up message :" + alert.getText() + " Accepted");
		alert.accept();

	}

	/**
	 * 
	 * @param driver
	 * @param pageTitle
	 * @param pageName
	 */

	public static void AssertPageTitle(WebDriver driver, String pageTitle, String pageName) {
		try {
			Assert.assertEquals(GetPageTitle(driver), pageTitle,
					"Verification of Page Title Passed : Expected -" + pageTitle + " Actual -" + GetPageTitle(driver));
			Log.info("Verification of Page Title Passed : Expected -" + pageTitle + " Actual -" + GetPageTitle(driver));
			Reporter.log(
					"Verification of Page Title Passed : Expected -" + pageTitle + " Actual -" + GetPageTitle(driver));
		} catch (AssertionError e) {
			Log.error(
					"Verification of Page Title Failed : Expected -" + pageTitle + " Actual -" + GetPageTitle(driver));
			Reporter.log(
					"Verification of Page Title Failed : Expected -" + pageTitle + " Actual -" + GetPageTitle(driver));
			throw (e);
		}

	}

	/**
	 * 
	 * @param driver
	 * @param pageTitle
	 * @param pageName
	 */

	public static void SoftAssertPageTitle(WebDriver driver, String pageTitle, String pageName) {

		try {
			Assert.assertEquals(GetPageTitle(driver), pageTitle,
					"Verification of Page Title Passed : Expected -" + pageTitle + " Actual -" + GetPageTitle(driver));
			Log.info("Verification of Page Title Passed : Expected -" + pageTitle + " Actual -" + GetPageTitle(driver));
			Reporter.log(
					"Verification of Page Title Passed : Expected -" + pageTitle + " Actual -" + GetPageTitle(driver));
		} catch (AssertionError e) {
			Log.error(
					"Verification of Page Title Failed : Expected -" + pageTitle + " Actual -" + GetPageTitle(driver));
			Reporter.log(
					"Verification of Page Title Failed : Expected -" + pageTitle + " Actual -" + GetPageTitle(driver));
			BaseClass.bResult = false;
		}

	}

	public static void waitForElementPresent(WebDriver driver, By by, String elementName, String pageName) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(UserActions.FindElement(driver, by, elementName, pageName)));
	}

}
