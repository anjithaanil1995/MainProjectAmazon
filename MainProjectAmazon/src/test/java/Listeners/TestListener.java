package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import util.Screenshotutil;



public class TestListener implements ITestListener {
	@Override
	public void onTestFailure(ITestResult result) {
	    String testName = result.getName();
	    Screenshotutil.takeScreenshot(testName);
	    System.out.println("Screenshot taken for failed test: " + testName);
	}

	@Override public void onTestStart(ITestResult result) {}
	@Override public void onTestSuccess(ITestResult result) {}
	@Override public void onTestSkipped(ITestResult result) {}
	@Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
	@Override public void onStart(ITestContext context) {}
	@Override public void onFinish(ITestContext context) {}



}
