package Helpers;

import Utilities.CommonOps;
import Utilities.helpersMethods;
import WorkFlows.webFlows;
import org.testng.annotations.Test;

public class VisualTesting extends CommonOps {
    @Test
    public void createScreenshot()
    {
        webFlows.login("admin", "admin");
        helpersMethods.takeElementScreenShot(grafanaleftMenu.img_Avatar, "garafanaAvatar_ver1.00");
    }
}
