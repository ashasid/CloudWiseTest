package reusableHelpers;

import itRunner.InitConstants;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementHelpers extends InitConstants {

    public static void enterValueInEditField(WebElement element, String valueToEnter) {
        element.click();
        element.clear();
        element.sendKeys(valueToEnter);
    }
    public static void compareExpectedWithActual(String ExpectedValue, String ActualValue) {
        Assert.assertEquals("Compare", ExpectedValue, ActualValue);
    }

    public static void verifyElementDisplayed(WebElement element) {
        Assert.assertTrue("Element is Not enabled in verifyElementDisplayed Method", element.isEnabled());
        Assert.assertTrue("Element is Not displayed after verifyElementDisplayed Method", element.isDisplayed());
    }

    public static void waitForElementToBeVisible(WebElement element) {
        new WebDriverWait(browser, timeout).until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue("Element is not displayed after waitForElementToBeVisible Method", element.isDisplayed());
    }

    // scrollIntoViewPort : this method helps in scrolling the locator into viewport
    public static void scrollIntoViewPort(WebElement element){
        ((JavascriptExecutor)browser).executeScript("arguments[0].scrollIntoView(true);", element);
        waitForElementToBeVisible(element);
    }

    // mouseHoverAction : this method helps to Hover over on the locator
    public static void mouseHoverAction(WebElement element){
        Actions actions = new Actions(browser);
        actions.moveToElement(element).perform();
    }
}
