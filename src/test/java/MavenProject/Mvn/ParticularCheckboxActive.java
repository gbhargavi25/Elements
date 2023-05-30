package MavenProject.Mvn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParticularCheckboxActive {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("http://omayo.blogspot.com/");
		Thread.sleep(1000);
		WebElement blue= driver.findElement(By.id("checkbox2"));
		blue.click();
		if(blue.isSelected()) 
		{
			System.out.println("checkbox is working properly");
		}
		else
		{
			System.out.println("checkbox is not working properly");
		}
		driver.close();

	}

}
