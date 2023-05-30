package MavenProject.Mvn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountOfImages {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		List<WebElement> images= driver.findElements(By.tagName("img"));
		System.out.println("no of images are:"+""+images.size());
		
		for(int i= 0;i<images.size();i++)
		{
			System.out.println(images.get(i).getAttribute("src"));
		}
		
		driver.close();
		
	}

}
