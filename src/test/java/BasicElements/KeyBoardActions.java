package BasicElements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class KeyBoardActions {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // Total number of links in the entire page
        System.out.println(driver.findElements(By.tagName("a")).size());

        // links only on footer
        WebElement footerDriver = driver.findElement(By.id("gf-BIG")); // limit your web driver scope
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        // Find only the first footer column links and click them and open into a new tab
        WebElement firstColumnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        List<WebElement> firstColumnLinks = firstColumnDriver.findElements(By.tagName("a"));
        System.out.println(firstColumnLinks.size());

        for (int i = 1; firstColumnLinks.size() > i; i++) {
            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            firstColumnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);

            Thread.sleep(2000);
        }

        // Print the titles of the opened tabs
        Set<String> openedWindows = driver.getWindowHandles();
        Iterator<String> it = openedWindows.iterator();
        while (it.hasNext()) {
            driver.switchTo().window(it.next()); // switch to the opened tab
            System.out.println(driver.getTitle()); // will get the title of opened tab
        }
    }
}
