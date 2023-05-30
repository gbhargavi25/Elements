package MavenProject.Mvn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomXpath {

	public static void main(String[] args)
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.ebay.com/");
		// driver.findElement(By.xpath("//input[@placeholder='Search for anything']")).sendKeys("electronics"); 	
		//driver.findElement(By.xpath("//input[contains(@id,'gh-ac')]")).sendKeys("electronics");
		// another way of writing xpath by using contains method it is used to handle dynamic id's i.e changing the values frequently
		//driver.findElement(By.xpath("//input[starts-with(@id,'gh-a')]")).sendKeys("electronics");
		// xpath by using starts-with method 
		//driver.findElement(By.xpath("//input[ends-with(@id,'ac')]")).sendKeys("mobiles");
		// xpath by using ends with method
	
// example:
	// dynamic id:input
	// id = test_123
	
	// starts-with
	// id = test_456
	// id = test_789
	
	// ends-with
	// id = 1234_test_t
	// id = 6786_test_t
	// id = 6777_test_t
	
	// for links custom xpath
	// all the links are represented by <a> html tag
		driver.findElement(By.xpath("//a[contains(text(),'My eBay')]")).click();
	}
	
	
}

