package Selenium_TestNG_xml_Activities;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Activity2 {
	WebDriver driver;
	WebDriverWait wait;
	
	@DataProvider(name = "Authentication")
    public static Object[][] credentials() {
    return new Object[][] { { "admin", "password" }};
	}
  @Test (dataProvider = "Authentication")
  public void loginTestCase(String username, String password) {
      //Find username and pasword fields
      WebElement usernameField = driver.findElement(By.id("username"));
      WebElement passwordField = driver.findElement(By.id("password"));
      
      //Enter values
      usernameField.sendKeys(username);
      passwordField.sendKeys(password);
      
      //Click Log in
      driver.findElement(By.cssSelector("button[type='submit']")).click();
      
      //Assert Message
      String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
      Assert.assertEquals(loginMessage, "Welcome Back, admin");
 
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	        driver = new FirefoxDriver();
	        wait = new WebDriverWait(driver, 10);
	        
	        //Open browser
	        driver.get("https://www.training-support.net/selenium/login-form");
  }

  @AfterMethod
  public void afterMethod() {
	//Close browser
      driver.close();
  }

}