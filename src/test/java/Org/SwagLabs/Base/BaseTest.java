package Org.SwagLabs.Base;

import Org.SwagLabs.Factory.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

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

            File destFile = new File("src" + File.separator + browser + File.separator
                    + result.getTestClass().getRealClass().getSimpleName() + "_" +
                    result.getMethod().getMethodName() + ".png");

            getScreenshot(destFile);
        }

        getDriver().quit();

    }

    public void getScreenshot(File destFIle) throws IOException {

        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, destFIle);

    }

}
