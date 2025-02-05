package seleniumcodes;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class allops {
    WebDriver driver;

    @BeforeTest
    public void setup() {
       // System.setProperty("webdriver.chrome.driver", "C:\\seleniumwebdriver\\chromedriver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    @Test
    public void testDropdownsAndSelections() throws InterruptedException {
        // Selecting passengers dropdown
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000);
        int i = 1;
        while (i < 5) {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        
        // Selecting currency dropdown
        Select drop = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
        drop.selectByIndex(1);

        // Selecting origin and destination
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value='MAA']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='CJB']")).click();
        
        // Checkbox selection
        WebElement familyCheckbox = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily"));
        familyCheckbox.click();
        Assert.assertTrue(familyCheckbox.isSelected(), "Friends & Family checkbox should be selected");

        // Radio button selection
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
        
        // Validation of Round Trip selection
        String style = driver.findElement(By.id("Div1")).getAttribute("style");
        if (style.contains("1")) {  // Adjust condition based on actual attribute value
            System.out.println("It is not a round trip");
            Assert.assertTrue(true);
        } else {
            Assert.fail("Round trip selection is incorrect");
        }

        // Autosuggestive dropdown selection
        driver.findElement(By.id("autosuggest")).sendKeys("au");
        Thread.sleep(3000);
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a[class='ui-corner-all']"));
        Thread.sleep(2000);
        for (WebElement element : options) {
            if (element.getText().equalsIgnoreCase("Austria")) {
                element.click();
                break;
            }
        }

        // Clicking search button
        driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
