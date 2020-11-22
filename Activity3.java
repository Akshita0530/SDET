package Selenium_Live_Project_LMS;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class Activity3 {
  
	public WebDriver driver;
	
	 @BeforeMethod
	  public void OpenURL() {
	  driver= new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/lms"); 
  }
  @Test
  public void VerifyFirstInfoBox() {
	  
	  String ExpectedHeading = " Actionable Training ";
   	  String ActualHeading = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[2]/div[2]/div[1]/div[2]/div/div/div/div/div[2]/h3")).getAttribute("innerHTML");
   	  if (ActualHeading.equals(ExpectedHeading)) {
   	
   		 System.out.println("The Info Box Title is verified");
   	     driver.close();
   	     
   	 }
  }
 
}
