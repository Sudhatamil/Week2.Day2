package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithButtonFields {

	public static void main(String[] args) {
		//Launching browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Navigate to the homepage
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// 1.Go to Homepage
		driver.findElement(By.id("home")).click();
		driver.navigate().back();
		
		// 2.Get Position
		WebElement position = driver.findElement(By.id("position"));
		Point xyposition=position.getLocation();
		System.out.println("LOCATION:"+position.getLocation());
		int xvalue=xyposition.getX();
		int yvalue=xyposition.getY();
		System.out.println("Postion of x"+xvalue);
		System.out.println("Postion of y"+yvalue);	
			
		// 3.Button color
		WebElement FindButtonColor = driver.findElement(By.id("color"));
		String bgcolor=FindButtonColor.getCssValue("background-color");
		System.out.println("BGColor:"+bgcolor);
		String color=FindButtonColor.getCssValue("color");
		System.out.println("COLOR:"+color);
		
		String UStyle=FindButtonColor.getAttribute("style");
		System.out.println("Style="+UStyle);
	
		// 4.Height and width
		WebElement size=driver.findElement(By.id("size"));
		System.out.println("BSize:"+driver.findElement(By.id("size")).getSize());
		int height=size.getSize().getHeight();
		int width=size.getSize().getWidth();
		System.out.println("Height:"+height);
		System.out.println("width:"+width);
		
		driver.close();
		

	}
}