package Selenium_Live_Project_LMS;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class Activity1 {
		 public WebDriver driver;
		 
		 @BeforeMethod
		  public void OpenURL() {
		  driver= new FirefoxDriver();
		  driver.get("https://alchemy.hguy.co/lms"); 
	  }

  @Test
  public void TitleVerification() {
	  String ExpectedTitle = "Alchemy LMS – An LMS Application";
	  String ActualTitle = driver.getTitle();
	  if (ExpectedTitle.equals(ActualTitle)) {
		  System.out.println("The application is launched successfully");
		  driver.close();
	  }
	  
	  else {
		  System.out.println("The application was not launched");  
	  }
  }
 
}
