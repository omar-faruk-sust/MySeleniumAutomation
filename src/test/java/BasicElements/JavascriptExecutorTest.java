package BasicElements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.List;

public class JavascriptExecutorTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor je = (JavascriptExecutor)driver;
        je.executeScript("window.scrollBy(0,500)"); // THis is to scroll a page
        Thread.sleep(2000);

        je.executeScript("document.querySelector('.tableFixHead').scrollTop=5000"); // Specific component

        // Find the column from the table and sum the values
        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum = 0;
        for (int i=0; i<values.size();i++) {
            sum = sum + Integer.parseInt(values.get(i).getText());
        }

        System.out.println(sum);

        driver.findElement(By.cssSelector(".totalAmount")).getText();
        int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
        Assert.assertEquals(sum, total);
    }
}
