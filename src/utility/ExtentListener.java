package utility;

import com.relevantcodes.extentreports.*;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;

import java.util.Arrays;
import java.util.Locale;

/**
 * Created by andrey.smirnov on 14.06.2016.
 */
public class ExtentListener implements IResultListener {

    public ExtentReports reporter =  new ExtentReports("build/SimpleReport.html", false, DisplayOrder.NEWEST_FIRST, NetworkMode.OFFLINE, Locale.ENGLISH);
    public ExtentTest testReporter;


    @Override
    public void onTestStart(ITestResult result) {
        testReporter = reporter.startTest(result.getMethod().getMethodName(), "Some description");
        testReporter.log(LogStatus.INFO, "Starting test " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testReporter.log(LogStatus.PASS, "Test PASSED");
        reporter.endTest(testReporter);
        reporter.flush();
    }

    @Override
    public void onFinish(ITestContext context) {
        reporter.close();
    }

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConfigurationSuccess(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConfigurationFailure(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConfigurationSkip(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}

   // Other interface methods
}