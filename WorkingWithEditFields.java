package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithEditFields {

	public static void main(String[] args) {
		//Launch the browser		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Navigate to the webpage
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//1.Enter Your Email Address
		driver.findElement(By.xpath("//input[contains(@id,'email')]")).sendKeys("sudhatamilselvan7@gmail.com");
		
		//2.Append text and press Keyboard tab
		driver.findElement(By.xpath("//input[contains(@value,'Append')]")).sendKeys("Additional Text added",Keys.TAB);
		
		//3.Get default text entered
		String defaulttext=driver.findElement(By.xpath("//input[contains(@name,'username')]")).getAttribute("value");
		System.out.println("Default text Entered"+defaulttext);
		
		//4.Clear a Text
		driver.findElement(By.xpath("//input[contains(@value,'Clear')]")).clear();
		
		//5.Confirm that edit field is disabled
		WebElement checkingvisibility=driver.findElement(By.xpath("//input[contains(@disabled,'true')]"));
		if(checkingvisibility.isEnabled())
		{
			System.out.println("Textbox is enabled ");
			
		}
		
		else
		{
			System.out.println("Textbox is disabled");
		}
		}

}
