package Org.SwagLabs.Tests;

import Org.SwagLabs.Base.BaseTest;
import Org.SwagLabs.Pom.LoginPage;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class LoginPageTests extends BaseTest {

    LoginPage loginPage;
    InputStream datais;
    InputStream configData;
    JSONObject loginDetails;
    Properties props;


    @BeforeClass
    public void beforeClass() throws IOException {

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

        //Reading config.properties

        props = new Properties();

        String config = "Data/config.properties";

        configData = getClass().getClassLoader().getResourceAsStream(config);

        props.load(configData);


    }

    @BeforeMethod
    public void beforeMethod(Method m) {

        loginPage = new LoginPage(getDriver());

        System.out.println("\n**** Method Name: " + m.getName() + " ****\n");

    }

    @Test
    public void invalidUserNameTest() {

        loginPage.swagLabsUrl(props.getProperty("swagLabsUrl"));

        loginPage.enterUserName(loginDetails.getJSONObject("InvalidUserName").getString("username"))
                .enterPassword(loginDetails.getJSONObject("InvalidUserName").getString("password"))
                .clickLoginBtn()
                .assertErrorTextOnInvalidUsrnmPassword(loginDetails.getJSONObject("loginErrorTexts").getString("invalidUsernamePassword"));
    }

    @Test
    public void invalidPasswordTest() {

        loginPage.swagLabsUrl(props.getProperty("swagLabsUrl"));

        loginPage.enterUserName(loginDetails.getJSONObject("inValidPassword").getString("username"))
                .enterPassword(loginDetails.getJSONObject("inValidPassword").getString("password"))
                .clickLoginBtn()
                .assertErrorTextOnInvalidUsrnmPassword(loginDetails.getJSONObject("loginErrorTexts").getString("invalidUsernamePassword"));
    }

    @Test
    public void lockedOutUserTest() {

        loginPage.swagLabsUrl(props.getProperty("swagLabsUrl"));

        loginPage.enterUserName(loginDetails.getJSONObject("lockedOutUser").getString("username"))
                .enterPassword(loginDetails.getJSONObject("lockedOutUser").getString("password"))
                .clickLoginBtn().assertLockedOutUserError(loginDetails.getJSONObject("loginErrorTexts").getString("lockedOutUser"));


    }

}
