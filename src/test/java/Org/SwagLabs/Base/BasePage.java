package Org.SwagLabs.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) { //this constructor will be used to initialize the web driver object in child classes that will extend the basePage class.

        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void loadUrl(String endpoint){

        driver.get(endpoint);
    }

}
