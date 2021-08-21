package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		
		//Launching the chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launching URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// 2. Enter UserName Using Id Locator
		driver.findElement(By.xpath("//input[@name='USERNAME']")).sendKeys("demosalesmanager");
		
		// 3. Enter Password Using Id Locator
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
		
		// 4. Click on Login Button using Class Locator
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		 // 5. Click on CRM/SFA Link
		driver.findElement(By.xpath("//a[contains(text(),'CRM/')]")).click();
		
		//6.click Leads link
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		
		//7.Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		//8.Click on Phone
		driver.findElement(By.linkText("Phone")).click();
		
		//9.Enter phone number
	
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("6374905651");
		
		//10.Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		
		//11.Capture lead ID of First Resulting lead
		WebElement cpatureId=driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])/a[1]"));
		String capture=cpatureId.getText();
		System.out.println("Capture lead ID of First Resulting lead:"+capture);
				
		//12.Click First Resulting lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])/a[1]")).click();
	
		//13.Click Delete
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
		
		//14.Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
	
		//15.Enter captured lead ID
		driver.findElement(By.name("id")).sendKeys(capture);
		
		//16.Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		//17.Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		boolean verify=driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed();
		if(verify)
			System.out.println("sucessfully deleted");
		else
			System.out.println("not deleted");
		//18.Close the browser (Do not log out)
		driver.close();

	}

}
