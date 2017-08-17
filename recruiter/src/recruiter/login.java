package recruiter;

import java.util.List;

//import org.apache.bcel.generic.Select;
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

public class login 
{
	public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","D:\\backup\\chromedriver.exe");
    	 driver = new ChromeDriver();
        driver.get("http://uat.techfetch.com");
        Thread.sleep(1000);

        driver.findElement(By.xpath(".//*[@id='ucHeaderCtrl_divRecruiter']/a")).click();

        driver.findElement(By.xpath(".//*[@id='emploginpop']")).click();

        driver.switchTo().defaultContent();
        driver.switchTo().frame("empcontentframe");

        driver.findElement(By.xpath(".//*[@id='txtemailid']")).sendKeys("trainee1@tiliconveli.com");

        driver.findElement(By.xpath(".//*[@id='txtpwd']")).sendKeys("TV@123");

        driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        
      
        driver.findElement(By.cssSelector("#LeftMenu10 > div.divLeftMenuTemplate.rc7 > img")).click();
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("Iframe2");
        
        
        
        
       /* String[] months = new String[] { "Jan", "Feb", "Mar","Apr","May","jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

        for (int i = 0; i < months.length; i++)
        {
        	driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/thead/tr[2]/td[2]/div/input")).0.sendKeys(months[i]);
        	Thread.sleep(5000);
        	driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/thead/tr[2]/td[2]/div/input")).clear();
        	
            System.out.println(months[i]);
        }

        String[] jobtitle = new String[] { "Java Developer", "c++", "QA Analyst","oracle Developer","ASP.Net" };

        for (int i = 0; i < jobtitle.length; i++)
        {
        	driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/thead/tr[2]/td[3]/div/input")).sendKeys(jobtitle[i]);
        	Thread.sleep(5000);
        	driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/thead/tr[2]/td[3]/div/input")).clear();
        	
            //System.out.println(months[i]);
        }
        */
       
        driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/thead/tr[2]/td[2]/div/input")).sendKeys("Dec");
        driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/thead/tr[2]/td[3]/div/input")).sendKeys("ASP.Net");
        driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/thead/tr[2]/td[4]/div/input")).sendKeys(" Bradfordsville, KY");
        
        Thread.sleep(3000);
        
        driver.findElement(By.xpath(".//*[@id='previewjob32684']/img")).click();
        String window1 = driver.getWindowHandle();
        System.out.println(window1);

        Set<String> windows =driver.getWindowHandles();
        Iterator iterator = windows.iterator();
        String x;
        while(iterator.hasNext())
        {
        x = iterator.next().toString(); 

        System.out.println(x);

        //for(String x:windows){
        if(x.equals(window1)==false)
        {
        driver.switchTo().window(x); 
        Thread.sleep(5000);
        
        driver.findElement(By.xpath(".//*[@id='quickapply']")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("applyemailframe");
        Thread.sleep(5000);
        new Select(driver.findElement(By.id("lstResume"))).selectByVisibleText("Doles Pierre (Pierre) [Active]");
        driver.findElement(By.cssSelector("option[value=\"DP5637_7\"]")).click();
        driver.findElement(By.id("txtCC")).clear();
        driver.findElement(By.id("txtCC")).sendKeys("training2@tiliconveli.com");
        driver.findElement(By.id("chkCL")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("fileCL")).clear();
       // driver.findElement(By.xpath(".//*[@id='uploaddiv']/div/div/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("fileCL")).clear();
        driver.findElement(By.id("fileCL")).sendKeys("C:\\Users\\mag8\\Desktop\\res.docx");

       // driver.findElement(By.id("uploadvalue2")).sendKeys("C:\\Users\\mag8\\Desktop\\res.docx");
        driver.findElement(By.id("btnsendmail")).click();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("applyemailframe");
        driver.findElement(By.xpath(".//*[@id='btnClose1']")).click();
       
        //FORWARD
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.switchTo().window(x); 
        driver.findElement(By.xpath(".//*[@id='forwardjob']")).click();
        
        
        driver.switchTo().defaultContent();
        driver.switchTo().frame("jsfwdjobcontentframe");
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//*[@id='txtTo']")).sendKeys("training2@tiliconveli.com");
        Thread.sleep(20000);
        driver.findElement(By.xpath(".//*[@id='btnSend']")).click();
        Thread.sleep(4000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("jsfwdjobcontentframe");
        driver.findElement(By.xpath(".//*[@id='btnClose2']")).click();
        }
        }
        Thread.sleep(2000);
        driver.switchTo().window(window1);
        driver.findElement(By.cssSelector("#LeftMenu10 > div.divLeftMenuTemplate.rc7 > img")).click();
        Thread.sleep(4000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("Iframe2");
        
        driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/thead/tr[2]/td[2]/div/input")).clear();
        driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/thead/tr[2]/td[3]/div/input")).clear();
        driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/thead/tr[2]/td[4]/div/input")).clear();
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/thead/tr[2]/td[2]/div/input")).sendKeys("Aug");
        driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/thead/tr[2]/td[3]/div/input")).sendKeys("c++");
        driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/thead/tr[2]/td[4]/div/input")).sendKeys(" Calabasas, CA");
        driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/tbody/tr[2]/td[9]/a/img")).click();
        Thread.sleep(3000);
        
        driver.switchTo().defaultContent();
        driver.switchTo().frame("forwardjobframe") ;  
        Thread.sleep(5000);
         driver.findElement(By.cssSelector("#txtTo")).sendKeys("training2@tiliconveli.com");
         Thread.sleep(20000);
        //driver.findElement(By.xpath(".//*[@id='txtcode']")).sendKeys("");
        driver.findElement(By.xpath(".//*[@id='btnSend']")).click();
        Thread.sleep(3000);
        driver.close();
    }

	}
    
