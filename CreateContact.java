package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		
		//Launching the chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launching URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// 2. Enter UserName and Password Using Id Locator
		driver.findElement(By.xpath("//input[@name='USERNAME']")).sendKeys("demosalesmanager");
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
		
		// 3. Click on Login Button using Class Locator
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		 // 4. Click on CRM/SFA Link
		driver.findElement(By.xpath("//a[contains(text(),'CRM/')]")).click();
		
		 // 5. Click on Create Contact
		  driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		  
		 // 6. Click on contacts Button
		driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
				
		 // 7. Enter FirstName Field Using id Locator
		 driver.findElement(By.id("firstNameField")).sendKeys("Vaishnavi");
		 
		 // 8. Enter LastName Field Using id Locator
		 driver.findElement(By.id("lastNameField")).sendKeys("Keerthana");
		 
		 // 9. Enter FirstName(Local) Field Using id Locator
		 driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Vaisnavi");
		  
		 // 10. Enter LastName(Local) Field Using id Locator
		 driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Keerthana");
		 
		 // 11. Enter Department Field Using any Locator of Your Choice
		 driver.findElement(By.id("lastNameField")).sendKeys("Keerthana");
		  
		 // 12. Enter Description Field Using any Locator of your choice 
		 WebElement description=driver.findElement(By.id("createContactForm_description"));
		 description.sendKeys("Contact if you have any clarificatoion regarding contact");
		 
		 // 13. Enter your email in the E-mail address Field using the locator of your choice
		   driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("Keerthana@gmail.com");
		   
		 // 14. Select State/Province as NewYork Using Visible Text
		   WebElement selstate=driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		   Select sel=new Select(selstate);
		   sel.selectByVisibleText("New York");
		   
		 // 15. Click on Create Contact
		   driver.findElement(By.xpath("//input[@name='submitButton']")).click();

		 // 16. Click on edit button 
		   driver.findElement(By.xpath("//a[text()='Edit']")).click();
		 
		 // 17. Clear the Description Field using .clear
		   WebElement viewdescription=driver.findElement(By.id("updateContactForm_description"));
		   viewdescription.getText();
		   viewdescription.clear();
		   
		 // 18. Fill ImportantNote Field with Any text
		   driver.findElement(By.id("updateContactForm_importantNote")).click();
		
		 // 19. Click on update button using Xpath locator
		   driver.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();
		   
		 // 20. Get the Title of Resulting Page.
		   String Resultingpage=driver.getTitle();
		   System.out.println("Title of the resultpage:"+Resultingpage);
	}

}
