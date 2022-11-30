package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	public static void picture(WebDriver driver,String name) throws IOException {
		String ctime=Screenshot.time();
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    File destination=new File("C:\\Users\\hp\\eclipse-workspace\\Sahiba\\Screenshot\\"+name+ctime+".jpg");
	    FileHandler.copy(source, destination);   
	}
	public static String time() {
		DateTimeFormatter pattern=DateTimeFormatter.ofPattern("yyyy-MMM-dd HH-mm-ss");
		LocalDateTime time=LocalDateTime.now();
		String timeformat=pattern.format(time);
		return timeformat;
	}
	
}
