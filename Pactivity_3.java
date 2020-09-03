package JobBoard.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Pactivity_3 {
	
	WebDriver driver;
	
  @Test
  public void headerImageTC() {
	  
	  WebElement img = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/header/div/img"));
	  String src = img.getAttribute("src");
	  
	  System.out.println("The url of the header image is :" + src);
	  
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
