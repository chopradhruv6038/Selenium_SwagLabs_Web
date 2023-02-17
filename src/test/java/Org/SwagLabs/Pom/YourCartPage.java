package Org.SwagLabs.Pom;

import Org.SwagLabs.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class YourCartPage extends BasePage {

    public YourCartPage(WebDriver driver) {
        super(driver);
    }

    private final By yourCartPgTitle = By.className("title");

    private final By checkoutBtn = By.cssSelector("#checkout");



    //methods

    public String getYourCartPageTitle(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(yourCartPgTitle)).getText();
    }

    public YourCartPage assertYourCartPageTitle(){

        Assert.assertEquals(getYourCartPageTitle(), "YOUR CART");

        return this;
    }

public CheckoutYourInformationPage clickCheckOutBtn(){


        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutBtn)).click();

        return new CheckoutYourInformationPage(driver);
}





}

