package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class MutipleWindowsExercise {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Multiple Windows")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/windows/new']")));

        //driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
        driver.findElement(By.cssSelector("a[href*='windows']")).click();

        // Switch to another window
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();

        String parentId = iterator.next();
        String childId = iterator.next();
        driver.switchTo().window(childId);

        System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());

        driver.switchTo().window(parentId);
        System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
    }
}
