package tendable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TendableChallengeSolution {
	
	public WebDriver driver;
	   
	   
	@BeforeClass
	   public void setUp() {
	       
		   WebDriverManager.chromedriver().setup();
	       driver = new ChromeDriver();
	       driver.manage().window().maximize();
	   }
	   @Test(priority = 1)
	   public void testTopLevelMenus() {
	      
	       driver.get("https://www.tendable.com");
	      
	       driver.findElement(By.className("logo")).click();
	       String Home=driver.getCurrentUrl();
	       Assert.assertEquals(Home, "https://www.tendable.com/");
	       
	      System.out.println();
	       driver.findElement(By.linkText("Our Story")).click();
	       Assert.assertEquals(driver.getCurrentUrl(), "https://www.tendable.com/our-story");
	       
	       driver.findElement(By.linkText("Our Solution")).click();
	       Assert.assertEquals(driver.getCurrentUrl(), "https://www.tendable.com/our-solution");
	       
	       driver.findElement(By.linkText("Why Tendable?")).click();
	       Assert.assertEquals(driver.getCurrentUrl(), "https://www.tendable.com/why-tendable");
	   }
	   @Test(priority = 2)
	   public void testDemoButtonPresence() {
	      
	       driver.get("https://www.tendable.com");
	       
	       WebElement demoButton = driver.findElement(By.linkText("Request A Demo"));
	       Assert.assertTrue(demoButton.isDisplayed());
	       Assert.assertTrue(demoButton.isEnabled());
	       System.out.println("Demo Button is Displayed :" +demoButton.isDisplayed());
	       System.out.println("Demo Button is Enabled :" + demoButton.isEnabled());
	   }
	  
	   @Test(priority = 3)
	   public void testErrorMessage() throws InterruptedException {
	     
	       driver.get("https://www.tendable.com/contact-us");
	      
	       WebElement marketingOption = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div/div[1]/div/div[2]/div[2]/button"));
	       marketingOption.click();
	       
	       driver.findElement(By.id("form-input-fullName")).sendKeys("Mohnish Rathod");
	       driver.findElement(By.id("form-input-email")).sendKeys("mohnishr555@yopmail.com");
	       driver.findElement(By.id("form-input-cellPhone")).sendKeys("8149438892");
	     WebElement bt= driver.findElement(By.xpath("//button[contains(@data-loading-text,'Loading...')][normalize-space()='Submit']"));
	       Actions Act= new Actions(driver);
	       Act.doubleClick(bt).perform();
	       
	      // Wait for error message to appear
	      Thread.sleep(3000);
	    	
	      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20) );
	      WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ff-form-errors")));
	       Assert.assertTrue(errorMessage.isDisplayed());
	   }
	   
	@AfterClass
	   public void tearDown() {
	       
	       driver.quit();
	   }

}
