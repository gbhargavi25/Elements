package MavenProject.Mvn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeaderLinks {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.google.com/");
		
		WebElement header = driver.findElement(By.id("gb"));
	       List<WebElement>headerlinks= header.findElements(By.tagName("a"));
	       
	       System.out.println("no of total links"+""+headerlinks.size());
	       
	       for(int i= 0;i<headerlinks.size();i++)
	       {
	    	   System.out.println(headerlinks.get(i).getText());
	       }
	       driver.close();
}

	}

