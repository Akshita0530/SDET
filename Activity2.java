package Selenium_Live_Project_LMS;

import org.testng.annotations.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;


public class Activity2 {
	
	 public WebDriver driver;
	
	 @BeforeMethod
	  public void OpenURL() {
	  driver= new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/lms"); 
   }
     @Test
     public void VerifyHeading() {
     
      String ExpectedHeading = "Learn from Industry Experts";
   	  String ActualHeading = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[1]/div[2]/section/div[2]/div[2]/div[2]/div/div/div/div/div[1]")).getAttribute("innerHTML");
   	 if (ActualHeading.contains(ExpectedHeading)) {
   		
   	  System.out.println("The heading is verified");
   	  driver.close();
   	 }


     }
}



