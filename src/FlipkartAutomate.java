import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class FlipkartAutomate {
    String filePath = "D:\\SCREENSHOTS";
    
    WebDriver driver;
    
    @BeforeTest
    public void launchBrowser() {
    System.setProperty("webdriver.gecko.driver", "D://Workspace//Automate//Drivers//geckodriver.exe");
    String url = "https://www.flipkart.com/";
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.get(url);
    String title = driver.getTitle();
    System.out.println(title);
    }
    
    
    @Test(priority=1)
    public void login() throws InterruptedException {
        
        driver.findElement(By.linkText("Log In")).click();
     driver.findElement(By.xpath(".//form/div[1]/following::input")).click();
     driver.findElement(By.xpath(".//form/div[1]/following::input")).sendKeys("itichausali@gmail.com");
     driver.findElement(By.xpath(".//input[@type='password']")).click();
     driver.findElement(By.xpath(".//input[@type='password']")).sendKeys("papa@123456");
     driver.findElement(By.xpath(".//form/div[3]/button")).click();
     Thread.sleep(5000);
     String element = driver.findElement(By.xpath(".//div[1]/div[1]/div/ul/li[8]/a")).getText();
     System.out.println(element);
  //  Assert.assertEquals("Hi Iti!", element);
     
    }
    @Test(priority=2)
    public void categorySelecction() throws InterruptedException { 
        driver.findElement(By.xpath(".//a/span[text()='Electronics']")).click();
            //Thread.sleep(4000);
          WebDriverWait wait = new WebDriverWait(driver,25);
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a/span[text()='Apple']"))).click();     
     }
    @Test(priority=3)
    public void priceSelector() {
        
        WebElement minrange = driver.findElement(By.xpath(".//section/div[4]/div[1]/select"));
        Select minvalue = new Select(minrange);
        minvalue.selectByValue("5000");
        WebElement maxrange = driver.findElement(By.xpath(".//section/div[4]/div[3]/select"));
        Select maxvalue = new Select(maxrange);
        maxvalue.selectByValue("10000+");
    }
@Test(priority=4)
    public void scroll() {
        
    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,3000)");
    }
@Test(priority=5)
public void selectproduct() {
    driver.findElement(By.xpath("//a[contains(@href,'apple-iphone-7-rose-gold-32-gb')]")).click();
}
    

@Test(priority=6) 
public void changePin() throws InterruptedException {
    driver.findElement(By.xpath("//div[1]/span[text() = 'Change']")).click();
    
    driver.findElement(By.xpath(".//li[1]/div/p[text() = '201014']")).click();
    Thread.sleep(3000);
    //driver.findElement(By.id("pincodeInputId")).sendKeys("201014")
}
@Test(priority=7) 
public void buynow() throws IOException {
    
    
    WebDriverWait wait = new WebDriverWait(driver,20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='container']/div/div[2]/div/div/div[1]/div/div[1]/div/div/div[2]/ul/li[2]/form/button"))).click();
    driver.findElement(By.xpath("//div[1]/div[2]/div/div[1]/div[1]/a/p[4]")).click();
    
    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,3000)");
    WebDriverWait wait1 = new WebDriverWait(driver,20);
    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/div[2]/div/div[1]/a"))).click();
     File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     //The below method will save the screen shot in d drive with name "screenshot.png"
        FileUtils.copyFile(scrFile, new File("D:\\screenshot.png"));
}
    
}