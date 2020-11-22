package Selenium_Live_Project_LMS;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebElement;

public class Activity7 {
	
	public WebDriver driver;
	
	 @BeforeMethod
	  public void OpenURL() {
	  driver= new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/lms"); 
}
  @Test
  public void CalculateCourseNumber() {
	 driver.findElement(By.linkText("All Courses")).click(); 
	 java.util.List<WebElement> Courses = driver.findElements(By.className("ld_course_grid_button"));
	 
	 int i= Courses.size();
	 
	 
	 	 System.out.println("The number of courses available are :" +i);
	 driver.close();
	 
	 
  }
 
}
