package MavenProject.Mvn;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectdropdownValue {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		driver.get("https://www.mercurytravels.co.in/");
		
		WebElement holiday = driver.findElement(By.id("themes"));
		Select st = new Select(holiday);
		st.selectByValue("16");
		st.selectByIndex(2);
		Thread.sleep(3000);
		WebElement value = st.getFirstSelectedOption();
		String gfds = value.getText();
		System.out.println(gfds);
		driver.close();

	}

}
