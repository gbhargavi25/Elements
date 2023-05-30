package MavenProject.Mvn;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender {

	public static void main(String[] args) throws InterruptedException
	{
		String datevalue=null;
		String date="32-Feb-2021";
		String dateArr[]=date.split("-");
		String day=dateArr[0];
		String month=dateArr[1];	
		String year=dateArr[2];
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		
		driver.findElement(By.id("third_date_picker")).click();
		
		Select Monthselect=new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")));
		Monthselect.selectByVisibleText(month);
		
		Select yearselect=new Select(driver.findElement(By.className("ui-datepicker-year")));
		yearselect.selectByVisibleText(year);
		
		String before_xpath="//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[";
		String After_xpath="]/td[";
		
		final int totalWeekDays=7;
		boolean flag=false;
		
		for(int rowNo=1;rowNo<=6;rowNo++) {
			for(int colNo=1;colNo<=totalWeekDays;colNo++) {
				try {
					datevalue=driver.findElement(By.xpath(before_xpath+rowNo+After_xpath+colNo+"]")).getText();					
				}catch(NoSuchElementException e) {
					System.out.println("6the row not available or else plz enter Valid date");
					flag=false;
					break;
				}
				System.out.println(datevalue);
				if(datevalue.equals(day)) {
					driver.findElement(By.xpath(before_xpath+rowNo+After_xpath+colNo+"]")).click();
					flag=true;
					break;
				}
			}
			if(flag) {
				break;
			}
		}
		
		
		
	}
	

}
