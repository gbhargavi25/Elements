package MavenProject.Mvn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendar2 {

	public static void main(String[] args) 
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		// selecting date in the current month
		
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		// driver.findElement(By.id("second_date_picker")).click();
		// driver.findElement(By.xpath("//a[contains(text(),'12')]")).click();
		
		// selecting date in the previous month
		
		driver.findElement(By.id("second_date_picker")).click();
		driver.findElement(By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'22')])[4]")).click();
		
		

	}

}
