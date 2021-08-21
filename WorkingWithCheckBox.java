package Week2.Day2;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithCheckBox {

	public static void main(String[] args) {
		//Launching the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Navigate to the desire page
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// 1.Select the language that you know?
		driver.findElement(By.xpath("(//input[contains(@type,'checkbox')])[1]")).click();

		// 2.Confirm selenium is checked
		WebElement isselect = driver.findElement(By.xpath("(//input[contains(@type,'checkbox')])[6]"));
		if (isselect.isSelected()) {
			System.out.println("selenium selection is confirmed");
		}

		// 3.Deselect only checked
		WebElement element = driver.findElement(By.xpath("(//input[@type='checkbox'])[8]"));
		if (element.isSelected()) {
			driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")).click();
		}

		// 4.Select all below Check Boxes
		int size = driver.findElementsByXPath("//label[text()='Select all below checkboxes ']/following::input").size();
		System.out.println(size);

		for (int i = 1; i <= size; i++) {

			driver.findElementByXPath("(//label[text()='Select all below checkboxes ']/following::input)[" + i + "]")
					.click();
		}

	}
}
