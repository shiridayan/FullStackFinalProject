package Utilities;

import io.qameta.allure.Attachment;
import net.sf.cglib.asm.$Type;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners extends CommonOps implements ITestListener
{
    public void onStart(ITestContext execution)
    {
        System.out.println("________Starting Execution_____________");

    }

    public void onFinish(ITestContext execution)
    {

        System.out.println("________Ending Execution_____________");
    }



    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0)
    {
        // TODO Auto-generated method stub
    }


    public void onTestSkipped(ITestResult test)
    {
        System.out.println("___________________Skipping Test:" + test.getName() +"_____________________");
    }

    public void onTestStart(ITestResult test)
    {

        System.out.println("___________________Starting Test:" + test.getName() +"_____________________");
    }

    public void onTestSuccess(ITestResult test)
    {

        System.out.println("___________________Test:" + test.getName() +"Passed_____________________");
    }

    public void onTestFailure(ITestResult test)
    {

        System.out.println("___________________Test:" + test.getName() +"Failed_____________________");
        Savescreenshot();
    }

    @Attachment (value =  "Page Screen-Shot" , type ="image/png")
    public byte[] Savescreenshot()
    {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

}
