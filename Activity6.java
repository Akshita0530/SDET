package Selenium_Live_Project_LMS;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Activity6 {
	public WebDriver driver;
	
	 @BeforeMethod
	  public void OpenURL() {
		 driver= new FirefoxDriver();
		 driver.get("https://alchemy.hguy.co/lms");  
	  }
  @Test
  public void Login() {
	  driver.findElement(By.linkText("My Account")).click();
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[2]/div[2]/div[2]/div[2]/div[2]/a")).click();
	  driver.findElement(By.id("user_login")).sendKeys("root");
	  driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
	  driver.findElement(By.id("wp-submit")).click();
	 boolean login= driver.findElement(By.xpath("/html/body/div[2]/div/ul[2]/li[2]/a")).isDisplayed();
	 if (login== true) {
		 System.out.println("The user is successfully logged in");
	 }
	 
	 else {
		 System.out.println("The user couldnot log in");
	 }
  }
 

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
