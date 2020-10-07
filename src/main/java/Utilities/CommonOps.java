package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import org.w3c.dom.Document;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base
{
    public static String getData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("C:\\Automation\\FullStackFinalProject\\Configuration\\DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try{
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch (Exception e){
            System.out.println("Error "+e);
        }

        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }


    public static void initBrowser(String browserType)
    {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFFDriver();
       else if (browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
       else
           throw new  RuntimeException("Invalid platform name started");
       driver.manage().window().maximize();
        driver.get(getData("url"));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
       wait = new WebDriverWait(driver,Long.parseLong(getData("Timeout")));
       action = new Actions(driver);
    }

    public  static WebDriver initChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public  static WebDriver initFFDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public  static WebDriver initIEDriver()
    {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }
    @BeforeClass
    public void startSession()
    {
        String platform="web";
        if (platform.equalsIgnoreCase("web"))
        //initBrowser("Chrome")
     //  if(getData("PlatformName").equalsIgnoreCase("web") )
           initBrowser("chrome");
    //    else if (getData("PlatformName").equalsIgnoreCase("mobile"))
     //   initMobile();
        else
            throw  new RuntimeException("Invalid platform name Started");
        ManagePages.init();
    }

    @AfterMethod
    public void afterMethod()
    {
        driver.get(getData("url"));
    }

    @AfterClass
    public void closeSession()
    {
        driver.quit();
    }


}
