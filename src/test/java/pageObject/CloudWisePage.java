package pageObject;

import itRunner.InitConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CloudWisePage {

    @FindBy(id = "CybotCookiebotDialogBodyLevelButtonAcceptWrapper")
    public static WebElement acceptCookie;

    @FindBy(css = "#menu-item-6352 > a")
    public static WebElement ditIsCloudWise;

    @FindBy(css = "[class='flip-box-front'] [class='inner'] h3")
    public static List<WebElement> alleCloudWisers;

    @FindBy(css = "[class='nectar-button large see-through']")
    public static List<WebElement> carouselItems;

    @FindBy(css = "[class='flip-box-front'] [class='inner'] h3")
    public static List<WebElement> departmentNames;

    @FindBy(css = "[class='flip-box-front'] [class='inner'] h3")
    public static List<WebElement> employeeNames;

    public static void initCloudWise_Steps() {
        PageFactory.initElements(InitConstants.browser, CloudWisePage.class);
    }
}
