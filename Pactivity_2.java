package JobBoard.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Pactivity_2 {
	
	WebDriver driver;
	
  @Test
  public void headingTC() {
	  
	  String heading = driver.findElement(By.className("entry-title")).getText();
	  System.out.println("The header of the page is : " + heading);
	  
	  Assert.assertEquals(heading, "Welcome to Alchemy Jobs");
	  
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
