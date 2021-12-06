
# test automation - cloudwise assignment
    
     1.cloudwise assignment is about to get all the employees from all the departments of cloudwise
      also get the list of duplicate employees names(print the output)
    
     2.gatekeeper challenge assignment is about covering all possible scenarios to automate it

## Concepts Included in Framework
    
    -Page object modal
    -BDD approach for features to define scenarios in simple language
    -Commonly used test utility classes
    -Enabled for CT

## Tools
    
    -Selenium WebDriver
    -Maven
    -Cucumber-JVM
    -JUnit

## Requirements

In order make this project up and running you need to have the following configuration settings :
    
    -SDK configuration under file browser for latest JDK installed in your machine
    -Once you are able to see java class files are loaded as expected as you are good to go for next step

## To Run

The Project is for Functional UI Automation testing , Before running this project read below steps for smooth execution
    
    -To Run in chrome or firefox browser , make sure you have updated in application.properties file
    -To Run in headLess mode by default settings should be true
    -To Run from terminal go to project path as cloudwise_test and run command as mvn clean install
    -To Run from runner class RunnerTest under itRunner package use Run button


## Reporting

In this project I have used cucumber reports , which gives more info on each steps by taking screenshots when failure :
you can go to this path for html report: \target\site\cucumber-pretty\index.html

## Test-outputs
    
    -Tested in Windows OS 10
    -Tested in Firefox browser

## Observations
    
    -While doing search scenario enter key press functionality is not working through script
    -Scenario Our address needs to be verified"is failing when executed in headless mode(Scrollintoviewport option is not working)






