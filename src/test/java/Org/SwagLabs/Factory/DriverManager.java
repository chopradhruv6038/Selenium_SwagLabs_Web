package Org.SwagLabs.Factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    protected WebDriver driver;


    public WebDriver initializeDriver(String browser) {

        switch (browser) {

            case "chrome":

                WebDriverManager.chromedriver().cachePath("Driver").setup();
                driver = new ChromeDriver();
                break;


            case "firefox":
                WebDriverManager.firefoxdriver().cachePath("Driver").setup();
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException("invalid browser" + browser);
        }

        driver.manage().window().maximize();

        return driver;
    }

}
