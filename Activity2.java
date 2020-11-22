package Selenium_TestNG_Activities;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;

public class Activity2 {
	WebDriver driver;
  @Test
  public void testCase1() {
	    //This test case will pass
      String title = driver.getTitle();
      System.out.println("Title is: " + title);
      Assert.assertEquals(title, "Target Practice");
  }
  
  @Test
  public void testCase2() {
      //This test case will Fail
      WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
      Assert.assertTrue(blackButton.isDisplayed());
      Assert.assertEquals(blackButton.getText(), "black");
  }
  
  @Test(enabled = false)
  public void testCase3() {
      //This test will be skipped and not counted
      String subHeading = driver.findElement(By.className("sub")).getText();
      Assert.assertTrue(subHeading.contains("Practice"));
  }
  
  @Test
  public void testCase4() {
      //This test will be skipped and will be be shown as skipped
      throw new SkipException("Skipping test case");      
  }
  @BeforeMethod
  public void beforeMethod() {
	  //Create a new instance of the Firefox driver
      driver = new FirefoxDriver();
          
      //Open the browser
      driver.get("https://www.training-support.net/selenium/target-practice");
  }

  @AfterMethod
  public void afterMethod() {
	//Close the browser
      driver.close();
  }

}
