package BasicElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class AutoSuggestiveDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("autosuggest")).sendKeys("ban");
        Thread.sleep(3000);
        List<WebElement> options = driver.findElements(By.cssSelector("li[class$='ui-menu-item'] a"));

        for (WebElement option : options) {
            if(option.getText().equalsIgnoreCase("Bangladesh")) {
                option.click();
                break;
            }
        }
    }
}
