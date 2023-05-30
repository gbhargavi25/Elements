package MavenProject.Mvn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountofDropdowns {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
			WebDriverManager.chromedriver().setup();
			WebDriver driver= new ChromeDriver(options);
			driver.manage().window().maximize();
			
			driver.get("https://www.mercurytravels.co.in/");
			
			List<WebElement> dropdown= driver.findElements(By.tagName("select"));
			System.out.println("no of dropdowns are:"+""+dropdown.size());
			driver.close();

	}

}
