package BasicElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class LoginTest {
    public static void main(String[] args) throws InterruptedException {

        String userName = "rahul";

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String password = getPassword(driver);

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.id("inputUsername")).sendKeys(userName);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();

        Thread.sleep(1000);

        String loginText = driver.findElement(By.tagName("p")).getText();
        System.out.println(loginText);
        Assert.assertEquals(loginText, "You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+userName+",");

        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        Thread.sleep(1000);


        driver.close();
    }

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();

        Thread.sleep(1000);

        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText = driver.findElement(By.cssSelector("form p")).getText();
        String[] passwordArray = passwordText.split("'");
        String originalPassword = passwordArray[1].split("'")[0];
        System.out.println(originalPassword);

        return originalPassword;
    }
}
