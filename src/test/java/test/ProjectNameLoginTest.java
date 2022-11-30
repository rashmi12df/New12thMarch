package test;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.OpenChrome;
import pom.ProjectNameLoginPage;
import utility.Baseclass;
import utility.ExcelData;
import utility.Report;
@Listeners(utility.Listeners.class)

public class ProjectNameLoginTest extends Baseclass{
	
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void addReport() {
		extent=Report.generateReport();
		
	}
	
	@BeforeMethod
	public void openbrowser() {
		 driver=OpenChrome.ClickURL();	
	}
	
    @Test
    public void logintest() throws EncryptedDocumentException, IOException {
    	test=extent.createTest("logintest");
    	ProjectNameLoginPage projectNameLoginPage =new ProjectNameLoginPage(driver); 
    //	driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
    	projectNameLoginPage.clickonLogin();
    	String email=ExcelData.Enterdata("Sheet2",1,2);
    	String password=ExcelData.Enterdata("Sheet2",2,2);
    	projectNameLoginPage.enterEmail(driver,email);
    	projectNameLoginPage.enterPassword(password);
    	projectNameLoginPage.clickonFinalLogin();
    	FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
    	wait.withTimeout(Duration.ofMillis(2000));
    	wait.pollingEvery(Duration.ofMillis(500));
    	wait.ignoring(Exception.class);
    	wait.until(ExpectedConditions.titleContains("Home | Mynaukri"));
    	String currenttitle=driver.getTitle();
    	Assert.assertEquals(currenttitle, "Home | Mynaukri");
    }
    
    @Test
    public void loginwithOTP() throws EncryptedDocumentException, IOException {
    	test=extent.createTest("loginwithOTP");
    	ProjectNameLoginPage projectNameLoginPage =new ProjectNameLoginPage(driver); 
    	projectNameLoginPage.clickonLogin();	
    	projectNameLoginPage.clickonUseOtptoLog(driver);
    	String number=ExcelData.Enterdata("Sheet2",3,2);
    	projectNameLoginPage.enternumber(number);
    	boolean b=projectNameLoginPage.otpenabled();
    	Assert.assertEquals(true, b);
    }

    @Test
    public void signinwithgoogle() throws EncryptedDocumentException, IOException {
    	test=extent.createTest("signinwithgoogle");
    	ProjectNameLoginPage projectNameLoginPage =new ProjectNameLoginPage(driver);
    	projectNameLoginPage.clickonLogin();
    	String email=ExcelData.Enterdata("Sheet2",1,2);	
    	projectNameLoginPage.clickonGooglesignin(driver,email);
    	String currenttitle=driver.getTitle();
    	Assert.assertEquals(currenttitle, "Sign in – Google accounts");
    }
    	
    @AfterMethod
    public void statusofResult(ITestResult result) {
    	if(result.getStatus()==ITestResult.FAILURE) 
    	{
    		test.log(Status.FAIL, result.getName());
    	}
    	else if(result.getStatus()==ITestResult.SKIP)
    	{
    		test.log(Status.SKIP, result.getName());		
    	}
    	else
    	{
    		test.log(Status.PASS, result.getName());
    	}	
    } 
    
    @AfterTest
    public void flushReport() {
    	extent.flush();
    }
}
