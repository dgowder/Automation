package CommonUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class listener implements ITestListener {
	
	ExtentReports extent=extentReportNG.extentReportGenerator();
	ExtentTest testcase;

	base b = new base();
	public void onTestFailure(ITestResult result) {

		testcase.fail(result.getThrowable());
		try {
			b.getScreenShot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestStart(ITestResult result) {
		testcase=extentReportNG.extent.createTest(result.getMethod().getMethodName());
	
	}

	public void onTestSuccess(ITestResult result) {
     testcase.log(Status.PASS,"Successfull");
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

		extent.flush();
	}
}
