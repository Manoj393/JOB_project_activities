package JobBoard.testng;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class Pactivity_1 {
	
	WebDriver driver;
	
  @BeforeClass
	    public void beforeClass() {
	        driver = new FirefoxDriver();
	        
	  	  driver.get("https://alchemy.hguy.co/jobs");
	    }

  @Test
  public void titleTC() {
	  
	  
	  String title = driver.getTitle();
	  System.out.println("The tilte of the page is :" + title);
	  
	  Assert.assertEquals(title, "Alchemy Jobs – Job Board Application");
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.close();
  }

}
