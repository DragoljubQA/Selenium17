package SeleniumUvod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class Selenium12 {
    WebDriver driver;
    String baseURL;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void pageSetUp() {
        baseURL = "https://demoqa.com/";
        driver.navigate().to(baseURL);
    }

    public void openCard(String cardName) {
        List<WebElement> card = driver.findElements(By.className("card-body"));
        for (int i = 0; i < card.size(); i++) {
            if (card.get(i).getText().equals(cardName)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", card.get(i));
                card.get(i).click();
                break;
            }
        }
    }

    @Test
    public void goToElements() {
        openCard("Elements");
        Assert.assertEquals(driver.getCurrentUrl(), baseURL+"elements");
    }

    @Test
    public void goToForms() {
       openCard("Forms");
       Assert.assertEquals(driver.getCurrentUrl(), baseURL+"forms");
    }

    @Test
    public void goToAlerts() {
        openCard("Alerts, Frame & Windows");
        Assert.assertEquals(driver.getCurrentUrl(), baseURL+"alertsWindows");
    }

    @Test
    public void goToWidgets() {
        openCard("Widgets");
        Assert.assertEquals(driver.getCurrentUrl(), baseURL+"widgets");
    }

    @Test
    public void goToInteractions() {
        openCard("Interactions");
        Assert.assertEquals(driver.getCurrentUrl(), baseURL+"interaction");
    }

    @Test
    public void goToBookstore() {
        openCard("Book Store Application");
        Assert.assertEquals(driver.getCurrentUrl(), baseURL+"books");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
