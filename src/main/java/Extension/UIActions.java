package Extension;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;


public class UIActions extends CommonOps {
    @Step("Click on Element")
    public  static void click(WebElement elem)
    {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Sent test to text-field")
    public static void updateText(WebElement elem, String value)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(value);
    }

    @Step("Update drop down field")
    public  static void  updateDropDown(WebElement elem, String value)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select myValue = new Select(elem);
        myValue.deselectByVisibleText(value);
    }

    @Step("Mouse hover to element")
    public static void mouseHoverElements(WebElement elem1, WebElement elem2)
    {
        action.moveToElement(elem1).moveToElement(elem2).click().perform();
    }
}
