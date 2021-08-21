package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithRadioButtonFields {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// 1.Are you enjoying the classes
		driver.findElement(By.xpath("(//input[contains(@type,'radio')])[1]")).click();
		
		// 2.Find the default selection of radio button
		WebElement element = driver.findElement(By.xpath("(//input[contains(@name,'news')])[2]"));
		if (element.isSelected()) {
			System.out.println("default radio button is checked");
		} else {
			System.out.println("default radio button is unchecked");
		}
		
		// 3.select your age group (only it wasnt selected)
		int myage = 30;
		if (myage < 20) {
			driver.findElement(
					By.xpath("//label[contains(text(),'Select your age group')]/following::input[@value='0']")).click();
			System.out.println("My age group is 1-20");

		} else if (myage > 40) {
			driver.findElement(
					By.xpath("//label[contains(text(),'Select your age group')]/following::input[@value='1']")).click();
			System.out.println("My age group is above 40");
		} else {
			System.out.println("My age group is above 20-40");
		}
	}
}