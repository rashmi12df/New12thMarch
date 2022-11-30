package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {
	public static ExtentReports generateReport() {
	ExtentSparkReporter htmlreport=new ExtentSparkReporter("newreport.html"); 
	ExtentReports extent=new ExtentReports();
    extent.attachReporter(htmlreport);
    extent.setSystemInfo("Project Name", "Sahiba");
    extent.setSystemInfo("Created By", "Rashmi S");
    extent.setSystemInfo("Client Name", "n-Able MD");
    return extent;

}}
