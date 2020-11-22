package Selenium_Live_Project_LMS;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Activity8 {
	 public WebDriver driver;
	 
	 @BeforeMethod
	  public void OpenURL() {
	  driver= new FirefoxDriver();
	  
	  driver.get("https://alchemy.hguy.co/lms");
	  
	 }
	 
  @Test
  public void ContactSite() {
	  driver.findElement(By.linkText("Contact")).click();
	  driver.findElement(By.id("wpforms-8-field_0")).sendKeys("Tom Harrison");
	  driver.findElement(By.id("wpforms-8-field_1")).sendKeys("abcd@gmail.com");
	  driver.findElement(By.id("wpforms-8-field_3")).sendKeys("Query for Course");
	  driver.findElement(By.id("wpforms-8-field_2")).sendKeys("I have query regarding a course.");
	  driver.findElement(By.id("wpforms-submit-8")).click();
	  String Message = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/section[4]/div[2]/div[2]/div[2]/div[2]/p")).getAttribute("innerHTML");
	  
	  System.out.println("The message displayed is :"+ Message);
  }
  
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
