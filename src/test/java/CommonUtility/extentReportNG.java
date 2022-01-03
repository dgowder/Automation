package CommonUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extentReportNG {
	 static ExtentReports extent;
	 static ExtentTest testcase;	

	public static ExtentReports extentReportGenerator()
	{
		extent=new ExtentReports();
		ExtentHtmlReporter htmlReport=new ExtentHtmlReporter("ExtentReport.html");
		extent.attachReporter(htmlReport);
		extent.setSystemInfo("Test Environment", "Deepak");
		return extent;
	}
	
}
