package MavenProject.Mvn;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownValuesActive {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		driver.get("https://www.mercurytravels.co.in/");
		  WebElement holiday = driver.findElement(By.id("themes"));
	       List<WebElement>values= holiday.findElements(By.tagName("option"));
	       System.out.println("no of total values"+""+values.size());
	       for(int i=0 ;i<values.size();i++)
	       {
	    	String name= values.get(i).getText();
	    	values.get(i).click();
	    	if(values.get(i).isDisplayed())
	    	{
	    		 System.out.println(name+""+ "Active");
	    	}
	    	else
	    	{
	    		System.out.println(name+""+"unActive");
	    	}
	    	   
	       }
	       driver.close();
	}

}
