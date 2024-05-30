package BasicElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class IFrameTest {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // Switch to iframe
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));

        //driver.findElement(By.id("draggable")).click();

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement destination = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);
        action.dragAndDrop(source, destination).build().perform();

        driver.switchTo().defaultContent(); // going back to default window from frame
    }
}
