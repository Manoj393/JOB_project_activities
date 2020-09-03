package JobBoard.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Pactivity_7 {
	
	WebDriver driver;
	
	
  @Test
  public void postJob() {
	  
	  driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[3]/a")).click();
	  
	  driver.findElement(By.id("create_account_email")).sendKeys("abcdtest6@gmail.com");
	  
	  driver.findElement(By.id("job_title")).sendKeys("test automation engineer test");
	  
	  driver.findElement(By.id("job_location")).sendKeys("LONDON");
	  
	  Select dropdown = new Select(driver.findElement(By.id("job_type")));
	  dropdown.selectByVisibleText("Freelance");
	  
	  driver.findElement(By.id("job_description_ifr")).sendKeys("Test");
	  
	  driver.findElement(By.id("application")).sendKeys("abcd@mail.com");
	  
	  driver.findElement(By.id("company_name")).sendKeys("IBM");
	  
	  driver.findElement(By.id("company_website")).sendKeys("www.IBM.com");
	  
	  driver.findElement(By.id("company_tagline")).sendKeys("IBM");
	  
	  driver.findElement(By.id("company_video")).sendKeys("www.test.com");
	  
	  driver.findElement(By.id("company_twitter")).sendKeys("test");
	  
	  driver.findElement(By.id("company_logo")).sendKeys("C:\\Users\\ManojkumarTD\\Pictures\\PC_Wallpaper_bee.png");
	  
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/form/p/input[4]")).click();
	  
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  
	  driver.findElement(By.id("job_preview_submit_button")).click();
	  
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  
	  driver.findElement(By.xpath("/html/body/div[2]/div/div/div/main/article/div/a")).click();
	  
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  
	  String title = driver.findElement(By.className("entry-title")).getText();
	  
	  Assert.assertEquals(title, "test automation engineer test");
	  
	  
  }
  
  @BeforeTest
  public void beforeTest() {
	  
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/jobs");
	  
  }

  @AfterTest
  public void afterTest() {
	  
	 driver.close();
	  
  }

}
