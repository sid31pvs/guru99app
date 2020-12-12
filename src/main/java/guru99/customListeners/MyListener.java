package guru99.customListeners;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import guru99.base.BaseTest;
import guru99.utility.Utilities;

public class MyListener implements ITestListener {
	ExtentSparkReporter sparkreporter;
	ExtentReports Ereport;
	ExtentTest Etest;
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();
	

	public void onTestStart(ITestResult result) {
		System.out.println("Test Execution has Started : " + result.getName());
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "guru99Report-"+timeStamp+".html";
		
	    // extentTestThread = new ThreadLocal<ExtentTest>();

		sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\test-output\\Extent-report\\"+reportName);
		sparkreporter.config().setDocumentTitle("guru99application");
		sparkreporter.config().setReportName("Functionality Testing");
		sparkreporter.config().setTheme(Theme.DARK);

		Ereport = new ExtentReports();
		Ereport.attachReporter(sparkreporter);

		Ereport.setSystemInfo("Host Name", "Localhost");
		Ereport.setSystemInfo("Envionment", "QA");
		Ereport.setSystemInfo("OS", "Windows-10");
		Ereport.setSystemInfo("Tester name", "Siddhant");

	    Etest = Ereport.createTest("Test Execution has Started for " +result.getName());
		//extentTestThread.set(Etest);
	}

	public void onFinish(ITestContext context) {
		//System.out.println("Test execution has Finished : " +context.getName());
//		extentTestThread.get().info("Test has finished");
		Ereport.flush();
	}

	public void onTestFailure(ITestResult result) {
		String methodname = result.getName();
		System.out.println("Test execution has failed : " +result.getName());
		Etest = Ereport.createTest(result.getName());

		extentTestThread.get().log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		extentTestThread.get().log(Status.FAIL, "Test execution has failed "+result.getThrowable());
		extentTestThread.get().info("Test is failed,screenhot has been taken, check be screenshot");

		System.out.println("screenhot has been taken, check screenshot folder");

		String screenshotpath = Utilities.takeScreenShot(methodname);
		try {
			extentTestThread.get().addScreenCaptureFromPath(screenshotpath, methodname);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		Etest = Ereport.createTest(result.getName());
		System.out.println("Test execution has skipped :" +result.getName());
		extentTestThread.get().log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.YELLOW));
		extentTestThread.get().info("Test execution has skipped for " +result.getName());
	}

	public void onTestSuccess(ITestResult result) {

		System.out.println("Test Method execution has passed successfully : " + result.getName());
		Etest = Ereport.createTest(result.getName());
		extentTestThread.get().log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		extentTestThread.get().info("Test execution has passed for " + result.getName());
	}

}
