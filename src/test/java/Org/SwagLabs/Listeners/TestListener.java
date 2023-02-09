package Org.SwagLabs.Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.PrintWriter;
import java.io.StringWriter;

public class TestListener implements ITestListener {

    public void onFailure(ITestResult result){

        if (result.getThrowable() != null){

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            result.getThrowable().printStackTrace(pw);
            System.out.println(sw.toString());



        }

    }



}
