package BasicElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DomSelectors {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        //driver.get("https://rahulshettyacademy.com/");
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.id("inputUsername")).sendKeys("amrakotha@gmail.com");
        driver.findElement(By.name("inputPassword")).sendKeys("Serajul5");
        driver.findElement(By.className("signInBtn")).click();

        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Omar"); //Xpath selector
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("omar@gmail.com");
        driver.findElement(By.xpath("//input[placeholder='text'][2]")).clear(); //Multiple matching that's why we use index
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("omar@yahoo.com");

        driver.findElement(By.xpath("//form/input[3]")).sendKeys("5146906569");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        Thread.sleep(1000);

        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

        //driver.close(); // This is to close the current tab only.
        //driver.quit(); // This will quit all the tabs opened by selenium
    }
}
