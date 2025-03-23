package com.automation.tests.yatra;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginTest {

	 WebDriver driver;

	    @BeforeTest
	    public void setup() {
	    	WebDriverManager.chromedriver().setup(); //automatically setups required driver eg. chrome, firefox, edge
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	    }

	    @Test
	    public void testLogin() throws InterruptedException {
	    	
	        driver.get("https://www.yatra.com/");
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String title = driver.getTitle();
	        
	        System.out.println("New Tab Title: " + title);
	        
	        driver.findElement(By.xpath("//h4[text()= 'Round Trip']")).click();   //Radio button- Round Trip
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        driver.findElement(By.xpath("//h4[text()= 'Multi City']")).click();   //Radio button- Multi City
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        driver.findElement(By.xpath("//h4[text()= 'One Way']")).click();   //Radio button- One Way
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	        WebElement goingTo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p [@title= 'Mumbai']"))); //Going To
	        goingTo.click(); // goingTo
	        WebDriverWait wait0 = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.findElement(By.xpath("//input [@type= 'text']")).sendKeys("Prayagraj");  //Destination name
	        driver.manage().timeouts().getImplicitWaitTimeout();
	        driver.findElement(By.xpath("//div [@class= 'fw-600 mb-0' and text()= 'Prayagraj, (IXD)'] ")).click();
	        driver.manage().timeouts().getScriptTimeout();
	        //driver.findElement(By.xpath("//div[@class= 'close' ]")).click();
	        driver.findElement(By.xpath("//div [@class= 'css-rd021u']")).click(); // click on the Date
	        
	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        driver.findElement(By.xpath("//div[@class= 'close' ]")).click();
	        driver.findElement(By.xpath("//span [@class='custom-day-content ' and text ()= '₹4,378']")).click();  //date selection of 2nd March
	        driver.manage().timeouts().getImplicitWaitTimeout();
	        driver.findElement(By.xpath("//span [text()= 'Non-Stop Flights']")).click();  // selecting checkbox- Non-Stop Flights
	        driver.findElement(By.xpath("//button [@type= 'button' and text()= 'Search']")).click(); // click on search button
	        
	        driver.findElement(By.xpath("//p [text()= 'Saver Fare']")).getLocation();
	        
	        driver.manage().wait(10, 1000);
	        
	        driver.findElement(By.xpath("//span [text()='Modify Search']")).click();
	        driver.manage().wait(10, 1000);
	        driver.findElement(By.xpath("(//div[contains(@class,'booking-section')])[1]//button")).click();
	        driver.manage().wait(10, 1000);
	        
	        System.out.println ("Yatra.com");
	     
	        //System.out.println("New Tab Title: " + driver.getTitle());
	        
	      
		
	    }

	    @AfterTest
	    public void tearDown() {
	      //  driver.quit();
	      }
}