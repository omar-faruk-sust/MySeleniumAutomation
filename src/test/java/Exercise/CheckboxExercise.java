package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CheckboxExercise {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement firstOption = driver.findElement(By.cssSelector("input[id='checkBoxOption1']"));
        if(firstOption.isDisplayed()) {
            firstOption.click();
        }

        Thread.sleep(2000);

        if(firstOption.isSelected()) {
            firstOption.click();
        }

        List<WebElement> allCheckbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
        Assert.assertEquals(3, allCheckbox.size());
        System.out.println(allCheckbox.size());
    }
}
