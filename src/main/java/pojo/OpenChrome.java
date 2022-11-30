package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenChrome {
	public static WebDriver ClickURL() {
	//	System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Chrome 106\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		return driver;
	}
}
