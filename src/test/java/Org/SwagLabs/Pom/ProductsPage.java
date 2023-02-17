package Org.SwagLabs.Pom;

import Org.SwagLabs.Base.BasePage;
import Org.SwagLabs.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private final By productsPageTitle = By.className("title");

    private final By addToCartBtnSLB = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");

    private final By removeBtnSLB = By.cssSelector("#remove-sauce-labs-backpack");

    private final By addToCartBtnSLBL = By.cssSelector("#add-to-cart-sauce-labs-bike-light");

    private final By removeBtnSLBL = By.name("remove-sauce-labs-bike-light");

    private final By cartIconCount = By.className("shopping_cart_badge");

    private final By shoppingCartLink = By.className("shopping_cart_link");


    //methods:


    public String ActualTextProductPgTitle() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(productsPageTitle)).getText();

    }

    public String expectedTextProductPgTitle(String txt) {

        return txt;

    }


    public ProductsPage assertProductPgTitle(String txt) {

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(productsPageTitle)).isDisplayed());

        Assert.assertEquals(ActualTextProductPgTitle(), expectedTextProductPgTitle(txt));

        return this;
    }


    public ProductsPage clickAddtoCartBtnSLB() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtnSLB)).click();

        return this;
    }

    public ProductsPage assertRemoveBtnSLB() {

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(removeBtnSLB)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(removeBtnSLB)).isEnabled());

        return this;
    }

    public ProductsPage clickAddToCartBtnSLBL() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtnSLBL)).click();

        return this;
    }

    public ProductsPage assertRemoveBtnSLBL() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(removeBtnSLBL)).isDisplayed();

        wait.until(ExpectedConditions.visibilityOfElementLocated(removeBtnSLBL)).isEnabled();

        return this;
    }

    public String getTextFromCartIcon() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartIconCount)).getText();

    }


    public ProductsPage assertCartIconCount2Products() {

        Assert.assertEquals(getTextFromCartIcon(), "2");

        return this;
    }

    public YourCartPage clickCartIcon() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartLink)).click();

        return new YourCartPage(driver);
    }

}
