package MavenProject.Mvn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkNameandurl {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");
		
		 List<WebElement>links= driver.findElements(By.tagName("a"));
	       
	       for (int i = 0;i<links.size();i++)
	       {
	    	   if(links.get(i).isDisplayed())
	    	   {
	    		  String lname = links.get(i).getText();
	    		  links.get(i).click();
	    		  String url = driver.getCurrentUrl();
	    		  System.out.println(lname+""+url);
	    		  driver.navigate().back();
	    		  links= driver.findElements(By.tagName("a"));
	    		  
	       }
	    	  
		}
	       driver.close();

	}

}
