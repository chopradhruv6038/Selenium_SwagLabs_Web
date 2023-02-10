package Org.SwagLabs.Pom;

import Org.SwagLabs.Base.BasePage;
import Org.SwagLabs.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver){
        super(driver);
    }

    By productsPageTitle = By.className("title");






    //methods:


    public String ActualTextProductPgTitle(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(productsPageTitle)).getText();

    }

    public String expectedTextProductPgTitle(String txt){

        return txt;

    }


    public ProductsPage assertProductPgTitle(String txt){

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(productsPageTitle)).isDisplayed());

        Assert.assertEquals(ActualTextProductPgTitle(), expectedTextProductPgTitle(txt));

        return this;
    }







}
