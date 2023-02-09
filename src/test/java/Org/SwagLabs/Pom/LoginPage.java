package Org.SwagLabs.Pom;

import Org.SwagLabs.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By userNameFld = By.cssSelector("#Username");
    By passwordFld = By.cssSelector("#Password");
    By loginBtn = By.xpath("//input[@class='submit-button btn_action']");


    //Methods: user actions

    public String loadUrl(String text){

        return text;

    }

    public LoginPage enterUserName(String username) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameFld)).sendKeys(username);

        return this;
    }

    public LoginPage enterPassword(String password) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFld)).sendKeys(password);

        return this;
    }


    public LoginPage clickLoginBtn() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).click();

        return this;
    }


}
