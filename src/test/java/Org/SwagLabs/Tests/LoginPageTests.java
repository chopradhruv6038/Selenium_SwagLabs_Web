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

        System.out.println("**** Method Name: " + m.getName() + " ****");


    }

    @Test
    public void validLoginTest() {

      loginPage.swagLabsUrl(props.getProperty("swagLabsUrl"));





    }


}
