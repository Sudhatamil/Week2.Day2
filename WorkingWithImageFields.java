package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithImageFields {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launching the webpage
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//1.click on this image to go home page
		driver.findElement(By.xpath("(//img)[2]")).click();
		driver.navigate().back();
		
		//2.Find Broken Image
		WebElement brokenimage=driver.findElement(By.xpath("//img[contains(@src,'../images/abcd.jpg')]"));
		String size=brokenimage.getAttribute("naturalWidth");
		if(size.equals("0"))
		{
			System.out.println("Broken image");
		}
		else
		{
			System.out.println("not Broken image");
		}
		
		
		driver.findElement(By.xpath("(//img)[4]")).click();
		
	}

}
