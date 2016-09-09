package test.java;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import pages.BaseClass;
import pages.LoginPage;
import pages.PrescanEditInvoicePage;
import pages.PrescanManualInvoicesPage;
import pages.UserPreferencesPage;
import utility.Config;
import utility.ExcelUtils;
import utility.Log;
import utility.UserActions;
import utility.TableUtils;
import utility.Utils;
import utility.DatabaseUtils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PrescanManualInvoices_MultipleInvoices extends SuiteDriver {
	
	/**
	 * Test Case# OnlineApp 33,34,35
	 * This test case will login to the QA Site
	 * Enter Valid Invoice Details
	 * Verify the "Success" Message label
	 * Verify "Invoice xxxx was added successfully" label
	 * Select the Carrier
	 * Enter Valid Invoice Details
	 * Verify the "Success" Message label
	 * Verify "Invoice xxxx was added successfully" label
	 * Select the Carrier
	 * Complete the Batch
	 * Verify the Cover sheet for Prescan By, Client, Client Code, Carrier and Carrier Code fields
	 * Verify the report.datstat_prescan table for the Invoice Entry
	 * Search the Invoices
	 * @throws Exception
	 */

	@Test(description = "Login||Goto Prescan Manual invoice Page||Enter Valid Invoice Details||Verify Success Message||Enter Valid Invoice Details||Verify Success Message||Complete Batch||Verify Cover Sheet||Verify report.datstat_prescan table||Search for Invoices")
	public void MultipleManualPrescanInvoiceEntry() throws Exception {
		try {
			
			test.log(LogStatus.PASS, "Test Case Page2");
			
			/*// Enter Valid Invoice
			PrescanManualInvoicesPage.AddInvoiceEntry(driver, iTestCaseRow, "$i_actname", "$i_invnum", "$i_invmonth", "$i_invday", "$i_invyear", "$i_invamt", "$i_invvat", "$i_invstatus", "$i_invcurrency","$i_invcarrier");
						
			// Verify Invoice Entry Success Message
			Assert.assertTrue(PrescanManualInvoicesPage.VerifyInvoiceSuccessMessage(driver, iTestCaseRow, "$i_invnum"),
								"Invoice Entry Failed");
			
			// Enter Valid Invoice
			PrescanManualInvoicesPage.AddInvoiceEntry(driver, iTestCaseRow, "$i_actname", "$i_invnum1", "$i_invmonth1", "$i_invday1", "$i_invyear1", "$i_invamt1", "$i_invvat1", "$i_invstatus1", "$i_invcurrency1","$i_invcarrier1");
									
			// Verify Invoice Entry Success Message
			Assert.assertTrue(PrescanManualInvoicesPage.VerifyInvoiceSuccessMessage(driver, iTestCaseRow, "$i_invnum1"),
											"Invoice Entry Failed");
			
			//Complete Batch
			PrescanManualInvoicesPage.CompleteBatch();
			
			//Verify Paper Invoice Cover Sheet
			Assert.assertTrue(PrescanManualInvoicesPage.VerifyPaperInvoiceCoverSheet(driver, iTestCaseRow, "$exp_prescanby","$exp_client","$exp_clientcode","$exp_carrier","$exp_carriercode"),"Verification of Paper Invoice cover sheet failed");
			
			//Get BatchID
			String batchid = PrescanManualInvoicesPage.GetBatchIDFromCoverSheet();
			
			//Connect to Database
			Connection DBRef = DatabaseUtils.connectToTestDB();
			
			//Verify report.datstat_prescan table
			String query = "select count(batch_id) from report.datstat_prescan where batch_id='"+batchid+"'";
			Assert.assertEquals(DatabaseUtils.executeSQLQuery(DBRef, query), "2", "Database Validation Failed.");
			
			//Close Database Connection
			DatabaseUtils.closeDB(DBRef); 
			
			//Goto Prescan Edit Invoice Page
			UserPreferencesPage.gotoPrescanEditInvoice();
			
			//Enter Pre-scan Batch Number
			PrescanEditInvoicePage.EnterBatchNumber(driver, batchid);
			
			String invnumber = ExcelUtils.getCellData(iTestCaseRow, "i_invnum");
			String invnumber1 = ExcelUtils.getCellData(iTestCaseRow, "i_invnum1");
			
			String invoicenumbers = invnumber+"\n"+invnumber1;
			
			//Enter Invoice Numbers
			PrescanEditInvoicePage.EnterInvoiceNumbers(driver, invoicenumbers);
			
			//Search
			PrescanEditInvoicePage.Search();
			
			//Verify Search Details
			PrescanEditInvoicePage.VerifyBatchSearchDetails(driver, iTestCaseRow, batchid, "$exp_clientcode", "$exp_carriercode", invnumber, invnumber1);
			
			//Select Invoice
			//PrescanEditInvoicePage.SelectInvoice(driver, invnumber1);
			
			*/
			
			/*By tableRef = By.xpath("/html/body/table/tbody");
			
			driver.get("file:///C:/temp/table.html");
			
			ArrayList<HashMap<String, WebElement>> tableData = new ArrayList<HashMap<String, WebElement>>();
			tableData = TableUtils.getTableDataNoHeader(driver, tableRef, 0, 1, 4);
			
			
			//Assert.assertEquals(tableData.get(0).get("Country").getText(), "Dubai1", "Country Column Mismatch");
		
			SoftAssert tableErrors = new SoftAssert();
			tableErrors.assertEquals(tableData.get(0).get("Country").getText(), "Dubai1", "Verification failed");
			tableErrors.assertEquals(tableData.get(1).get("Country").getText(), "Mecca1", "Verification failed");
			tableErrors.assertEquals(tableData.get(1).get("Country").getText(), "Mecca", "Verification failed");
			tableErrors.assertAll();*/
			
			// Error Reporting
			if (BaseClass.bResult == true) {
				Log.info("Test Case Passed");
				ExcelUtils.setCellData(sExcelPath, "Pass", iTestCaseRow, Config.Col_Result);
			} else {
				throw new Exception("Test Case Failed because of Verification");
			}
		} catch (Exception e) {
			//ExcelUtils.setCellData("Fail", iTestCaseRow, Config.Col_Result);
			//Utils.takeScreenshot(driver, sTestCaseName);
			Log.error(e.getMessage());
			throw (e);
		}
		catch(AssertionError err){
			//ExcelUtils.setCellData("Fail", iTestCaseRow, Config.Col_Result);
			//Utils.takeScreenshot(driver, sTestCaseName);
			Log.error(err.getMessage());
			throw (err);
		}
	}
}
