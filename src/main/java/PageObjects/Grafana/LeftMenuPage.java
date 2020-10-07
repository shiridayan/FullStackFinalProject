package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LeftMenuPage
{
    @FindBy(how = How.XPATH, using = "//div[@class='sidemenu-item dropdown'][6]")
    public WebElement btn_ServerAdmin;

    @FindBy(how = How.XPATH, using = "//div[@class='sidemenu-item dropdown dropup'][1]")
    public WebElement img_Avatar;
}
