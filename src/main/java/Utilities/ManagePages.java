package Utilities;

import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Base {
    public static void init()
    {
        grafanaLogin = PageFactory.initElements(driver, PageObjects.Grafana.LoginPage.class);
        grafanaMain = PageFactory.initElements(driver, PageObjects.Grafana.MainPage.class);
        grafanaleftMenu = PageFactory.initElements(driver, PageObjects.Grafana.LeftMenuPage.class);
        grafanaServerAdminMenuPage = PageFactory.initElements(driver, PageObjects.Grafana.ServerAdminMenuPage.class);
        grafanaServerAdminMainPage =  PageFactory.initElements(driver, PageObjects.Grafana.ServerAdminMainPage.class);
        grafanauserListPage =  PageFactory.initElements(driver, PageObjects.Grafana.userListPage.class);

    }


}
