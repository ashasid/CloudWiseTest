package pageObject;

import itRunner.InitConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GateKeeperPage {

    @FindBy(id = "mat-input-0")
    public static WebElement input0;

    @FindBy(id = "mat-input-1")
    public static WebElement input1;

    @FindBy(id = "mat-input-2")
    public static WebElement output;

    @FindBy(css = "#mat-input-3")
    public static WebElement searchField;

    @FindBy(css = "body > app-root > app-test > div > div > div:nth-child(1) > div:nth-child(3) > div > div")
    public static WebElement searchResult;

    @FindBy(css = "[class='mat-button-wrapper']")
    public static WebElement letTheBattleBegin;

    @FindBy(css = "app-popup-dialog [class='fal fa-bullseye-arrow ng-star-inserted']")
    public static List<WebElement> targetOnPopUp;

    @FindBy(css = "app-popup-dialog [class='fal fa-bullseye-arrow ng-star-inserted'][style='color: orange; cursor: pointer;']")
    public static WebElement orangeTarget;

    @FindBy(css = "body > app-root > app-test > div > div > div:nth-child(2) > div > p > span")
    public static WebElement extractedOfficeAddress;

    @FindBy(css = "[data-anchor='dataItem-kvi1acxb']")
    public static WebElement ContactsLink;

    @FindBy(id = "comp-kvi6khho")
    public static WebElement actualOfficeAddress;

    public static void initGateKeeper_Steps() {
        PageFactory.initElements(InitConstants.browser, GateKeeperPage.class);
    }
}
