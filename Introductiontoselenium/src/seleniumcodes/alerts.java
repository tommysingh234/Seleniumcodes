package seleniumcodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class alerts {
    WebDriver driver;
    String text = "sharath";

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.print("Welcome to selenium");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @Test
    public void testAlerts() {
        // Enter text in the input field
        driver.findElement(By.id("name")).sendKeys(text);
        
        // Click on alert button and handle alert
        driver.findElement(By.id("alertbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        // Click on confirm button and handle alert
        driver.findElement(By.id("confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
    }

    @AfterTest
    public void tearDown() {
        driver.quit(); // Close the browser after the test
    }
}
