package JobBoard.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Pactivity_15{
	
	WebDriver driver;

	 @BeforeClass public void beforeMethod() {
		 
	   	driver = new FirefoxDriver();
	   	
         driver.get("https://alchemy.hguy.co/jobs");
         
         Reporter.log("Landed on to home page");
	}   
	 
     @Test
     public void Reports() throws InterruptedException {
    	 
	driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a")).click();
	
	Thread.sleep(500);
	
	 Reporter.log("clicked on jobs");
	 
	String heading = driver.getTitle();
	
	System.out.println("The heading URL is :"+heading);  
	Thread.sleep(100);
	
	driver.findElement(By.cssSelector("#search_keywords")).sendKeys("Test automation");
	
	 Reporter.log("Input provided");
	 Thread.sleep(500);
	
	driver.findElement(By.cssSelector(".search_submit > input:nth-child(1)")).click();
	
	Reporter.log("clicked on search");
	Thread.sleep(500);
	
	driver.findElement(By.xpath("(//div[@class='position'])[7]")).click();
	
	Reporter.log("found the element");
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//div[@class='job_application application']")).click();
	
	 Reporter.log("apply button clicked");
	 
	 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	String Email = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/div/div[3]/div/p/a")).getText();
	
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	 Reporter.log("found email");
	System.out.println("The Email id is:" +Email);  
	
	  
     }
		
		 @AfterClass 
		 public void afterMethod(){
			 driver.close();
			 
		 
	}
		 
 }