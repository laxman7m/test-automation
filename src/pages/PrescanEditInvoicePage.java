package pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.ExcelUtils;
import utility.Log;
import utility.UserActions;
import utility.TableUtils;

public class PrescanEditInvoicePage extends BaseClass{
	
	public static String pageName = "Prescan Edit Invoice Page";
	public static String pageTitle = "";

	public PrescanEditInvoicePage(WebDriver driver) {
		super(driver);
	}
	
	static By batchnum = By.name("batch_id");
	static By invnumber = By.name("inv_numbers");
	static By searchBtn = By.name("search");
	static By deleteBtn = By.name("delete");
	static By printBtn = By.name("print");
	static By prescanbatchlabel = By.xpath("//td[span[contains(text(), 'Pre-scan Batch Number:')]]");
	static By clientlabel = By.xpath("//td[span[contains(text(), 'Client:')]]");
	static By carrierlabel = By.xpath("//td[span[contains(text(), 'Carrier:')]]");
	static By searchresultTable = By.xpath("/html/body/form/table[1]/tbody/tr[2]/td[1]/table[3]/tbody");
	
	public static void EnterBatchNumber(WebDriver driver, String batchid){
		UserActions.SwitchToFrameByName(driver, "BOTTOMFRAME");
		UserActions.TextBoxInput(driver, batchnum, batchid, "Batch Number Text Box", pageName);
		Log.info("Batch Number Entered in Batch Number Search box");
		UserActions.SwitchToMainFrame(driver);
	}
	
	public static void EnterInvoiceNumbers(WebDriver driver, String invoicenumbers){
		UserActions.SwitchToFrameByName(driver, "BOTTOMFRAME");
		UserActions.TextBoxInput(driver, invnumber, invoicenumbers, "Invoice Numbers Text Box", pageName);
		Log.info("Invoice Numbers Entered in Invoices Search box");
		UserActions.SwitchToMainFrame(driver);
	}
	
	public static void Search() {
		UserActions.SwitchToFrameByName(driver, "BOTTOMFRAME");
		UserActions.MouseClick(driver, searchBtn, "Search Button", pageName);
		UserActions.SwitchToMainFrame(driver);
	}

	public static void DeleteEntireBatch(){
		UserActions.SwitchToFrameByName(driver, "BOTTOMFRAME");
		UserActions.MouseClick(driver, deleteBtn, "Delete Entire Batch Button", pageName);
		UserActions.SwitchToMainFrame(driver);
	}
	
	public static void PrintCoverSheet(){
		UserActions.SwitchToFrameByName(driver, "BOTTOMFRAME");
		UserActions.MouseClick(driver, printBtn, "Print Cover Sheet Button", pageName);
		UserActions.SwitchToMainFrame(driver);
	}
	
	
	/*public static boolean VerifyBatchSearchDetails(WebDriver driver, int iTestCaseRow, String batchnum, String clientcode, String carriercode, String invnum, String invnum1) throws Exception{
		SeleniumWrappers.SwitchToFrameByName(driver, "BOTTOMFRAME");
		// Test Data
		clientcode = clientcode.replace("$", "");
		clientcode = ExcelUtils.getCellData(iTestCaseRow, clientcode);
		carriercode = carriercode.replace("$", "");
		carriercode = ExcelUtils.getCellData(iTestCaseRow, carriercode);
		
		String expbatchlabel = "Pre-scan Batch Number:  "+batchnum;
		String expclientlabel = "Client:  "+clientcode;
		String expcarrierlabel = "Carrier:  "+clientcode;
		boolean batchB = SeleniumWrappers.VerifyLabelText(driver, prescanbatchlabel, "Prescan Batch Number Label", expbatchlabel, pageName);
		boolean clientB = SeleniumWrappers.VerifyLabelText(driver, clientlabel, "Client Label", expclientlabel, pageName);
		boolean carrierB = SeleniumWrappers.VerifyLabelText(driver, carrierlabel, "Carrier Label", expcarrierlabel, pageName);
		
		if (batchB && clientB && carrierB){
			Log.info("Batch Label:"+batchB+"||Client Label:"+clientB+"||Carrier Label:"+carrierB);
			int rowCount = TableUtils.getRowCount(driver, searchresultTable);
			WebElement tableRef = driver.findElement(searchresultTable);
			List<WebElement> tableRows = tableRef.findElements(By.tagName("tr"));
			Log.info("Row Count**"+rowCount);
			WebElement row1  = tableRows.get(2);
			WebElement Inv1 = row1.findElement(By.xpath("td[1]"));
			
			WebElement Acc1 = row1.findElement(By.xpath("td[6]"));
			String ActInv1 = Inv1.getText();
			String ActAccountNum1 = Acc1.getText();
			WebElement row2  = tableRows.get(3);
			WebElement Inv2 = row2.findElement(By.xpath("td[1]"));
			WebElement Acc2 = row2.findElement(By.xpath("td[6]"));
			String ActInv2 = Inv2.getText();
			String ActAccountNum2 = Acc2.getText();
			
			if(ActInv1.equals(invnum)  && ActInv2.equals(invnum1)){
				Log.info("Invoice1: Actual:"+ActInv1+"||Expected:"+invnum);
				Log.info("Invoice2: Actual:"+ActInv2+"||Expected:"+invnum1);
				return true;
			}
			else{
				Log.error("Invoice1: Actual:"+ActInv1+"||Expected:"+invnum);
				Log.error("Invoice1: Actual:"+ActInv2+"||Expected:"+invnum1);
				return false;
			}
		}
		else{
			SeleniumWrappers.SwitchToMainFrame(driver);
			Log.error("Batch Label:"+batchB+"||Client Label:"+clientB+"||Carrier Label:"+carrierB);
			return false;
		}		
	}*/
	
	
	
	/*public static boolean VerifyBatchSearchDetails(WebDriver driver, int iTestCaseRow, String batchnum, String clientcode, String carriercode, String invnum, String invnum1) throws Exception{
		UserActions.SwitchToFrameByName(driver, "BOTTOMFRAME");
		// Test Data
		clientcode = clientcode.replace("$", "");
		clientcode = ExcelUtils.getCellData(iTestCaseRow, clientcode);
		carriercode = carriercode.replace("$", "");
		carriercode = ExcelUtils.getCellData(iTestCaseRow, carriercode);
		
		String expbatchlabel = "Pre-scan Batch Number:  "+batchnum;
		String expclientlabel = "Client:  "+clientcode;
		String expcarrierlabel = "Carrier:  "+clientcode;
		//boolean batchB = UserActions.VerifyLabelText(driver, prescanbatchlabel, "Prescan Batch Number Label", expbatchlabel, pageName);
		//boolean clientB = UserActions.VerifyLabelText(driver, clientlabel, "Client Label", expclientlabel, pageName);
		//boolean carrierB = UserActions.VerifyLabelText(driver, carrierlabel, "Carrier Label", expcarrierlabel, pageName);
		
		ArrayList<HashMap<String, WebElement>> searchResultTable = new ArrayList<HashMap<String, WebElement>>();
		
		if (batchB && clientB && carrierB){
			
			searchResultTable = TableUtils.getTableDataNoHeader(driver, searchresultTable, 1, 2, 3);
			System.out.println(searchResultTable.get(1).get("Inv Number"));
			
			return true;
		}
		else{
			UserActions.SwitchToMainFrame(driver);
			Log.error("Batch Label:"+batchB+"||Client Label:"+clientB+"||Carrier Label:"+carrierB);
			return false;
		}		
	}
	
	public static void SelectInvoice(WebDriver driver, String invnumber){
		WebElement tableRef = driver.findElement(searchresultTable);
		String invXpath = "tr/td[text()='"+invnumber+"']";
		WebElement invRef = tableRef.findElement(By.xpath(invXpath)); 
		System.out.println(invRef.getText());
	}*/
}


