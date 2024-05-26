package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class FullFormExercise {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        String password = "Omaiza23";

        driver.findElement(By.cssSelector(".form-control.ng-untouched.ng-pristine.ng-invalid[minlength='2']")).sendKeys("Omaiza Mahnoor");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("omaiza@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);

        if(driver.findElement(By.id("exampleCheck1")).isDisplayed()) {
            driver.findElement(By.id("exampleCheck1")).click();
        }

        Thread.sleep(2000);

        WebElement genderDropdown = driver.findElement(By.cssSelector("select[id='exampleFormControlSelect1']"));
        Select selectOptions = new Select(genderDropdown);
        selectOptions.selectByVisibleText("Female");
        Thread.sleep(2000);
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        String selectRadioButton = "Student";
        for (WebElement employmentStatus : radioButtons) {

            String radioButtonId = employmentStatus.getAttribute("id");
            String currentRadioButton = driver.findElement(By.cssSelector("label[for='" + radioButtonId + "']")).getText();
            if (currentRadioButton.equals(selectRadioButton)) {
                employmentStatus.click();
                break;
            }
        }

        driver.findElement(By.cssSelector("input[type='date']")).sendKeys("2023-01-10");

        driver.findElement(By.cssSelector("input[value='Submit']")).click();

        String successMsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
        if(successMsg.contains("Success!")) {
            Assert.assertTrue(true);
        }
    }
}
