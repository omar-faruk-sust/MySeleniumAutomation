package BasicElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavascriptAlert {
    public static void main(String[] args) throws InterruptedException {
        String text="Omaiza";

        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.cssSelector("[id='alertbtn']")).click();
        Thread.sleep(2000);

        System.out.println(driver.switchTo().alert().getText());

        // To accept/ok the alert
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        driver.findElement(By.id("confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());

        // To cancel the alert
        driver.switchTo().alert().dismiss();
    }
}
