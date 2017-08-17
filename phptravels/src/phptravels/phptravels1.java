package phptravels;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.Iterator;
import java.util.Set;

public class phptravels1 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\backup\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.phptravels.net/");
		Thread.sleep(1000);

		driver.findElement(By.xpath("html/body/div[4]/div[2]/div/ul/li[1]/a")).click(); // hotel

		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".select2-chosen")).click(); // location
		// driver.findElement(By.cssSelector("a.text-center")).click();
		Thread.sleep(1000);

		driver.findElement(By.cssSelector(".select2-input.select2-focused")).sendKeys("Oas");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='select2-drop']/ul/li[1]/ul/li/div")).click();

		Thread.sleep(000);

		// checkin & checkout
		
		String ExpMonth = "November 2017";
		driver.findElement(By.xpath("html/body/div[13]/div[1]/table/thead/tr[1]/th[3]")).click();
		String CurrMonth=driver.findElement(By.xpath("html/body/div[13]/div[1]/table/thead/tr[1]/th[2]")).getText();
		if (ExpMonth.equals(CurrMonth)) {
		System.out.println("Already Selected");
		}
		else {
		for(int i=1;i<12;i++) {
		driver.findElement(By.xpath("html/body/div[13]/div[1]/table/thead/tr[1]/th[3]")).click();
		Thread.sleep(2000);
		CurrMonth=driver.findElement(By.xpath("html/body/div[13]/div[1]/table/thead/tr[1]/th[2]")).getText();
		if (ExpMonth.equals(CurrMonth)) {
		System.out.println("Month Selected");
		break;
		}
		}
		}
		Thread.sleep(2000);
		WebElement datepicker = driver.findElement(By.xpath("html/body/div[13]/div[1]/table/tbody/tr[3]/td[3]"));
		datepicker.click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".form.input-lg.dpd2")).clear();
		Thread.sleep(2000);
		String ExpsMonth = "December 2017";
		driver.findElement(By.xpath("html/body/div[14]/div[1]/table/thead/tr[1]/th[3]")).click();
		String CurrsMonth=driver.findElement(By.xpath("html/body/div[14]/div[1]/table/thead/tr[1]/th[2]")).getText();
		if (ExpsMonth.equals(CurrsMonth)) {
		System.out.println("Already Selected");
		}
		else {
		for(int i=1;i<12;i++) {
		driver.findElement(By.xpath("html/body/div[14]/div[1]/table/thead/tr[1]/th[3]")).click();
		Thread.sleep(2000);
		CurrsMonth=driver.findElement(By.xpath("html/body/div[14]/div[1]/table/thead/tr[1]/th[2]")).getText();
		if (ExpsMonth.equals(CurrsMonth)) {
		System.out.println("Month Selected");
		break;
		}
		}
		}
		Thread.sleep(2000);
		WebElement datepicker1 = driver.findElement(By.xpath("html/body/div[14]/div[1]/table/tbody/tr[3]/td[5]"));
		datepicker1.click();
		Thread.sleep(3000);

		/*driver.findElement(By.name("checkin")).click();
		driver.findElement(By.xpath("html/body/div[13]/div[1]/table/tbody/tr[5]/td[5]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/div[14]/div[1]/table/tbody/tr[5]/td[7]")).click();*/
		
		    /*driver.findElement(By.name("checkin")).click();
		    driver.findElement(By.cssSelector("th.prev")).click();
		    Thread.sleep(9000);
		    driver.findElement(By.cssSelector("th.next")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//div[@id='sizzle1502878865344']/div/table/tbody/tr[3]/td[5]")).click();
		    Thread.sleep(9000);
		    driver.findElement(By.cssSelector("#sizzle1502878865344 > div.datepicker-days > table..table-condensed > thead > tr > th.next")).click();
		    driver.findElement(By.xpath("//div[@id='sizzle1502878865344']/div/table/tbody/tr[4]/td[6]")).click();*/


		// Adult &Child
		driver.findElement(By.id("adults")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("option[value=\"2\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("child")).click();
		Thread.sleep(3000);
		// new Select(driver.findElement(By.id("child"))).selectByVisibleText("1");
		driver.findElement(By.xpath("//select[@id='child']/option[2]")).click();
		Thread.sleep(1000);

		// Search
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		
		for (int x = 0; x < 5; x++)

		{
			driver.findElement(By.xpath(".//*[@id='OVERVIEW']/div/div[2]/div[1]/div[3]/div[2]/div/div[1]/div[3]")).click();

			Thread.sleep(1000);

		}

	}

}