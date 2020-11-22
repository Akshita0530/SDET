package Selenium_Live_Project_LMS;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Activity4 {
	public WebDriver driver;
	 @BeforeMethod
	  public void OpenURL() {
	  driver= new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/lms"); 

	  }

  @Test
  public void VerifyTitle() {
	  driver.findElement(By.xpath("html/body/div/div/div/div/main/article/div/section[4]/div[2]/div/div[2]/div/div/div/div[2]/article/div[2]/p[2]/a")).click();
	  String ExpectedTitle = "Email Marketing Strategies – Alchemy LMS";
	  String ActualTitle = driver.getTitle();
	  if (ExpectedTitle.equals(ActualTitle)) 
	  {
		  System.out.println ("The Title of the Page matches the expected");
		  driver.close();
	  }
	  else 
	  {
		  
		  System.out.println ("The Title of the Page does not match");  
	  }
  }
  
  
 
  @AfterMethod
  public void afterMethod() {
	
  }

}
