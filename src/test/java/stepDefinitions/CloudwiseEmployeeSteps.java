package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.CloudWisePage;
import reusableHelpers.ElementHelpers;
import java.util.ArrayList;

import static itRunner.InitConstants.browser;
import static itRunner.InitConstants.prop;
import static reusableHelpers.ElementHelpers.compareExpectedWithActual;
import static reusableHelpers.ElementHelpers.waitForElementToBeVisible;
import static reusableHelpers.JavaHelpers.getListOfDuplicateEmployeesName;

public class CloudwiseEmployeeSteps {

    @Given("I launch the cloudWise application")
    public static void iLaunchCloudWiseApp() {
        browser.manage().deleteAllCookies();
        browser.get(prop.getProperty("cloudWiseURL"));
        browser.manage().window().maximize();
        compareExpectedWithActual("Cloudwise helpt scholen met moderne ICT oplossingen | Cloudwise", browser.getTitle());
        waitForElementToBeVisible(CloudWisePage.acceptCookie);
        if (CloudWisePage.acceptCookie.isDisplayed()){
            CloudWisePage.acceptCookie.click();
        }
        waitForElementToBeVisible(CloudWisePage.ditIsCloudWise);
    }

    @When("I click on dit is cloudwise")
    public static void iClickOnDitIsCloudwise() throws InterruptedException {
        CloudWisePage.ditIsCloudWise.click();
        compareExpectedWithActual("Dit is Cloudwise - Cloudwise", browser.getTitle());
    }

    @When("I click on alle cloudwisers")
    public static void iClickOnAllCloudwisers() throws InterruptedException {
        ElementHelpers.scrollIntoViewPort(CloudWisePage.alleCloudWisers.get(0));
        waitForElementToBeVisible(CloudWisePage.alleCloudWisers.get(0));
        ElementHelpers.mouseHoverAction(CloudWisePage.carouselItems.get(0));
        Thread.sleep(1000);
        waitForElementToBeVisible(CloudWisePage.carouselItems.get(0));
        CloudWisePage.carouselItems.get(0).click();
        ElementHelpers.scrollIntoViewPort(CloudWisePage.alleCloudWisers.get(0));
        waitForElementToBeVisible(CloudWisePage.departmentNames.get(0));
    }

    @Then("Get all the employee names from all the departments and check for duplicate names")
    public static void getAllTheEmployeeFromEachDepartments() throws InterruptedException {
        System.out.println("Number of Departments in Cloudwise : " + CloudWisePage.departmentNames.size());
        ArrayList employeeList = null;
        employeeList = new ArrayList<String>();
        for (int i = 0; i < CloudWisePage.departmentNames.size(); i++) {
            System.out.println("Department Name : " + CloudWisePage.departmentNames.get(i).getText());
            ElementHelpers.scrollIntoViewPort(CloudWisePage.alleCloudWisers.get(i));
            ElementHelpers.mouseHoverAction(CloudWisePage.carouselItems.get(i));
            Thread.sleep(1000); // TBD refactor by doing more analysis
            CloudWisePage.carouselItems.get(i).click();
            System.out.println("Employee size is : " + CloudWisePage.employeeNames.size());
            for (int j = 0; j < CloudWisePage.employeeNames.size(); j++) {
                String employeeName = CloudWisePage.employeeNames.get(j).getText().toString();
                System.out.println("Employee Name is : " + employeeName);
                employeeList.add(employeeName);
            }
            browser.navigate().back();
            waitForElementToBeVisible(CloudWisePage.carouselItems.get(0));
        }
        // get list of duplicate employee names from full employee list
        System.out.println("Total Employees in cloudwise is " + employeeList.size());
        getListOfDuplicateEmployeesName(employeeList);
    }
}

