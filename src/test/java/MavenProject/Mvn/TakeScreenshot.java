package MavenProject.Mvn;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshot {

	public static void main(String[] args) throws IOException
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.ebay.com/");
		
		// take screenshot and store as a file format
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		// copy the screenshot to desired location using copyFile method
		
		FileUtils.copyFile(src, new File("C:\\Users\\Satyadurga\\eclipse-workspace\\Mvn\\src\\test\\java\\MavenProject\\Mvn\\ebay.png"));


	}

}
