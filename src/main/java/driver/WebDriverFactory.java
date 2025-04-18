package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public static WebDriver createWebDriver() {
        String browser = System.getProperty("browser", "chrome").toLowerCase();
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                WebDriver chromeDriver = new ChromeDriver();
                chromeDriver.manage().window().maximize();
                return chromeDriver;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                WebDriver firefoxDriver = new FirefoxDriver();
                firefoxDriver.manage().window().maximize();;
                return firefoxDriver;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}
