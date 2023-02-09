package Org.SwagLabs.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void swagLabsUrl(String endpoint) {

        driver.get("https://www.saucedemo.com/" + endpoint);

    }

}
