
package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NSEQA2 {

       public static void main(String[] args) {

              System.setProperty("webdriver.chrome.driver", "D:/Selenium/Chrome/chromedriver.exe"); 
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://gw-qa2.verizonwireless.com/store/smartphones/");
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.findElement(By.xpath("//img[@alt='V20']")).click();
        
        driver.findElement(By.xpath("(//i[@class='fa fa-check'])[1]")).click();
        
        driver.findElement(By.xpath("//button[@id='myBtn']")).click();
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        driver.findElement(By.xpath("//input[@id='pdpZipModalInput']")).sendKeys("10038");
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        driver.findElement(By.xpath("//button[@id='btnconfirmlocation']")).click();
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        driver.findElement(By.xpath("//button[@id='popbtncustomize']")).click();
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        driver.findElement(By.xpath("//button[text()='Continue']")).click();
        
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        
        /*Actions act = new Actions (driver);
        act.moveToElement(driver.findElement(By.xpath("//label[@for='rdoProtectionCoach0ci588000109']"))).click().build().perform();
        */       
        //driver.findElement(By.xpath("//label[@for='rdoProtectionCoach0ci588000109']")).click();
        
        
        driver.findElement(By.xpath("(.//*[contains(text(),' Total Mobile Protection ')])[2]")).click();
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        driver.findElement(By.xpath("(//button[@class='r-btn r-btn-next continue-Btn'])[1]")).click();
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        driver.findElement(By.xpath("(//a[@class='btn r-btn btn-custom continue-btn'])[1]")).click();
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        driver.findElement(By.xpath("//span[text()='check out'][1]")).click();
        
       }
        
        }
