package BasicElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class StaticDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // Example of static dropdown
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3); // First way
        System.out.println(dropdown.getFirstSelectedOption().getText());
        //Assert.assertEquals("USD", dropdown.getFirstSelectedOption().getText());

        dropdown.selectByVisibleText("AED"); // Second way
        System.out.println(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByValue("INR"); // Third way
        System.out.println(dropdown.getFirstSelectedOption().getText());

        // Example of
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);

        /*int clickTimes = 1;
        while (clickTimes < 5) {
            driver.findElement(By.id("hrefIncAdt")).click();
            clickTimes ++;
        }*/

        for (int clickTime = 1; clickTime < 5; clickTime++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        String selectedText = driver.findElement(By.id("divpaxinfo")).getText();
        System.out.println(selectedText);
    }
}
