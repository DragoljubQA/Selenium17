package SeleniumUvod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Selenium9 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        /*WebElement card = driver.findElement(By.className("card-body"));
        card.click();*/

        List<WebElement> card = driver.findElements(By.className("card-body"));
        //card.get(3).click();

        for (int i = 0; i < card.size(); i++) {
            if (card.get(i).getText().equals("Widgets")) {
                card.get(i).click();
                break;
            }
        }





    }
}
