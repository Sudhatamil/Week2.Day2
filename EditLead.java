package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {
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
				
			//	8.Enter first name
				driver.findElement(By.xpath("//input[@name='id']/following::input[@name='firstName']")).sendKeys("tamil");
				//9	Click Find leads button
				driver.findElement(By.xpath("//button[contains(text(),'Find')]")).click();
				//10 Click on first resulting lead
				driver.findElement(By.xpath("(//a[contains(text(),'13273')])[1]")).click();
				//11 Verify title of the page
				String title=driver.getTitle();
				String expected="View Lead | opentaps CRM";
				if(title.equalsIgnoreCase(expected))
					System.out.println("Expected Title is displayed");
				//12 Click Edit
				driver.findElement(By.xpath("//a[contains(text(),'Qualify')]/following-sibling::a[contains(text(),'Edit')]")).click();
				//13 Change the company name
				WebElement ucompany=driver.findElement(By.xpath("//span[contains(text(),'Parent Account')]/preceding::input[contains(@id,'_companyName')]"));
				ucompany.clear();
				ucompany.sendKeys("Keerthana");
				//14 Click Update
				driver.findElement(By.xpath("//input[@value='Update']")).click();
				
				//15 Confirm the changed name appears
				WebElement cname=driver.findElement(By.xpath("//span[contains(@id,'_companyName')]"));
				String ucname=cname.getText();
				
				if(ucname.contains("hana"))
					System.out.println("Name is updated properly");
				//16 Close the browser (Do not log out)

	}

}
