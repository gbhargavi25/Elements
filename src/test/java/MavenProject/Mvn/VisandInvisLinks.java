package MavenProject.Mvn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VisandInvisLinks {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.google.com/");
		List<WebElement>links= driver.findElements(By.tagName("a"));
		 int count = 0;
	       for (int i = 0;i<links.size();i++)
	       {
	    	   if(links.get(i).isDisplayed())
	    	   {
	    		   count++;
	    	   }
	       }
	       System.out.println("no of total links"+""+links.size());
	       System.out.println("no of visible links"+""+count);
	       System.out.println("no of invisible links"+""+(links.size()-count));
	       
		}

	}


