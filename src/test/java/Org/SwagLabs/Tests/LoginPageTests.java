package Org.SwagLabs.Tests;

import Org.SwagLabs.Base.BaseTest;
import Org.SwagLabs.Pom.LoginPage;
import Org.SwagLabs.Pom.ProductsPage;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class LoginPageTests extends BaseTest {

    LoginPage loginPage;
    ProductsPage productsPage;
    InputStream datais;
    InputStream QAconfigData;
    InputStream StagingConfigData;
    JSONObject loginDetails;
    Properties props;


    @Parameters({"environment"})
    @BeforeClass
    public void beforeClass(String environment) throws Exception {

        try {
            String userdata = "Data/userData.json";

            datais = getClass().getClassLoader().getResourceAsStream(userdata);

            JSONTokener tokener = new JSONTokener(datais);

            loginDetails = new JSONObject(tokener);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (datais != null) {
                datais.close();
            }
        }

        //Reading config.properties of multiple env with switch

        switch (environment){

            case "QA":

                props = new Properties();

                String config = "Data/QA_config.properties";

                QAconfigData = getClass().getClassLoader().getResourceAsStream(config);

                props.load(QAconfigData);

                break;

            case "Staging":

               props = new Properties();

               String stagingData = "Data/Staging_config.properties";

               StagingConfigData = getClass().getClassLoader().getResourceAsStream(stagingData);

               props.load(StagingConfigData);

                break;

            default: throw new Exception();


        }




    }

    @BeforeMethod
    public void beforeMethod(Method m) {

        loginPage = new LoginPage(getDriver());
        productsPage = new ProductsPage(getDriver());

        System.out.println("\n**** Login Page Tests, Method Name: " + m.getName() + " ****");

        System.out.println("\nCurrent Thread ID Login Page Tests : " + Thread.currentThread().getId() + "\n");

    }

    @Test
    public void invalidUserNameTest() {

        loginPage.swagLabsUrl(props.getProperty("swagLabsUrl"));

        loginPage.enterUserName(props.getProperty("invalidUserName"))
                .enterPassword(props.getProperty("validPassword"))
                .clickLoginBtn()
                .assertErrorTextOnInvalidUsrnmPassword(loginDetails.getJSONObject("loginErrorTexts").getString("invalidUsernamePassword"));
    }

    @Test
    public void invalidPasswordTest() {

        loginPage.swagLabsUrl(props.getProperty("swagLabsUrl"));

        loginPage.enterUserName(props.getProperty("validUserName"))
                .enterPassword(props.getProperty("invalidPassword"))
                .clickLoginBtn()
                .assertErrorTextOnInvalidUsrnmPassword(loginDetails.getJSONObject("loginErrorTexts").getString("invalidUsernamePassword"));
    }

    @Test
    public void lockedOutUserTest() {

        loginPage.swagLabsUrl(props.getProperty("swagLabsUrl"));

        loginPage.enterUserName(props.getProperty("lockedOutUser"))
                .enterPassword(props.getProperty("validPassword"))
                .clickLoginBtn().assertLockedOutUserError(loginDetails.getJSONObject("loginErrorTexts").getString("lockedOutUser"));


    }

    @Test
    public void successfulLoginTest() {

        loginPage.swagLabsUrl(props.getProperty("swagLabsUrl"));

        loginPage.enterUserName(props.getProperty("validUserName"))
                .enterPassword(props.getProperty("validPassword"))
                .clickLoginBtn();

        productsPage.assertProductPgTitle(loginDetails.getJSONObject("productPageTexts").getString("expectedPgTitle"));


    }

}
