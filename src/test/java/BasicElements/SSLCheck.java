package BasicElements;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSLCheck {
    public static void main(String[] args) {
        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);

        // If you want to set proxy to access a site use this
        //Proxy proxy = new Proxy();
        //proxy.setHttpProxy("ipaddress:127.0,09.4"); // many ways to set proxy. here we use http
        //options.setCapability("proxy", proxy);

        WebDriver driver = new FirefoxDriver(options); // Need to provide option when you want to by pass the SSL certificate issue
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
    }
}
