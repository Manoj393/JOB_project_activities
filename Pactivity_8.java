package JobBoard.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Pactivity_8 {
	
	WebDriver driver;
	WebDriverWait wait;
	
  @Test
  public void backendLogin() {
	  
	  driver.findElement(By.id("user_login")).sendKeys("root");
	  
	  driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
	  
	  driver.findElement(By.id("wp-submit")).click();
	  
	  //wait = new WebDriverWait (driver, 20);
	  //wait.until(ExpectedConditions.urlToBe("https://alchemy.hguy.co/jobs/wp-admin"));
	  
	  String title = driver.getTitle();
	  System.out.println("The title is :" + title);
	  Assert.assertEquals(title, "Dashboard ‹ Alchemy Jobs — WordPress");
	  
  }
  
  @BeforeTest
  public void beforeTest() {
	  
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/jobs/wp-admin");
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.close();
  }

}
