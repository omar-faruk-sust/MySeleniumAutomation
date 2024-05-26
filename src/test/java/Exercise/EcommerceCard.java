package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EcommerceCard {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        // Implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //Max can be 10S

        //Select Single item
        /*String desiredProduct = "Beetroot";
        List<WebElement> allDisplayedProducts = driver.findElements(By.cssSelector("h4.product-name"));
        System.out.println(allDisplayedProducts.size());

        for (int i = 0; i < allDisplayedProducts.size(); i++) {
            WebElement productDetails = allDisplayedProducts.get(i);
            String productName = productDetails.getText();
            if (productName.contains(desiredProduct)) {
                System.out.println(productDetails);
                driver.findElements(By.xpath("//button[text()='Add TO CART']")).get(i+1).click(); // Why does not work?
               // driver.findElements(By.xpath("//button[@type='button']")).get(i+1).click();
                break;
            }
        }*/

        String[] desiredProducts = {"Beetroot", "Cauliflower", "Beans"};
        addItems(driver, desiredProducts);
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        // Explicit wait
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();

        // Explicit wait
        WebDriverWait ew = new WebDriverWait(driver, Duration.ofSeconds(5));
        ew.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Enter promo code']")));

        driver.findElement(By.xpath("//span[contains(text(),'Code applied ..!')]"));
        driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
    }

    public static void addItems(WebDriver driver, String[] items) {
        List<WebElement> allDisplayedProducts = driver.findElements(By.cssSelector("h4.product-name"));
        System.out.println(allDisplayedProducts.size());
        int counter = 0;
        for (int i = 0; i < allDisplayedProducts.size(); i++) {
            WebElement productDetails = allDisplayedProducts.get(i);
            String[] productName = productDetails.getText().split("-");
            List<String> desiredProductList = Arrays.asList(items);
            if (desiredProductList.contains(productName[0].trim())) {

                counter++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if(counter == items.length) {
                    break;
                }
            }
        }
    }
}
