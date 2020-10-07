package Extension;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import static  org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class Verifications extends CommonOps
{

    @Step("Verify text in element")
    public static void textInElement(WebElement elem, String expectedValue)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expectedValue);
    }

    @Step("Verify number of elements Equals to")
    public static void numberOfElements(List<WebElement> elems, int expectedValue)
    {
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        assertEquals(elems.size(), expectedValue);
    }

    @Step("Verif Elemeny visually")
    public static void visualElement(WebElement imageElement, String expectedImageName)
    {
        BufferedImage expectedImage = null;
        try {
                expectedImage = ImageIO.read(new File(getData("ImageRepo") +expectedImageName +".png" ));
            }
        catch (Exception e)
        {
            System.out.println("Error rading image file: "+e);
        }
        Screenshot imageScreenshot = new AShot().takeScreenshot(driver,imageElement);
        BufferedImage actualImage =imageScreenshot.getImage();
        diff=imgDiff.makeDiff(actualImage, expectedImage);
        assertFalse(diff.hasDiff(), "Images aren't the same");

    }
}
