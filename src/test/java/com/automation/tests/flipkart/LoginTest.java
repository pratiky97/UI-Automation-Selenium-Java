package com.automation.tests.flipkart;


import io.github.bonigarcia.wdm.WebDriverManager;



import org.openqa.selenium.By;
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
import java.util.concurrent.TimeUnit;
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
	    public void testLogin() {
	        driver.get("https://www.flipkart.com/");
	        String title = driver.getTitle();
	        System.out.println("Title: " + title);
	        //assert title.contains("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");   simple validation for title name
	       driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys("iphone");
	    WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(5));
	    WebElement searchbutton = driver.findElement(By.xpath("//button[@type ='submit']"));
	    searchbutton.click();
	    WebElement iPhone16 = driver.findElement(By.xpath(("//div[text()= 'Apple iPhone 16 (Ultramarine, 128 GB)']")));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    iPhone16.click(); //default screen
	    
	    //pop-up tab
	    String parentWindow = driver.getWindowHandle();
        
        wait.until(ExpectedConditions.numberOfWindowsToBe(2)); // Ensure new tab opens

        for (String window : driver.getWindowHandles()) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
            }
        }
        System.out.println("New Tab Title: " + driver.getTitle());
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Continue with further actions
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
	    
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.findElement(By.xpath("//input[@placeholder='Enter Delivery Pincode']")).clear();  // clear old data
	    driver.findElement(By.xpath("//input[@placeholder='Enter Delivery Pincode']")).sendKeys("122015"); // enter new pincode
	    driver.findElement(By.xpath("//input[@placeholder='Enter Delivery Pincode']")).click(); //click
	   // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementID")));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    //driver.findElement(By.xpath("//div[@class='AEyO3k z5++mS OtJHiR TMNmtm uRvHUf IjEfvK uGNjfd']")).click();  //click on check
	    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.findElement(By.xpath("//button[@class='QqFHMw cNEU5Q J9Kkbj _7Pd1Fp']")).click();  // Add 2 items in the Cart button
	    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementID")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
//	    WebElement plusicon =driver.findElement(By.xpath("//button[@class='LcLcvv' and text()='+'][1]"));
//	    plusicon.click();
//	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
//	    WebElement minusicon= driver.findElement(By.xpath("//button[@class='LcLcvv' and text()='–'][1]"));
//	    minusicon.click();
//	    
        
	    driver.findElement(By.xpath("//input[@title= 'Search for products, brands and more']")).sendKeys("iPad Air M2",Keys.ENTER);
	    try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
        driver.findElement(By.xpath("//button[@type= 'submit']")).click();
        //driver.findElement(By.xpath("//button[@type= 'submit']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement iPad= driver.findElement(By.xpath("//div[text()= 'Apple 2024 iPad Air (M2) 128 GB ROM 11.0 Inch with Wi-Fi Only (Space Grey)']"));
        	iPad.click();
        	
        //2nd child tab
       String childWindow = driver.getWindowHandle();
        
        wait.until(ExpectedConditions.numberOfWindowsToBe(3)); // Ensure new tab opens

        for (String window : driver.getWindowHandles()) {
            if (!window.equals(childWindow)) {
                driver.switchTo().window(window);
            }
        }
        System.out.println("New Tab Title: " + driver.getTitle());
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
	 
	   }

	    @AfterTest
	    public void tearDown() {
	        //driver.quit();
	    }
	}
