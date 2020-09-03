package JobBoard.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Pactivity_4 {
	
	WebDriver driver;
	
  @Test
  public void Secondheading() {
	  
	  String secondheading = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/h2")).getText();
	  System.out.println("The second heading title is : " + secondheading );
	  
	  Assert.assertEquals(secondheading, "Quia quis non");
	  
	  
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
