import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TutorialNinjaProject {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

		driver.get("https://tutorialsninja.com/demo/");

		// navigating to login page

		driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
		driver.findElement(By.linkText("Login")).click();

		// login to the application with valid credentials

		driver.findElement(By.id("input-email")).sendKeys("bhargavig@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("satyadurga");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		// validating whether we have logged in or not by checking breadcrumb

		System.out.println(
				driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[contains(text(),'Account')]")).isDisplayed()); // true

		// searching for iphone

		driver.findElement(By.name("search")).sendKeys("iphone");
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();

		// validating whether we have displayed iphone page or not

		System.out.println(
				driver.findElement(By.xpath("//div[@class='caption']//a[contains(text(),'iPhone')]")).isDisplayed()); // true

		driver.findElement(By.xpath("//div[@class='caption']//a[contains(text(),'iPhone')]")).click();

		System.out.println(
				driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[contains(text(),'iPhone')]")).isDisplayed()); // true

		// clear and edit quantity as 2

		driver.findElement(By.id("input-quantity")).clear();

		driver.findElement(By.id("input-quantity")).sendKeys("2");

		// adding the item to cart

		driver.findElement(By.id("button-cart")).click();

		// validating the success message is displayed or not

		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"))
				.getText().contains("Success: You have added iPhone to your shopping cart!"));// true

		// navigating to shopping cart

		driver.findElement(By.xpath("//a[text()='shopping cart']")).click();

		// navigating to checkout page

		driver.findElement(By.xpath("//a[text()='Checkout']")).click();

		// filling the details in checkout page

		driver.findElement(By.id("input-payment-firstname")).sendKeys("shyrtgs");
		driver.findElement(By.id("input-payment-lastname")).sendKeys("gfghh");
		driver.findElement(By.id("input-payment-company")).sendKeys("sadup soft");
		driver.findElement(By.id("input-payment-address-1")).sendKeys("kphb");
		driver.findElement(By.id("input-payment-city")).sendKeys("Hyderabad");
		driver.findElement(By.id("input-payment-postcode")).sendKeys("500037");

		WebElement country = driver.findElement(By.id("input-payment-country"));

		Select st = new Select(country);
		st.selectByVisibleText("India");

		WebElement state = driver.findElement(By.id("input-payment-zone"));

		Select st2 = new Select(state);
		st2.selectByVisibleText("Andhra Pradesh");

		Thread.sleep(2000);

		driver.findElement(By.id("button-payment-address")).click();

		Thread.sleep(2000);

		driver.findElement(By.id("button-shipping-address")).click();

		Thread.sleep(2000);

		driver.findElement(By.id("button-shipping-method")).click();

		Thread.sleep(2000);

		driver.findElement(By.name("agree")).click();

		driver.findElement(By.id("button-payment-method")).click();

		driver.findElement(By.id("button-confirm")).click();

		System.out
				.println(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed()); // true

		System.out.println(driver.findElement(By.xpath("//div[@id='content']/h1[text()='Your order has been placed!']"))
				.isDisplayed()); // true

	}

}
 