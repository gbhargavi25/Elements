package MavenProject.Mvn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {

	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.ebay.com/");
		
		//dynamic wait(if application loaded in 5 seconds rest of the seconds will be ignored)
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		// pageLoadTimeout is used for wait for some time to load the page
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //applicable for all elements

	}

}
