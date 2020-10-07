package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import java.awt.image.BufferedImage;

public class Base {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public  static Actions action;
    public static Screenshot imageScreenshot;
    public static ImageDiffer imgDiff = new ImageDiffer();
    public static ImageDiff diff;

    public static PageObjects.Grafana.LoginPage grafanaLogin;
    public static PageObjects.Grafana.MainPage grafanaMain;
    public static PageObjects.Grafana.LeftMenuPage grafanaleftMenu;
    public static PageObjects.Grafana.ServerAdminMenuPage grafanaServerAdminMenuPage;
    public static PageObjects.Grafana.ServerAdminMainPage grafanaServerAdminMainPage;
    public static PageObjects.Grafana.userListPage grafanauserListPage;

}
