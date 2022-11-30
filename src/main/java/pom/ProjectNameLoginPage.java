package pom;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProjectNameLoginPage {
	
	
	@FindBy (xpath="//a[@id='login_Layer']")private WebElement login;
	@FindBy (xpath="//a[@title='Jobseeker Register']") private WebElement register;
	@FindBy (xpath="//input[@placeholder='Enter skills / designations / companies']") private WebElement skill;
	@FindBy (xpath="//input[@name='expereinceDD']") private WebElement experience;
	@FindBy (xpath="//input[@placeholder='Enter location']") private WebElement location ;
	@FindBy (xpath="//input[@placeholder='Enter your active Email ID / Username']") private WebElement emailID;
	@FindBy (xpath="//input[@type='password']") private WebElement password;
	@FindBy (xpath="//button[@type='submit']") private WebElement finallogin;
	@FindBy (xpath="//button[contains(@class,'btn-primary waves-effect')]") private WebElement useOtptologin;
	@FindBy (xpath="//input[@type='tel']") private WebElement number;
	@FindBy (xpath="//button[contains(@class,'btn-primary waves-effect waves-light btn-large b')]") private WebElement otp;
	@FindBy (xpath="//button[contains(@class,'btn-primary waves-effect waves-light btn-large email')]") private WebElement useEmailtoLogin;
	@FindBy (xpath="//div[@class='google']") private WebElement googlesignin;
	@FindBy (xpath="//input[@type='email']") private WebElement googlemail;
	
	
	
	public ProjectNameLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	public void clickonLogin() {
		login.click();
	}
	public void clickonRegister() {
		register.click();
	}
	public void enterskilss(String skills) {
		skill.sendKeys(skills);
	}
	
	public void enterExperience(String YoE) {
		experience.sendKeys(YoE);
	}
	
	public void enterLocation(String cityname) {
		location.sendKeys(cityname);
	}
	
	public void enterEmail(WebDriver driver,String email) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(4000));
    	wait.until(ExpectedConditions.visibilityOf(emailID));
		emailID.sendKeys(email);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	public void clickonFinalLogin() {
		finallogin.click();
	}
	
	public void clickonUseOtptoLog(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(4000));
    	wait.until(ExpectedConditions.visibilityOf(useOtptologin));
		useOtptologin.click();
	}
	public void enternumber(String Mobile) {
		number.sendKeys(Mobile);
	}
	
	public boolean otpenabled() {
		 return otp.isEnabled();	 	
	}
	
	public void clickonEmailtoLog() {
		useEmailtoLogin.click();
	}
	
	public void clickonGooglesignin(WebDriver driver,String mail) {
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(5000));
     wait.until(ExpectedConditions.visibilityOf(googlesignin));	
	 googlesignin.click();
	 Set<String>handle=driver.getWindowHandles();
	 Iterator<String>win=handle.iterator();
	 while(win.hasNext())
	 {
		String reqhandle= win.next();
		driver.switchTo().window(reqhandle);
		String title=driver.getTitle();
		if(title.equals("Sign in – Google accounts"))
		{
			googlemail.sendKeys(mail);
		}
	 }
	
	 
	}

}
