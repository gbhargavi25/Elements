package MavenProject.Mvn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusofCheckbox {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("http://omayo.blogspot.com/");
		
		List<WebElement> checkbox = driver.findElements(By.xpath("//*[@type='checkbox']")); 
		System.out.println("total no of check boxes are:"+""+checkbox.size());
		for(int i=0;i<checkbox.size();i++)
		{
			String cname = checkbox.get(i).getAttribute("value");
			if(checkbox.get(i).isSelected())
			{
				System.out.println(cname+""+ "active");
			}
				else {
					
					System.out.println(cname+""+ "inactive");
				
				}
			}
		driver.close();
				
		}

	}

