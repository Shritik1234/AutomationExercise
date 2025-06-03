package automationPractice.listeners;

import java.io.IOException;
import java.util.Date;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import automationPractice.base.TestcaseBase;
import utilities.ExtentManager;
import utilities.TestUtil;

public class CustomListeners extends TestcaseBase implements ITestListener, ISuiteListener {
	
	public static String fileName;
	
	 static Date d = new Date();
	 //static String filename = "Extents"+d.toString().replace(":", "_").replace(" ","_")+".html";
	static String filename = "Extents"+".html";
	 private static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+filename);
	 //public static ExtentTest test;
	

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		test = extent.createTest(result.getTestClass().getName()+"@Test"+result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " PASSED" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		test.pass(m);


	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("Click to see screenshot");
		Reporter.log("<a target = \"_blank\" href="+TestUtil.screenshotName+" >Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target = \"_blank\" href="+TestUtil.screenshotName+" ><img src="+TestUtil.screenshotName+" height =200 width = 200></img></a>");

		
		
		
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " FAILED"+"</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		test.log(Status.FAIL,m);
		test.log(Status.FAIL,"Failed with exception"+result.getThrowable());
		test.fail("<b><font color=red>" + "Screenshot of failure" + "</font></b><br>",MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenshotName)
			.build());
		
		
		
		
	
	
	}

	public void onTestSkipped(ITestResult result) {
		
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {

		// TODO Auto-generated method stub


	}

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ISuite suite) {
		if (extent != null) {

			extent.flush();
		}
		
	}

}
