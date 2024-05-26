package BasicElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class Checkbox {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // This will
        //div[@id='discount-checkbox'] a
        driver.findElement(By.cssSelector("input[id*='chk_friendsandfamily']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='chk_friendsandfamily']")).isSelected());

        WebElement checkbox = driver.findElement(By.cssSelector("input[id*='chk_SeniorCitizenDiscount']"));

        //pre-validation to confirm that checkbox is displayed.
        if(checkbox.isDisplayed())
        {
            System.out.println("Checkbox is displayed. Clicking on it now");
            checkbox.click();
        }

        //post-validation to confirm that checkbox is selected.
        if(checkbox.isSelected())
        {
            System.out.println("Checkbox is checked");
        }

        List<WebElement> allCheckbox = driver.findElements(By.cssSelector("div[id='discount-checkbox'] input[type = 'checkbox']"));

        for (WebElement isCheckbox: allCheckbox) {
            if(!isCheckbox.isSelected() && isCheckbox.isDisplayed()) {
                System.out.println("Not selected Checkbox: " + isCheckbox.getText());
            } else {
                System.out.println("Selected Checkbox: " + isCheckbox.getText());
            }
        }
    }
}
