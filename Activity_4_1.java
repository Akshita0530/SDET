package Selenium_Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_4_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
 
        //And now use this to visit the website
        driver.get("https://www.training-support.net");
 
        //Check the title of the page
        String title = driver.getTitle();
        //Print the title of the page
        System.out.println("The Title of the Page is: " + title);
 
        //Find the "Get Started!" link and click it
        driver.findElement(By.xpath("/html/body/div/div/div/a")).click();
 
        //Print title of new page
        System.out.println("The Heading of the page is: " + driver.getTitle());
 
        //Close the browser
        driver.close();

	}

}
