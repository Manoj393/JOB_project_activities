package JobBoard.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Pactivity_9 {
	
	WebDriver driver;
	WebDriverWait wait;
	
  @Test
  public void backendJobCreation() {
	  
      driver.findElement(By.id("user_login")).sendKeys("root");
	  
	  driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
	  
	  driver.findElement(By.id("wp-submit")).click();
	  
	  //job listings
	  driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[7]/a/div[3]")).click();
	  
	  
	  //add new job
	  driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[7]/ul/li[3]/a")).click();
	  
	  //wait = new WebDriverWait(driver,20);
	  //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"post-title-0\"]")));
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  
	  //Position
	  driver.findElement(By.id("post-title-0")).sendKeys("Test AUtomation Engineer Admin");
	  
	  //website
	  driver.findElement(By.id("_company_website")).sendKeys("www.IBM.com");
	  
	  //twitter
	  driver.findElement(By.id("_company_twitter")).sendKeys("TEST");
	  
	  //location
	  driver.findElement(By.id("_job_location")).sendKeys("LONDON");
	  
	  //Name
	  driver.findElement(By.id("_company_name")).sendKeys("IBM");
	  
	  //Tagline
	  driver.findElement(By.id("_company_tagline")).sendKeys("IBM");
	  
	  //video
	  driver.findElement(By.id("_company_video")).sendKeys("www.video.com");
	  
	  //publish
	  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[1]/div/div[2]/button[2]")).click();
	  
	  //publish
	  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[1]/div/button")).click();

	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  
	  //job view
	  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div[2]/a")).click();
	  
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  
	  String title = driver.findElement(By.className("entry-title")).getText();
	  
	  Assert.assertEquals(title, "Test AUtomation Engineer Admin");
  }
  
  @BeforeClass
  public void beforeClass() {
	  
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/jobs/wp-admin");
  }

  @AfterClass
  public void afterClass() {
	  
	 driver.close(); 
  }

}
