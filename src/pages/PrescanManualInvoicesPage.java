package pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utility.ExcelUtils;
import utility.Config;

import utility.Log;
import utility.UserActions;

public class PrescanManualInvoicesPage extends BaseClass {

	// Page Objects
	@FindBy(name = "p_account_number")
	static WebElement accountnumberTxt;
	@FindBy(name = "p_inv_number")
	static WebElement invoicenumberTxt;
	@FindBy(name = "p_inv_date_month")
	static WebElement invoicemonthTxt;
	@FindBy(name = "p_inv_date_day")
	static WebElement invoicedayTxt;
	@FindBy(name = "p_inv_date_year")
	static WebElement invoicedayYear;
	@FindBy(name = "p_inv_amount")
	static WebElement invoiceamountTxt;
	@FindBy(name = "p_vat_amount")
	static WebElement invoicevatamountTxt;
	@FindBy(name = "p_inv_status")
	static WebElement invoicestatusDropdown;
	@FindBy(name = "p_currency")
	static WebElement invoicecurrencyDropdown;
	@FindBy(name = "add")
	static WebElement continueBtn;
	@FindBy(name = "close_batch")
	static WebElement completebatchBtn;
	@FindBy(name = "clear")
	static WebElement clearBtn;
	@FindBy(className = "containerheader")
	static WebElement serviceLabel;
	@FindBy(name = "p_carrier_client")
	static WebElement carrierRadioBtn;
	@FindBy(name = "validate")
	static WebElement validateBtn;
	@FindBy(className = "containerlabel")
	static WebElement successLabel;
	@FindBy(className = "msgdata")
	static WebElement successmsgLabel;

	public static String pageName = "Prescan Manual Invoice Page";
	public static String pageTitle = "";

	public PrescanManualInvoicesPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * This method is used to enter the invoice details.
	 */
	public static HashMap<String,String> EnterInvoiceDetails(WebDriver driver, int iTestCaseRow, String sAccountNum, String sInvoiceNum,
			String sInvoiceMonth, String sInvoiceDay, String sInvoiceYear, String sInvoiceAmount, String sInvoiceVat,
			String sInvoiceStatus, String sInvoiceCurrency) throws Exception {

		// Test Data
		sAccountNum = sAccountNum.replace("$", "");
		sAccountNum = ExcelUtils.getCellData(iTestCaseRow, sAccountNum);
		sInvoiceNum = sInvoiceNum.replace("$", "");
		sInvoiceNum = ExcelUtils.getCellData(iTestCaseRow, sInvoiceNum);
		sInvoiceMonth = sInvoiceMonth.replace("$", "");
		sInvoiceMonth = ExcelUtils.getCellData(iTestCaseRow, sInvoiceMonth);
		sInvoiceDay = sInvoiceDay.replace("$", "");
		sInvoiceDay = ExcelUtils.getCellData(iTestCaseRow, sInvoiceDay);
		sInvoiceYear = sInvoiceYear.replace("$", "");
		sInvoiceYear = ExcelUtils.getCellData(iTestCaseRow, sInvoiceYear);
		sInvoiceAmount = sInvoiceAmount.replace("$", "");
		sInvoiceAmount = ExcelUtils.getCellData(iTestCaseRow, sInvoiceAmount);
		sInvoiceVat = sInvoiceVat.replace("$", "");
		sInvoiceVat = ExcelUtils.getCellData(iTestCaseRow, sInvoiceVat);
		sInvoiceStatus = sInvoiceStatus.replace("$", "");
		sInvoiceStatus = ExcelUtils.getCellData(iTestCaseRow, sInvoiceStatus);
		sInvoiceCurrency = sInvoiceCurrency.replace("$", "");
		sInvoiceCurrency = ExcelUtils.getCellData(iTestCaseRow, sInvoiceCurrency);

		UserActions.SwitchToFrameWithNameIndex(driver, "BOTTOMFRAME");

		// Enter Invoice Details
		UserActions.SendKeys(driver, accountnumberTxt, sAccountNum, "Account Number TextBox");
		UserActions.SendKeys(driver, invoicenumberTxt, sInvoiceNum, "Invoice Number TextBox");
		UserActions.SendKeys(driver, invoicemonthTxt, sInvoiceMonth, "Invoice Month TextBox");
		UserActions.SendKeys(driver, invoicedayTxt, sInvoiceDay, "Invoice Day TextBox");
		UserActions.SendKeys(driver, invoicedayYear, sInvoiceYear, "Invoice Year TextBox");
		UserActions.SendKeys(driver, invoiceamountTxt, sInvoiceAmount, "Invoice Amount TextBox");
		UserActions.SendKeys(driver, invoicevatamountTxt, sInvoiceVat, "Invoice Vat TextBox");
		if (sInvoiceStatus != "") {
			UserActions.SelectDropdownWithValue(driver, invoicestatusDropdown, "Invoice Status Dropdown",
					sInvoiceStatus);
		}
		if (sInvoiceCurrency != "") {
			UserActions.SelectDropdownWithValue(driver, invoicecurrencyDropdown, "Invoice Currency Dropdown",
					sInvoiceCurrency);
		}
		
		UserActions.SwitchToMainWindow(driver);
		
		HashMap<String,String> InvoiceDetails = new HashMap<String,String>();
		InvoiceDetails.put("Account Number", sAccountNum);
		InvoiceDetails.put("Invoice Number", sInvoiceNum);
		InvoiceDetails.put("Invoice Month", sInvoiceMonth);
		InvoiceDetails.put("Invoice Day", sInvoiceDay);
		InvoiceDetails.put("Invoice Year", sInvoiceYear);
		InvoiceDetails.put("Invoice Amount", sInvoiceAmount);
		InvoiceDetails.put("Invoice Vat", sInvoiceVat);
		InvoiceDetails.put("Invoice Status", sInvoiceStatus);
		InvoiceDetails.put("Invoice Currency", sInvoiceCurrency);
		
		Log.info("Invoice Details Entered: "+InvoiceDetails);
		return InvoiceDetails;
	}

	/**
	 * This method will click on the Continue Button on the Invoice Entry Page.
	 */
	public static void InvoiceContinue(){
		UserActions.SwitchToFrameWithNameIndex(driver, "BOTTOMFRAME");
		UserActions.Click(driver, continueBtn, "Continue Button");
		UserActions.SwitchToMainWindow(driver);
		Log.info("Continue with Invoice Entry");
	}
	
	/**
	 * This method will select the carrier.
	 */
	public static HashMap<String,String> SelectCarrierClient(WebDriver driver, int iTestCaseRow,String sCarrier) throws Exception{
		sCarrier = sCarrier.replace("$", "");
		sCarrier = ExcelUtils.getCellData(iTestCaseRow, sCarrier);
		
		UserActions.SwitchToFrameWithNameIndex(driver, "BOTTOMFRAME");
		UserActions.Click(driver, carrierRadioBtn, "Carrier Radio Button");
		UserActions.SwitchToMainWindow(driver);
		
		HashMap<String,String> CarrierDetails = new HashMap<String,String>();
		CarrierDetails.put("Carrier", sCarrier);
		
		Log.info("Select the Carrier");
		return CarrierDetails;
	}
	
	/**
	 * This method will click on the Continue Button on the Carrier Selection Page.
	 */
	public static void CarrierContinue(){
		UserActions.SwitchToFrameWithNameIndex(driver, "BOTTOMFRAME");
		UserActions.Click(driver, validateBtn, "Continue Button");
		UserActions.SwitchToMainWindow(driver);
		Log.info("Continue after selecting carrier");
	}
	
	
	public static String GetMsgText(){
		UserActions.SwitchToFrameWithNameIndex(driver, "BOTTOMFRAME");
		String labelText = UserActions.GetLabelText(driver, successmsgLabel);
		Log.info("Message Label: "+labelText);
		UserActions.SwitchToMainWindow(driver);
		return labelText;
	}
	
	
	
	static By coversheetprescanby = By.xpath("//td[span[contains(text(), 'Pre-Scan by:')]]/span[2]");
	static By coversheetclient = By.xpath("//td[span[contains(text(), 'Client:')]]/span[2]");
	static By coversheetclientcode = By.xpath("//td[span[contains(text(), 'Client Code:')]]/span[2]");
	// static By coversheetcarriercode =
	// By.xpath("/html/body/table[3]/tbody/tr[2]/td/table[3]/tbody/tr/td[3]/table/tbody/tr[2]/td/span[2]");
	static By coversheetcarrier = By.xpath("//td[span[contains(text(), 'Carrier:')]]/span[2]");
	static By coversheetbatchid = By.xpath("//td[span[contains(text(), 'Pre-Scan Batch ID:')]]/span[2]");

	/*
	 * public static void AddInvoiceEntry(WebDriver driver, int iTestCaseRow,
	 * String actnumber, String invnumber, String invmonth, String invday,
	 * String invyear, String invamount, String invvat, String invstatus, String
	 * invcurrency, String carrier) throws Exception { // Test Data actnumber =
	 * actnumber.replace("$", ""); actnumber =
	 * ExcelUtils.getCellData(iTestCaseRow, actnumber); invnumber =
	 * invnumber.replace("$", ""); invnumber =
	 * ExcelUtils.getCellData(iTestCaseRow, invnumber); invmonth =
	 * invmonth.replace("$", ""); invmonth =
	 * ExcelUtils.getCellData(iTestCaseRow, invmonth); invday =
	 * invday.replace("$", ""); invday = ExcelUtils.getCellData(iTestCaseRow,
	 * invday); invyear = invyear.replace("$", ""); invyear =
	 * ExcelUtils.getCellData(iTestCaseRow, invyear); invamount =
	 * invamount.replace("$", ""); invamount =
	 * ExcelUtils.getCellData(iTestCaseRow, invamount); invvat =
	 * invvat.replace("$", ""); invvat = ExcelUtils.getCellData(iTestCaseRow,
	 * invvat); invstatus = invstatus.replace("$", ""); invstatus =
	 * ExcelUtils.getCellData(iTestCaseRow, invstatus); invcurrency =
	 * invcurrency.replace("$", ""); invcurrency =
	 * ExcelUtils.getCellData(iTestCaseRow, invcurrency); carrier =
	 * carrier.replace("$", ""); carrier = ExcelUtils.getCellData(iTestCaseRow,
	 * carrier);
	 * 
	 * UserActions.SwitchToFrameByName(driver, "BOTTOMFRAME");
	 * 
	 * 
	 * UserActions.TextBoxInput(driver, accountnumber, actnumber,
	 * "Account Number Textbox", pageName); UserActions.TextBoxInput(driver,
	 * invoicenumber, invnumber, "Invoice Number Textbox", pageName);
	 * UserActions.TextBoxInput(driver, invoicemonth, invmonth,
	 * "Invoice Month Textbox", pageName); UserActions.TextBoxInput(driver,
	 * invoiceday, invday, "Invoice Day Textbox", pageName);
	 * UserActions.TextBoxInput(driver, invoiceyear, invyear,
	 * "Invoice Year Textbox", pageName); UserActions.TextBoxInput(driver,
	 * invoiceamount, invamount, "Invoice Amount Textbox", pageName);
	 * UserActions.TextBoxInput(driver, invoicevatamount, invvat,
	 * "Invoice Vat Amount Textbox", pageName); if (invstatus != "") {
	 * UserActions.SelectDropDownValue(driver, invoicestatus,
	 * "Invoice Status Dropdown", invstatus, pageName, "VisibleText"); } if
	 * (invcurrency != "") { UserActions.SelectDropDownValue(driver,
	 * invoicecurrency, "Invoice Currency Dropdown", invcurrency, pageName,
	 * "VisibleText"); } Continue();
	 * 
	 * Assert.assertTrue( UserActions.VerifyLabelText(driver, servicelabel,
	 * "Service Label", "Prescan Manual Entry :: Carrier Client", pageName),
	 * "Prescan Manual Entry :: Carrier Client page did not load successfully");
	 * 
	 * UserActions.SelectRadioButtonByValue(driver, carrierradioBtn,
	 * "Carrier Radio Button", carrier, pageName, "Value");
	 * 
	 * Validate();
	 * 
	 * UserActions.SwitchToMainFrame(driver);
	 * 
	 * }
	 * 
	 * public static void Continue() { UserActions.MouseClick(driver,
	 * contineBtn, "Continue Button", pageName); }
	 * 
	 * public static void CompleteBatch() {
	 * UserActions.SwitchToFrameByName(driver, "BOTTOMFRAME");
	 * UserActions.MouseClick(driver, CompleteBatchBtn, "Complete Batch Button",
	 * pageName); UserActions.AlertConfirm(driver);
	 * UserActions.SwitchToMainFrame(driver); }
	 * 
	 * public static void Clear() { UserActions.MouseClick(driver, ClearBtn,
	 * "Clear Button", pageName); }
	 * 
	 * public static void Validate() { UserActions.MouseClick(driver,
	 * validateBtn, "Continue/Validate Button", pageName); }
	 * 
	 * public static boolean VerifyInvoiceSuccessMessage(WebDriver driver, int
	 * iTestCaseRow, String invnum) throws Exception { // Test Data invnum =
	 * invnum.replace("$", ""); String invnumber =
	 * ExcelUtils.getCellData(iTestCaseRow, invnum);
	 * 
	 * UserActions.SwitchToFrameByName(driver, "BOTTOMFRAME"); // String
	 * invnumber = ExcelUtils.getCellData(iTestCaseRow, //
	 * Config.PrescanM_InvNum); boolean labelResult =
	 * UserActions.VerifyLabelText(driver, successLabel,
	 * "Success Message Label", "Success", pageName);
	 * 
	 * if (labelResult == true) { String expMessage = "Invoice " + invnumber +
	 * " was added successfully"; boolean labeltxt =
	 * UserActions.VerifyLabelText(driver, successMsg, "Success Message Text",
	 * expMessage, pageName); UserActions.SwitchToMainFrame(driver); return
	 * labeltxt; } else { UserActions.SwitchToMainFrame(driver); return false; }
	 * }
	 * 
	 * public static boolean VerifyPaperInvoiceCoverSheet(WebDriver driver, int
	 * iTestCaseRow, String prescanby, String client, String clientcode, String
	 * carrier, String coversheetcarriercode) throws Exception {
	 * UserActions.SwitchToFrameByName(driver, "BOTTOMFRAME"); prescanby =
	 * prescanby.replace("$", ""); prescanby =
	 * ExcelUtils.getCellData(iTestCaseRow, prescanby); client =
	 * client.replace("$", ""); client = ExcelUtils.getCellData(iTestCaseRow,
	 * client); clientcode = clientcode.replace("$", ""); clientcode =
	 * ExcelUtils.getCellData(iTestCaseRow, clientcode); carrier =
	 * carrier.replace("$", ""); carrier = ExcelUtils.getCellData(iTestCaseRow,
	 * carrier); coversheetcarriercode = coversheetcarriercode.replace("$", "");
	 * coversheetcarriercode = ExcelUtils.getCellData(iTestCaseRow,
	 * coversheetcarriercode);
	 * 
	 * 
	 * String prescanby = ExcelUtils.getCellData(iTestCaseRow,
	 * Config.PrescanM_Exp_PrescanBy); String client =
	 * ExcelUtils.getCellData(iTestCaseRow, Config.PrescanM_Exp_Client); String
	 * clientcode = ExcelUtils.getCellData(iTestCaseRow,
	 * Config.PrescanM_Exp_ClientCode); String carrier =
	 * ExcelUtils.getCellData(iTestCaseRow, Config.PrescanM_Exp_Carrier); String
	 * coversheetcarriercode = ExcelUtils.getCellData(iTestCaseRow,
	 * Config.PrescanM_Exp_CarrierCode);
	 * 
	 * 
	 * boolean prescanB = UserActions.VerifyLabelText(driver,
	 * coversheetprescanby, "Prescan By Text", prescanby, pageName); boolean
	 * clientB = UserActions.VerifyLabelText(driver, coversheetclient,
	 * "Client Text", client, pageName); boolean clientcodeB =
	 * UserActions.VerifyLabelText(driver, coversheetclientcode,
	 * "Client Code Text", clientcode, pageName); boolean carrierB =
	 * UserActions.VerifyLabelText(driver, coversheetcarrier, "Carrier Text",
	 * carrier, pageName); // boolean carrierCodeB =
	 * SeleniumWrappers.VerifyLabelText(driver, // coversheetcarriercode,
	 * "Carrier Code Text", carriercode, pageName); Log.info("Prescan By: " +
	 * prescanB); Log.info("Client: " + clientB); Log.info("Client Code: " +
	 * clientcodeB); Log.info("Carrier: " + carrierB);
	 * 
	 * UserActions.SwitchToMainFrame(driver); if (prescanB && clientB &&
	 * clientcodeB && carrierB) { return true; } else { return false; } }
	 * 
	 * public static String GetBatchIDFromCoverSheet() {
	 * UserActions.SwitchToFrameByName(driver, "BOTTOMFRAME"); String batchID =
	 * UserActions.GetLabelText(driver, coversheetbatchid, "Batch ID text",
	 * pageName); UserActions.SwitchToMainFrame(driver); return batchID; }
	 */
}
