package WorkFlows;

import Extension.UIActions;
import Utilities.CommonOps;
import io.qameta.allure.Step;

public class webFlows extends CommonOps
{
  @Step("Login Grafane Flow")
  public  static void login (String user, String password)  {
      UIActions.updateText(grafanaLogin.txt_userName, user);
      UIActions.updateText(grafanaLogin.txt_password, password);
      UIActions.click(grafanaLogin.btn_login);
      UIActions.click(grafanaLogin.btn_skip);

  }
  @Step("Create a new user")
  public static void createUser(String name, String email, String user, String password)
  {
      UIActions.click(grafanaServerAdminMainPage.btn_newUser);
      UIActions.updateText(grafanauserListPage.user_Name, name);
      UIActions.updateText(grafanauserListPage.user_Email, email);
      UIActions.updateText(grafanauserListPage.user_userName, user);
      UIActions.updateText(grafanauserListPage.user_password, password);
      UIActions.click(grafanauserListPage.btn_create);
  }
    @Step("Delete last user from user table")
    public static void deleteLastUser()
    {
    UIActions.click(grafanaServerAdminMainPage.rows.get(grafanaServerAdminMainPage.rows.size()-1));
    UIActions.click(grafanauserListPage.delete_user);
    UIActions.click(grafanauserListPage.confirm_delete);
    }
}
