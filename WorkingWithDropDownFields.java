package Week2.Day2;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithDropDownFields {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// select by index dropdown1
		WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='dropdown1']"));
		Select sel1 = new Select(dropdown1);
		sel1.selectByIndex(3);

		// select by text dropdown2
		WebElement dropdown2 = driver.findElement(By.xpath("//select[@name='dropdown2']"));
		Select sel2 = new Select(dropdown2);
		sel2.selectByVisibleText("Selenium");

		// select by value dropdown3
		WebElement dropdown3 = driver.findElement(By.xpath("//select[@id='dropdown3']"));
		Select sel3 = new Select(dropdown3);
		sel3.selectByValue("2");

		// get list of options dropdown4
		WebElement el = driver.findElement(By.xpath("//select[@class='dropdown']"));
		Select sel = new Select(el);
		int listofoptions = sel.getOptions().size();
		System.out.println("listof options:" + listofoptions);
		List<WebElement> lis = sel.getOptions();
		for (int i = 1; i < lis.size(); i++) {
			System.out.println(lis.get(i).getText());
		}

		// select by using sendkeys dropdown5
		WebElement dropdown5 = driver.findElement(By.xpath("(//section[@class='innerblock']//select)[5]"));
		dropdown5.sendKeys("Selenium");

		// select your multiple programs at a time
		int cnt = 0;
		List<WebElement> lbox = driver.findElements(By.xpath("(//div/select)[6]/option"));
		for (WebElement res : lbox) {
			cnt++;
			if (cnt > 1)
				res.click();
		}

		driver.quit();
	}

	
}
