package SanityTests;

import Extension.UIActions;
import Extension.Verifications;
import Utilities.CommonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)

public class GrafanaWeb extends CommonOps {
    @Test (description = "Test01: Login to Grafana")
    @Description("Test Description: Login to Grafana web application")
    public void test01_login()
    {
        webFlows.login("admin","admin");
        Verifications.textInElement(grafanaMain.txt_mainHeader,"Home Dashboard");
    }

   @Test(description = "Test02: Verify Default Users")
   @Description("Test Description: Verifies the Defaults number of users (Should be1)")
   public void test02_VerifyDefaultUsers()
   {
        UIActions.mouseHoverElements(grafanaleftMenu.btn_ServerAdmin, grafanaServerAdminMenuPage.link_users);
        Verifications.numberOfElements(grafanaServerAdminMainPage.rows, 1);
    }

    @Test(description = "Test03: Add and verify users")
    @Description ("Test Description: Add a new user and verify the of users is 2")
    public void test03_AddNewUserandVerifications()
    {
        UIActions.mouseHoverElements(grafanaleftMenu.btn_ServerAdmin, grafanaServerAdminMenuPage.link_users);
        webFlows.createUser("shiri", "shiri@gmail.com", "shirosh", "87558");
        Verifications.numberOfElements(grafanaServerAdminMainPage.rows, 2);

    }

    @Test(description = "Test 04: Delete last user and verify users")
    @Description("Test Description: Delete last created user and verify the number of users is 1")
    public void test04_deleteandverify()
    {
        UIActions.mouseHoverElements(grafanaleftMenu.btn_ServerAdmin, grafanaServerAdminMenuPage.link_users);
        webFlows.deleteLastUser();
        Verifications.numberOfElements(grafanaServerAdminMainPage.rows, 1);
    }

    @Test(description = "Test 05: Verify Avatar")
    @Description("Test Description: Verify Grafana's default (admin) Avatar")
    public void test05_verifyLogoAvatar()
    {
     Verifications.visualElement(grafanaleftMenu.img_Avatar, "garafanaAvatar");
    }


}
