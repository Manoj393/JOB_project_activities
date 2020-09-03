package JobBoard.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Pactivity_6 {
	
	WebDriver driver;
	WebDriverWait wait;
	
  @Test
  public void jobSearch() {
	  
	  driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a")).click();
	  
	  WebElement search = driver.findElement(By.name("search_keywords"));
	  search.sendKeys("tEST aUTOMATION eNGINEER");
	  
	  driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/form/div[1]/div[4]/input")).click();
	  
	  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	  
	  
	  driver.findElement(By.xpath("(//div[@class='position'])[1]")).click();
	  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//input[@class='application_button button' and @type='button' and @value='Apply for job']")).click();
	  
	  
	  String email = driver.findElement(By.className("application_details")).getText();
	  
	  System.out.println("Email is : " + email);
	  
	  
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
