package Org.SwagLabs.Pom;

import Org.SwagLabs.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By userNameFld = By.cssSelector("#user-name");
    By passwordFld = By.cssSelector("#password");
    By loginBtn = By.xpath("//input[@class='submit-button btn_action']");
    By invalidUserNamePasswordError = By.xpath("//h3[@data-test='error']");
    By lockedOutUserError = By.xpath("//h3[@data-test='error']");


    //Methods: user actions

    public void swagLabsUrl(String text) {

        loadUrl(text);


    }

    public LoginPage enterUserName(String username) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameFld)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameFld)).sendKeys(username);

        return this;
    }

    public LoginPage enterPassword(String password) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFld)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFld)).sendKeys(password);



        return this;
    }


    public LoginPage clickLoginBtn() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).click();

        return this;
    }

    public String getErrorTextForInvalidUsrnmPasswd() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(invalidUserNamePasswordError)).getText();
    }

    public String expectedTextForInvalidUserNamePasswd(String text) {

        return text;

    }

    public void assertErrorTextOnInvalidUsrnmPassword(String text) {

        Assert.assertEquals(getErrorTextForInvalidUsrnmPasswd(), expectedTextForInvalidUserNamePasswd(text));

        System.out.println("Actual error for invalid usernamePassword : " + getErrorTextForInvalidUsrnmPasswd() + "\nExpected error for invalid usernamePassword : " + expectedTextForInvalidUserNamePasswd(text));

    }

    public String ActualLockedOutUserError() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(lockedOutUserError)).getText();
    }

    public String expectedLockedOutUserError(String text) {

        return text;

    }

    public LoginPage assertLockedOutUserError(String text) {

        Assert.assertEquals(ActualLockedOutUserError(), expectedLockedOutUserError(text));

        System.out.println("Actual error for locked out user : " + ActualLockedOutUserError() + "\nExpected error for locked out user : " + expectedLockedOutUserError(text));

        return this;
    }

}
