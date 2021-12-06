package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.AfterStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import pageObject.GateKeeperPage;
import static itRunner.InitConstants.browser;
import static itRunner.InitConstants.prop;
import static reusableHelpers.ElementHelpers.*;

public class GateKeeperSteps {

    // This After Step executes after each scenario to capture screenshot if any failed steps
    @AfterStep
    public static void afterEachScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) browser).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
        }
    }

    @Given("I launch the gatekeeper application")
    public static void iLaunchGateKeeperApp() {
        browser.manage().deleteAllCookies();
        browser.get(prop.getProperty("gateKeeperURL"));
        browser.manage().window().maximize();
        compareExpectedWithActual("Gatekeeper", browser.getTitle());
    }

    @When("I will add two input numbers as {int} and {int}")
    public static void iWillAddTwoNumbers(Integer input1,Integer input2) {
        waitForElementToBeVisible(GateKeeperPage.input0);
        enterValueInEditField(GateKeeperPage.input0, String.valueOf(input1));
        enterValueInEditField(GateKeeperPage.input1, String.valueOf(input2));
    }

    @Then("I should get result as {int}")
    public static void iWillVerifyTheResult(Integer output) {
        compareExpectedWithActual(String.valueOf(output), GateKeeperPage.output.getAttribute("value"));
    }

    @When("I search the field as {string} and click on enter")
    public static void iSearchTheField(String searchValue) throws InterruptedException {
        scrollIntoViewPort(GateKeeperPage.searchField);
        waitForElementToBeVisible(GateKeeperPage.searchField);
                GateKeeperPage.searchField.sendKeys(Keys.ENTER);
        GateKeeperPage.searchField.sendKeys(searchValue+ Keys.ENTER);
    }

    @Then("I result should be as {string}")
    public static void iResultShouldBe(String searchResult) {
        waitForElementToBeVisible(GateKeeperPage.searchResult);
        compareExpectedWithActual(searchResult, GateKeeperPage.searchResult.getText());
    }

    @Then("I click on Let battle begin")
    public static void iClickOnLetTheBattleBegin() {
        waitForElementToBeVisible(GateKeeperPage.letTheBattleBegin);
        GateKeeperPage.letTheBattleBegin.click();
    }
    @Then("I should see popup with orange target")
    public static void iShouldSeeOrangeTarget() throws InterruptedException {
        Thread.sleep(1000);
        waitForElementToBeVisible(GateKeeperPage.targetOnPopUp.get(0));
        verifyElementDisplayed(GateKeeperPage.targetOnPopUp.get(0));
    }

    @Then("I click on orange target")
    public static void iClickOnOrangeTarget() {
        waitForElementToBeVisible(GateKeeperPage.orangeTarget);
        GateKeeperPage.orangeTarget.click();
        verifyElementDisplayed(GateKeeperPage.letTheBattleBegin);
    }

    @Then("I click on Contacts")
    public static void iClickOnContacts() {
        waitForElementToBeVisible(GateKeeperPage.extractedOfficeAddress);
        browser.switchTo().frame(0);
        GateKeeperPage.ContactsLink.click();
    }

    @When("I scroll down to office address in codeshake and verify with extracted address")
    public static void verifyOfficeAddressWithExtractedAddress() {
        verifyElementDisplayed(GateKeeperPage.extractedOfficeAddress);
        String expectedAddress = GateKeeperPage.extractedOfficeAddress.getText().trim();
        browser.switchTo().frame(0);
        GateKeeperPage.ContactsLink.click();
        scrollIntoViewPort(GateKeeperPage.actualOfficeAddress);
        verifyElementDisplayed(GateKeeperPage.actualOfficeAddress);
        String actualAddress = GateKeeperPage.actualOfficeAddress.getText().trim();
        compareExpectedWithActual(expectedAddress,actualAddress.trim());
    }
}

