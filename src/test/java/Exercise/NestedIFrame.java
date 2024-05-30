package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class NestedIFrame {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Nested Frames")).click();

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.cssSelector("div[id='content']")).getText());
    }
}
