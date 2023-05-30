package MavenProject.Mvn;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowPopup {

	public static void main(String[] args) throws InterruptedException
	{
		
		//1. alerts-- javascript popup--alerts API(accept,dismiss)
		//2. file upload popup--browse button(type= file,sendkeys(path)
		//3. browse window popup--advertisement popup(windowHandle API--getWindowHandles())
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://www.dummysoftware.com/popupdummy_testpage.html");
		driver.findElement(By.name("PushButton")).click();
		
		Thread.sleep(3000);
		
		Set<String> handler = driver.getWindowHandles();
		
		Iterator<String> it= handler.iterator();
		
		String parentWindowid= it.next();
		System.out.println("parent window id is:"+parentWindowid);
		
		String childWindowid = it.next();
		System.out.println("child window id is:"+childWindowid);
		
		driver.switchTo().window(childWindowid);
		
		Thread.sleep(3000);
		
		System.out.println("child window pop up title is"+driver.getTitle());
		
		driver.close();
		driver.switchTo().window(parentWindowid);
		
		Thread.sleep(3000);
		
		System.out.println("parent window title"+driver.getTitle());
	}

}
