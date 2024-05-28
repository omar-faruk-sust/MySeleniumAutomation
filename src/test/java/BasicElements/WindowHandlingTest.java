package BasicElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandlingTest {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> openedWindows = driver.getWindowHandles(); // get all windows opened by web driver [parentId, childId]
        Iterator<String> it = openedWindows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);

        String email = driver.findElement(By.linkText("mentor@rahulshettyacademy.com")).getText();
        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(email);

    }
}
