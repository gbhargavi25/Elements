package MavenProject.Mvn;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

// program to get the location by giving the name

public class WebTables2 {

	public static void main(String[] args) 
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTim)
	//	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.get("http://omayo.blogspot.com/");
		
		String givenName = "Praveen";
		
		List<WebElement> names = driver.findElements(By.xpath("//table[@id='table1']//td[1]"));
		
		int row=0;
		
		for(int i=0;i<names.size();i++)
		{
			if(names.get(i).getText().equals(givenName))
			{
				row=i;
			}
		}
		String path = "//table[@id='table1']//tr["+(row+1)+"]//td[3]";
		System.out.println(driver.findElement(By.xpath(path)).getText());
		
		System.out.println(driver.findElements(By.xpath("//table[@id='table1']//tbody//tr")).size());// prints count of rows excluding head
		System.out.println(driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[1]//td")).size());// prints count of columns 
		
		
		driver.close();
		
	}

}
