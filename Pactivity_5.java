package JobBoard.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Pactivity_5 {
	
	WebDriver driver;
	WebDriverWait wait;
	
  @Test
  public void jobspage() {
	  
	  driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a")).click();
	  
      String title = driver.getTitle();
      System.out.println("The Title of the page is :" + title);
      
      Assert.assertEquals(title, "Jobs – Alchemy Jobs");
	  
  }
  
  @BeforeClass
  public void beforeClass() {
	  
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/jobs");
  }

  @AfterClass
  public void afterClass() {
	  
	  driver.close();
  }

}
