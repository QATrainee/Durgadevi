package recruiter;

import java.util.List;
import java.util.Properties;

//import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class login 
{
	static WebDriver d;

	protected static WebElement xp(String xpath) 
	{

		return d.findElement(By.xpath(xpath));
	}

	protected static WebElement id(String id) 
	{

		return d.findElement(By.id(id));
	}

	protected static WebElement css(String cssSelector)
    {

		return d.findElement(By.cssSelector(cssSelector));
	}

	public static void main(String[] args) throws InterruptedException, Exception 
	{

		String workingdir;
		workingdir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", workingdir + "\\resource\\chromedriver.exe");
		d = new ChromeDriver();
		File file = new File(workingdir + "\\resource\\job.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		d.get("http://uat.techfetch.com");
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		d.findElement(By.xpath(".//*[@id='ucHeaderCtrl_divRecruiter']/a")).click();

		d.findElement(By.xpath(".//*[@id='emploginpop']")).click();

		d.switchTo().defaultContent();
		d.switchTo().frame("empcontentframe");

		d.findElement(By.xpath(".//*[@id='txtemailid']")).sendKeys("trainee1@tiliconveli.com");

		d.findElement(By.xpath(".//*[@id='txtpwd']")).sendKeys("TV@123");

		d.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		
		
		// @author:DURGADEVI
		//preview
		
		d.switchTo().defaultContent();
		css(prop.getProperty("jobmenu")).click();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe2");
		xp(prop.getProperty("updateddate")).sendKeys(prop.getProperty("month"));
		xp(prop.getProperty("jobtitle")).sendKeys(prop.getProperty("lang"));
		xp(prop.getProperty("location")).sendKeys(prop.getProperty("cty4"));
		//d.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
Thread.sleep(1000);
		xp(prop.getProperty("preview")).click();
		Thread.sleep(1000);
		String window1 = d.getWindowHandle();
		System.out.println(window1);

		Set<String> windows = d.getWindowHandles();
		Iterator iterator = windows.iterator();
		String x;
		while (iterator.hasNext()) {
			x = iterator.next().toString();

			//System.out.println(x);

			// for(String x:windows){
			if (x.equals(window1) == false) {
				d.switchTo().window(x);
				d.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
				System.out.println(x);
				xp(prop.getProperty("applynow")).click();
				d.switchTo().defaultContent();
				d.switchTo().frame("applyemailframe");
				d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				new Select(d.findElement(By.id(prop.getProperty("selectfromprofile")))).selectByVisibleText("Doles Pierre (Pierre) [Active]");
				css(prop.getProperty("optionvalue")).click();
				id(prop.getProperty("cc")).clear();
				id(prop.getProperty("cc")).sendKeys(prop.getProperty("tooo"));
				id(prop.getProperty("coveringletter")).click();
				d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				id(prop.getProperty("fileupload")).clear();
				// d.findElement(By.xpath(".//*[@id='uploaddiv']/div/div/div")).click();
				d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				id(prop.getProperty("fileupload")).clear();
				id(prop.getProperty("fileupload")).sendKeys(prop.getProperty("path8"));

				// d.findElement(By.id("uploadvalue2")).sendKeys("C:\\Users\\mag8\\Desktop\\res.docx");
				id(prop.getProperty("sendemail")).click();
				d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				d.switchTo().defaultContent();
				d.switchTo().frame("applyemailframe");
				xp(prop.getProperty("btnclose")).click();

				// forward
				Thread.sleep(5000);
				d.switchTo().defaultContent();
				d.switchTo().window(x);
				xp(prop.getProperty("forwardjob")).click();

				d.switchTo().defaultContent();
				d.switchTo().frame("jsfwdjobcontentframe");
				d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				xp(prop.getProperty("toaddr")).sendKeys(prop.getProperty("tooo"));
				Thread.sleep(3000);
				xp(prop.getProperty("crossbtn1")).click();
				d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				d.switchTo().defaultContent();
				d.switchTo().frame("jsfwdjobcontentframe");
				xp(prop.getProperty("closebtn")).click();
				
				d.switchTo().window(x);
				d.close();
			}
		}
		
		
		//FORWARD
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		d.switchTo().window(window1);
		css(prop.getProperty("jobmenu")).click();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe2");

		xp(prop.getProperty("updateddate")).clear();
		xp(prop.getProperty("jobtitle")).clear();
		xp(prop.getProperty("location")).clear();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		xp(prop.getProperty("updateddate")).sendKeys(prop.getProperty("month8"));
		xp(prop.getProperty("jobtitle")).sendKeys(prop.getProperty("lang8"));
		xp(prop.getProperty("location")).sendKeys(prop.getProperty("cty8"));
		xp(prop.getProperty("fwd")).click();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		d.switchTo().frame(d.findElement(By.xpath(prop.getProperty("forwardmain"))));
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		xp(prop.getProperty("toaddr")).sendKeys(prop.getProperty("tooo"));
		Thread.sleep(1000);
		xp(prop.getProperty("crossbtn")).click();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		xp(prop.getProperty("closebtn")).click();
		d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// EDIT

		// @author surya Balapriya work name : edit
		
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe2");
		xp(prop.getProperty("updateddate")).clear();
		xp(prop.getProperty("jobtitle")).clear();
		xp(prop.getProperty("location")).clear();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		xp(prop.getProperty("edit")).click();
		d.switchTo().defaultContent();
		d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		d.switchTo().frame("Iframe3");

		id(prop.getProperty("jobtitle5")).clear();
		id(prop.getProperty("jobtitle5")).sendKeys(prop.getProperty("Title"));
		Thread.sleep(1000);
		id(prop.getProperty("skillreq")).clear();
		id(prop.getProperty("skillreq")).sendKeys(prop.getProperty("Title"));
		id(prop.getProperty("exlevel")).click();
		id(prop.getProperty("exlevel1")).click();
		id(prop.getProperty("exlevel2")).click();
		id(prop.getProperty("exlevel3")).click();
		id(prop.getProperty("exlevel4")).click();
		d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		xp(prop.getProperty("permanenttype")).click();

		id(prop.getProperty("Work1")).click();
		Thread.sleep(1000);
		id(prop.getProperty("PreferredEmployment5")).click();
		Thread.sleep(1000);
		new Select(id(prop.getProperty("splarea1"))).selectByVisibleText("Java, J2EE");
		new Select(id(prop.getProperty("splskill1"))).selectByVisibleText("Java, J2EE");
		id(prop.getProperty("domainlist0")).click();
		id(prop.getProperty("domainlist2")).click();
		id(prop.getProperty("preview1")).click();
		Thread.sleep(3000);
		d.findElement(By.linkText("closebutton")).click();
		Thread.sleep(3000);
		id(prop.getProperty("updatebutton")).click();
		Thread.sleep(3000);
		d.findElement(By.linkText("closebutton")).click();
		d.close();

	}

}
