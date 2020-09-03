package JobBoard.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Pactivity_11 {
	
	WebDriver driver;
	
  @Test
  public void applyJobs() {
	  
	  //jobs
	  driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a")).click();
	  
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  
	  //search
	  driver.findElement(By.id("search_keywords")).sendKeys("tEST aUTOMATION eNGINEER test");
	  
	  //click on search
      driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/form/div[1]/div[4]/input")).click();
	  
	  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	  
	  driver.findElement(By.className("freelance")).click();
	  driver.findElement(By.className("internship")).click();
	  driver.findElement(By.className("part-time")).click();
	  driver.findElement(By.className("temporary")).click();
	  
	  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	  
	  //select a job from the list
	  driver.findElement(By.xpath("(//div[@class='position'])[1]")).click();
	  
	  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	  
	  //get title
	  String title = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
	  System.out.println("the title is : " + title);
	  
	  //apply job
      driver.findElement(By.xpath("//input[@class='application_button button' and @type='button' and @value='Apply for job']")).click();
	  
      //get email text
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
