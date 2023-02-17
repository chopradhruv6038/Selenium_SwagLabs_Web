package Org.SwagLabs.Pom;

import Org.SwagLabs.Base.BasePage;
import Org.SwagLabs.Objects.yourInformationCheckout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CheckoutYourInformationPage extends BasePage {

    public CheckoutYourInformationPage(WebDriver driver) {
        super(driver);
    }

    By checkoutYourInformationPgTitle = By.className("title");
    By firstNameFld = By.cssSelector("#first-name");
    By lastNameFld = By.cssSelector("#last-name");
    By postalCodeFld = By.cssSelector("#postal-code");


//methods:

    public String getTitleCheckoutYourInfoPg() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutYourInformationPgTitle)).getText();

    }

    public CheckoutYourInformationPage assertCheckoutYourInfoPgTitle() {

        Assert.assertEquals(getTitleCheckoutYourInfoPg(), "CHECKOUT: YOUR INFORMATION");

        return this;
    }

    public CheckoutYourInformationPage enterFirstName(String firstname) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameFld)).sendKeys(firstname);

        return this;
    }

    public CheckoutYourInformationPage enterLastName(String lastname) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameFld)).sendKeys(lastname);

        return this;
    }

    public CheckoutYourInformationPage enterPostalCode(String postalcode) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeFld)).sendKeys(postalcode);

        return this;
    }

    public CheckoutYourInformationPage enterUserYourInformation(yourInformationCheckout yourinformationcheckout) {

         enterFirstName(yourinformationcheckout.getEnterFirstName());
        enterLastName(yourinformationcheckout.getEnterLastName());
        enterPostalCode(yourinformationcheckout.getEnterPostalCode());

        return this;

    }


}