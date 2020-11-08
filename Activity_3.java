package Selenium_Session1;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Activity_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/simple-form");
        
      
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        
       
       driver.findElement(By.id("firstName")).sendKeys("Akshita");
       driver.findElement(By.id("lastName")).sendKeys("Kumari");
   
        //Enter the email
        driver.findElement(By.id("email")).sendKeys("selenium@test.com");
        
        //Enter the contact number
        driver.findElement(By.id("number")).sendKeys("135791113");
        
        //Click Submit
        driver.findElement(By.cssSelector(".ui.green.button")).click();
    
        //Close the browser
        driver.close();
        

	}

}
