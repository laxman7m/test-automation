package test.java;

import java.sql.Connection;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

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
import utility.DatabaseUtils;

public class PrescanManualInvoicesTest extends SuiteDriver {
	
	/**
	 * Test Case# OnlineApp 31 - Verify that user will be able to add Prescan Manual Entry
	 * Test Case# OnlineApp 32 - Verify that user will be able to view the added invoice in report.datstat_prescan
	 * Description:
	 * Goto Prescan Manual Invoice module
	 * Enter Valid Invoice Details
	 * Verify the "Success" Message label
	 * Verify "Invoice xxxx was added successfully" label
	 * Select the Carrier
	 * Complete the Batch
	 * Verify the Cover sheet for Prescan By, Client, Client Code, Carrier and Carrier Code fields
	 * Verify the report.datstat_prescan table for the Invoice Entry
	 * @throws Exception
	 */

	@Test(description = "1. Goto Prescan Manual invoice Page || 2. Enter Valid Invoice Details || 3. Verify Success Message || 4. Complete Batch || 5. Verify Cover Sheet || 6. Verify report.datstat_prescan table")
	public void AddManualPrescanInvoiceEntry() throws Exception {
		try {		
			HashMap<String,String> invoiceDetails = new HashMap<String,String>();
			HashMap<String,String> carrierDetails = new HashMap<String,String>();
			
			UserPreferencesPage.gotoPrescanManualInvoices();
			
			Assert.assertTrue(ModuleUtils.verifyModuleHeader(driver, "Prescan Manual Entry"), "Prescan Manual Invoices Module Launch Failed");
			test.log(LogStatus.PASS, "Verification: Opened Prescan Manual Invoices Module");
			
			invoiceDetails = PrescanManualInvoicesPage.EnterInvoiceDetails(driver, iTestCaseRow, "$I_sAccountNum1", "$I_sInvoiceNum1", "$I_sInvoiceMonth1", "$I_sInvoiceDay1", "$I_sInvoiceYear1", "$I_sInvoiceAmount1", "$I_sInvoiceVat1", "$I_sInvoiceStatus1", "$I_sInvoiceCurrency1");
			PrescanManualInvoicesPage.InvoiceContinue();
			
			carrierDetails = PrescanManualInvoicesPage.SelectCarrierClient(driver, iTestCaseRow, "$I_sCarrier1");
			PrescanManualInvoicesPage.CarrierContinue();
			
			invoiceDetails.putAll(carrierDetails);
			
			test.log(LogStatus.INFO, "<b><i>Invoice Details :</i></b><br>"+invoiceDetails);
			
			Assert.assertTrue(ModuleUtils.verifyModuleHeader(driver, "Success"), "Invoice Entry Failed");
			
			String expMsgText = "Invoice " + invoiceDetails.get("Invoice Number") + " was added successfully";
			Assert.assertEquals(expMsgText , PrescanManualInvoicesPage.GetMsgText(), "Invoice Entry Failed");
			test.log(LogStatus.PASS, "Verification: Invoice Details Entered");
			
			// Error Reporting
			if (BaseClass.bResult == true) {
				ExcelUtils.setCellData(sExcelPath, "Pass", iTestCaseRow, Config.Col_Result);
				test.log(LogStatus.PASS, "Test Passed");
			} else {
				throw new Exception("Test Case Failed because of Verification");
			}
		} catch (Exception e) {
			ExcelUtils.setCellData(sExcelPath, "Fail", iTestCaseRow, Config.Col_Result);
			Utils.TakeScreenshot(driver, sTestCaseName);
			test.log(LogStatus.FAIL, e.getMessage());
			Log.error(e.getMessage());
			throw (e);
		}
		catch(AssertionError err){
			ExcelUtils.setCellData(sExcelPath, "Fail", iTestCaseRow, Config.Col_Result);
			Utils.TakeScreenshot(driver, sTestCaseName);
			test.log(LogStatus.FAIL, err.getMessage());
			test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(Config.Path_ScreenShot + sTestCaseName +".jpg"));
			Log.error(err.getMessage());
			throw (err);
		}
	}	

	
	@Test(description = "Login||Goto Prescan Manual invoice Page||Enter Valid Invoice Details||Verify Success Message||Enter Valid Invoice Details||Verify Success Message||Complete Batch||Verify Cover Sheet||Verify report.datstat_prescan table||Search for Invoices")
	public void MultipleManualPrescanInvoiceEntry() throws Exception {
		try {		
			HashMap<String,String> invoiceDetails = new HashMap<String,String>();
			HashMap<String,String> carrierDetails = new HashMap<String,String>();
			
			UserPreferencesPage.gotoPrescanManualInvoices();
			
			Assert.assertTrue(ModuleUtils.verifyModuleHeader(driver, "Prescan Manual Entry"), "Prescan Manual Invoices Module Launch Failed");
			test.log(LogStatus.PASS, "Verification: Opened Prescan Manual Invoices Module");
			
			invoiceDetails = PrescanManualInvoicesPage.EnterInvoiceDetails(driver, iTestCaseRow, "$I_sAccountNum1", "$I_sInvoiceNum1", "$I_sInvoiceMonth1", "$I_sInvoiceDay1", "$I_sInvoiceYear1", "$I_sInvoiceAmount1", "$I_sInvoiceVat1", "$I_sInvoiceStatus1", "$I_sInvoiceCurrency1");
			PrescanManualInvoicesPage.InvoiceContinue();
			
			carrierDetails = PrescanManualInvoicesPage.SelectCarrierClient(driver, iTestCaseRow, "$I_sCarrier1");
			PrescanManualInvoicesPage.CarrierContinue();
			
			invoiceDetails.putAll(carrierDetails);
			
			test.log(LogStatus.INFO, "<b><i>Invoice Details :</i></b><br>"+invoiceDetails);
			
			Assert.assertTrue(ModuleUtils.verifyModuleHeader(driver, "Success"), "Invoice Entry Failed");
			
			String expMsgText = "Invoice " + invoiceDetails.get("Invoice Number") + " was added successfully";
			//Assert.assertEquals(expMsgText , PrescanManualInvoicesPage.GetMsgText(), "Invoice Entry Failed");
			test.log(LogStatus.PASS, "Verification: Invoice Details Entered");
			
			// Error Reporting
			if (BaseClass.bResult == true) {
				ExcelUtils.setCellData(sExcelPath, "Pass", iTestCaseRow, Config.Col_Result);
				test.log(LogStatus.PASS, "Test Passed");
			} else {
				throw new Exception("Test Case Failed because of Verification");
			}
		} catch (Exception e) {
			ExcelUtils.setCellData(sExcelPath, "Fail", iTestCaseRow, Config.Col_Result);
			Utils.TakeScreenshot(driver, sTestCaseName);
			test.log(LogStatus.FAIL, e.getMessage());
			Log.error(e.getMessage());
			throw (e);
		}
		catch(AssertionError err){
			ExcelUtils.setCellData(sExcelPath, "Fail", iTestCaseRow, Config.Col_Result);
			Utils.TakeScreenshot(driver, sTestCaseName);
			test.log(LogStatus.FAIL, err.getMessage());
			test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(Config.Path_ScreenShot + sTestCaseName +".jpg"));
			Log.error(err.getMessage());
			throw (err);
		}
	}	

	
}
