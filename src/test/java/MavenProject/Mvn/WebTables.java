package MavenProject.Mvn;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {

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
		
		driver.get("http://omayo.blogspot.com/");
		// List<WebElement> headings = driver.findElements(By.xpath("//table[@id='table1']//thead"));// print head of the table
		 List<WebElement> data = driver.findElements(By.xpath("//table[@id='table1']//td"));// print entire table data
		// List<WebElement> data = driver.findElements(By.xpath("//table[@id='table1']//tr[1]//td"));// prints first row of the table
		// List<WebElement> data = driver.findElements(By.xpath("//table[@id='table1']//tr[3]//td[2]"));// prints 3rd row, 2nd column
		for(int i=0;i<data.size();i++)
		{
			System.out.println(data.get(i).getText());
		}
		
	}

}
