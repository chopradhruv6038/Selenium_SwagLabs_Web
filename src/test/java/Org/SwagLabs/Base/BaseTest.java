package Org.SwagLabs.Base;

import Org.SwagLabs.Factory.DriverManager;
import Org.SwagLabs.Utils.TestUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();



    protected static String dateTime; //Date time global variable.

    public void setDriver(WebDriver driver) {

        this.driver.set(driver);
    }

    public WebDriver getDriver() {

        return this.driver.get();

    }


    @Parameters({"browser"})
    @BeforeMethod
    public void startDriver(String browser) {


        setDriver(new DriverManager().initializeDriver(browser));


    }

    @Parameters({"browser"})
    @AfterMethod
    public void quitDriver(ITestResult result, String browser) throws IOException {


        if (result.getStatus() == ITestResult.FAILURE) {

            File destFile = new File("Screenshots" + File.separator + browser + "_" + getDateTimes() + File.separator +
                    result.getTestClass().getRealClass().getSimpleName() + File.separator +
                    result.getMethod().getMethodName() + ".png");

            getScreenshot(destFile);





        }

        getDriver().quit();
    }


    public void getScreenshot(File destFile) throws IOException {

        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(srcFile, destFile);



//Attaching Snapshot to test ng report left out.

       // String completeImagePath = System.getProperty("user.dir") + File.separator + destFile;

        //Reporter.log("Hello error");
        //Reporter.log("<a href='"+ completeImagePath + "'> <img src='"+ completeImagePath + "' height='400' width='400'/> </a>");


    }


    public String getDateTimes(){

        return dateTime;

    }

    @BeforeTest
    public void beforeTest(){

        TestUtils testUtils = new TestUtils(); //test utils object to use getDateTime value
        dateTime = testUtils.getDateTime(); //using test utils getDateTime method to date time variable.
    }


}
