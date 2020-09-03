package JobBoard.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Pactivity_14 {
	
	WebDriver driver;
	
  @Test
  @Parameters({"adminusername", "password", "username", "email", "firstname", "lastname", "url", "search"})
  public void newUser(String adminusername, String password, String username, String email, String firstname, String lastname, String url, String search) {
	  
      driver.findElement(By.id("user_login")).sendKeys(adminusername);
	  
	  driver.findElement(By.id("user_pass")).sendKeys(password);
	  
	  driver.findElement(By.id("wp-submit")).click();
	
	 //users
	  driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[11]/a/div[3]")).click();
	  
	 //add new
	  driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[11]/ul/li[3]/a")).click();
	  
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	 //username
	 driver.findElement(By.id("user_login")).sendKeys(username);
	 
	 //email
	 driver.findElement(By.id("email")).sendKeys(email);
	 
	 //firstname
	 driver.findElement(By.id("first_name")).sendKeys(firstname);
	 
	 //lastname
	 driver.findElement(By.id("last_name")).sendKeys(lastname);
	 
	 //website
	 driver.findElement(By.id("url")).sendKeys(url);
	 
	 //add
	 driver.findElement(By.id("createusersub")).click();
	 
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	 //search
	 driver.findElement(By.id("user-search-input")).sendKeys(search);
	 
	 driver.findElement(By.id("search-submit")).click();
	 
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 
	 String usernames = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/form/table/tbody/tr/td[1]/strong/a")).getText();
	 
	 Assert.assertEquals(usernames, "MTD");
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
