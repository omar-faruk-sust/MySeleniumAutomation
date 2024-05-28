package BasicElements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsTest {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.amazon.com/");

        // ALl example with Actions class(interaction with keyboard and mouse)
        Actions action = new Actions(driver);
        WebElement move = driver.findElement(By.id("nav-link-accountList"));


        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        //action.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("ball").build().perform(); // This is to send converted capital text
        action.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("ball").doubleClick().build().perform(); // this is to select the text you send

        //Moves to specific element
        action.moveToElement(move).contextClick().build().perform(); // With contextClick you can do 'right click' on something
    }
}
