package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class userListPage {

    @FindBy(how = How.CSS, using = "input[ng-model='user.name']")
    public WebElement user_Name;

    @FindBy(how = How.CSS, using = "input[ng-model='user.email']")
    public WebElement user_Email;

    @FindBy(how = How.CSS, using = "input[ng-model='user.login']")
    public WebElement user_userName;

    @FindBy(how = How.CSS, using = "input[ng-model='user.password']")
    public WebElement user_password;

    @FindBy(how = How.CSS, using = "button[ng-click='create()']")
    public WebElement btn_create;

    @FindBy(how = How.CSS, using = "button[ng-click='deleteUser(user)']")
    public WebElement delete_user;

    @FindBy(how = How.CSS, using = "button[ng-show='onConfirm']")
    public WebElement confirm_delete;

}
