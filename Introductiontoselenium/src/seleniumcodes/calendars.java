package seleniumcodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class calendars {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "C:\\seleniumwebdriver\\chromedriver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testCalendarSelection() {
        // Click on the origin station dropdown to open the options
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        // Select the origin station (Chennai - MAA)
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='MAA']"))).click();

        // Select the destination station (Bengaluru - BLR)
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR'])"))).click();

        // Select one-way trip
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

        // Validate that return date selection is disabled for one-way trips
        String styleValue = driver.findElement(By.id("Div1")).getAttribute("style");
        System.out.println("Style Attribute: " + styleValue);

        if (styleValue.contains("0.5")) {
            System.out.println("It is not a round trip.");
            Assert.assertTrue(true);
        } else {
            Assert.fail("Return date should be disabled for one-way trips, but it's enabled.");
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
