package excelproject1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class techfetchexc {
  @BeforeTest
  public void f()  
  {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\jdk1.8.0_131\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
  }
  @Test
  public static void login() throws  IOException, Exception{
      ChromeDriver driver = new ChromeDriver();
        FileInputStream fsIP= new FileInputStream(new File("D:\\workspace\\july12\\scad1.xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(fsIP);
        XSSFSheet worksheet = wb.getSheetAt(0);           
        Cell cell ;
        for (int i = 0; i<=3;i++) {
         driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
         driver.findElement(By.xpath("//.//*[@id='identifierId']")).sendKeys(worksheet.getRow(i).getCell(0).getStringCellValue());
         driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
         Thread.sleep(10000);
         driver.findElement(By.xpath("//.//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(worksheet.getRow(i).getCell(1).getStringCellValue());
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".RveJvd.snByac")).click();
        Thread.sleep(2000);
             try{
             WebElement web1 = driver.findElement(By.xpath("//.//*[@id='password']/div[2]/div[2]"));
             boolean a2 = web1.isDisplayed();
             if(a2 = true  ){
                 cell = worksheet.getRow(i).getCell(2);
                 cell.setCellValue("Login fail,,,");
                fsIP.close();
                FileOutputStream output_file1 =new FileOutputStream(new File("D:\\workspace\\july12\\scad1.xlsx"));  
                wb.write(output_file1);
                output_file1.close();
        }}
        catch (Exception e) {
        driver.findElement(By.cssSelector(".gb_8a.gbii")).click();
        driver.findElement(By.cssSelector("#gb_71")).click();
        cell = worksheet.getRow(i).getCell(2);
        cell.setCellValue("Login pass");
        fsIP.close();
        FileOutputStream output_file1 =new FileOutputStream(new File("D:\\workspace\\july12\\scad1.xlsx"));  
        wb.write(output_file1);
        output_file1.close();
        Thread.sleep(1000);
        }
        }
                 driver.quit();
}
}