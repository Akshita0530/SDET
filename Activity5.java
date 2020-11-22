package Selenium_Live_Project_LMS;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class Activity5 {
  
	public WebDriver driver;
	 
	 @BeforeMethod
	  public void OpenURL() {
	  driver= new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/lms"); 
 }
  
  @Test
  public void Navigation() {
	  
	  driver.findElement(By.linkText("My Account")).click();
	  String ActualTitle = driver.getTitle();
	  String ExpectedTitle = "My Account – Alchemy LMS";
	  if (ActualTitle.equals(ExpectedTitle)) {
	  
	  System.out.println("You have successfully navigated to My Account Page");
	  driver.close();
  }
  }

}
