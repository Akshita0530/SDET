package Selenium_Live_Project_LMS;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Activity9 {
	
	public WebDriver driver;
	
	 @BeforeMethod
	  public void OpenURL() {
	  driver= new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/lms"); 
}
  @Test	  
	  public void CompleteCourse() {
	  
	   // Login to the application
	  driver.findElement(By.linkText("My Account")).click();
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[2]/div[2]/div[2]/div[2]/div[2]/a")).click();
	  driver.findElement(By.id("user_login")).sendKeys("root");
	  driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
	  driver.findElement(By.id("wp-submit")).click();	  
     
	  // Select the course
	  driver.findElement(By.linkText("All Courses")).click();
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[2]/div[2]/div/div/div/div[2]/article/div[2]/p[2]/a")).click();
	  String ExpectedTitle = "Email Marketing Strategies – Alchemy LMS";
	  String ActualTitle = driver.getTitle();
	  if (ExpectedTitle.equals(ActualTitle)) 
	  {
		  System.out.println ("The Title of the Page matches the expected");
	  }
	  
	  //Select the lesson
	  driver.findElement(By.linkText("Improving & Designing Marketing Emails")).click();
	  
	  // Mark the lesson complete if possible
	if (!driver.findElements(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[3]/div[2]/form/input[4]")).isEmpty())  {
		  driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[3]/div[2]/form/input[4]")).click();
	  }
	  else if (driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[3]/a")).isDisplayed()==true) {
		  driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[3]/a")).click();
		  System.out.println ("The lesson is already complete");
	  }
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
