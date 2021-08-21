package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithLinkFields {

	public static void main(String[] args) {
				
		//Launching browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Navigate to the webpage
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// 1.Go to Home Page
		driver.findElement(By.xpath("(//a[contains(text(),'Go to Home Page')])[1]")).click();
		String Homepage1 = driver.getTitle();
		driver.navigate().back();
		
		//2.Find where am supposed to go without clicking me
		String hrefText = driver.findElement(By.xpath("(//a[contains(text(),'Go to Home Page')])[1]"))
				.getAttribute("href");
		System.out.println(hrefText);
		
		//3.Verify am I broken?
		driver.findElement(By.xpath("//a[contains(text(),'I broken?')]")).click();
		String pagetitle = driver.getTitle();
		System.out.println("Title:" + pagetitle);
		if (pagetitle.contains("404"))
			System.out.println("link is navigating to the Broken page");
		driver.navigate().back();

		//4.Go to Homepage(Interace with same Link name)
		driver.findElement(By.xpath("(//a[contains(text(),'Go to Home Page')])[2]")).click();
		String Homepage2 = driver.getTitle();
		if (Homepage1.equalsIgnoreCase(Homepage2)) {
			System.out.println("Both homepage links navigating to the page");
		}
		
		//5.How many links are available in this page?
		int NoofLinks = driver.findElements(By.tagName("a")).size();
		System.out.println("Number of Hyperlinks:" + NoofLinks);
		driver.close();

	}

}
