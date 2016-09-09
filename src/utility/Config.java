package utility;

public class Config {
	
	//Browser Name
	public static final String Browser_Name = "Mozilla";
	
	//Login Parameters
	public static final String Test_Client_URL = "https://ft.client.veraction.com";
	public static final String Test_Client_Username = "AUTOMATIONUSER1";
	public static final String Test_Client_Password = "DcYEe5T6ed";
	public static final String Test_Client_ClientCode = "accu";
	
	//Timeout Parameters
	public static final int Implicit_Timeout = 15;
	
	//Directory Path Parameters
	public static final String Path_BaseDir = System.getProperty("user.dir");
	public static final String Path_ScreenShot = Path_BaseDir+"//src//screenshots//";
	public static final String Path_TestData = Path_BaseDir+"//src//testData//";
	public static final String Path_ExtentReport = Path_BaseDir+"//results/TestResults.html";
	public static final String Path_ExtentReportConfig = Path_BaseDir+"//resources/extentreport.xml";
	public static final String Path_logFile = Path_BaseDir+"//logs/testlog.log";
	
	//Module Test Data Files
	public static final String File_PrescanManualInvoice_TestData = "PrescanManualInvoice_TestData.xlsx";
	
	//Database Details
	public static final String DB_Host = "accudbtest0.tw.accuship.com";
	public static final String DB_Port = "1521";
	public static final String DB_Name = "accutest";
	public static final String DB_username = "accustar";
	public static final String DB_password = "sp0nge";
	
	//Drivers Path Parameters
	public static final String Path_ChromeDriver = Path_BaseDir+"//resources//chromedriver.exe";
	public static final String Path_IEDriver = Path_BaseDir+"//resources//IEDriverServer.exe";
	
    //Test Data Sheet Columns
   	public static final int Col_TestCaseName = 0;	
   	public static final int Col_UserName =1 ;
   	public static final int Col_Password = 2;
   	public static final int Col_Browser = 3;
   	public static final int Col_Result = 1;
}
